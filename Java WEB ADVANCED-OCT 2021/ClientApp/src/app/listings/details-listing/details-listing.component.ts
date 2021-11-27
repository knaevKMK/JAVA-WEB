import { Component, OnInit } from '@angular/core';
import { ListingView } from 'src/app/models/listing';
import { ActivatedRoute, Router } from '@angular/router';
import { ListingService } from 'src/app/service/listing.service';
import { responceListing, responseOrder, responseWatch } from 'src/app/models/response';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BuyForm } from 'src/app/models/buy';
import { OrderService } from 'src/app/service/order/order.service';
import { responseError } from 'src/app/models/errors';
import { MailForm } from 'src/app/models/msg';
import { MsgService } from 'src/app/service/msg/msg.service';

@Component({
  selector: 'app-details-listing',
  templateUrl: './details-listing.component.html',
  styles: [
  ]
})
export class DetailsListingComponent implements OnInit {
  id: string = "";
  listing = new ListingView();
  mailCreate: FormGroup;
  buyForm: FormGroup;


  constructor(private activateRouter: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router, private listingService: ListingService,
    private orderService: OrderService,
    private msgService: MsgService) {
    this.buyForm = this.fb.group(BuyForm(fb));
    this.mailCreate = this.fb.group(MailForm());
  }

  ngOnInit(): void {
    this.id = this.activateRouter.snapshot.params['id'];

    this.listingService.getById(this.id)
      .subscribe(result => {
        console.log((result));
        this.listing = (responceListing(result));
      })
  }
  onEnd(id: string) {
    console.log(id)
    this.listingService.delete(id)
      .subscribe(result => {
        console.log(result)
      });
  }
  onBuy() {
    this.buyForm.value['id'] = this.id;
    this.buyForm.value['price'] = this.listing.sellingFormat.price;
    this.buyForm.value['quantity'] = this.buyForm.value['quantity'] ?? 1
    this.orderService.buy(this.buyForm.value)
      .subscribe(result => {
        console.log(result)
        if (Object(result)['statusCode'] == 400) {
          alert(responseError(result))
          return;
        }
        this.router.navigate(['/orders/order/' + responseOrder(result)]);
      }, err => { console.log(err) })
  }

  onWatch() {
    console.log(this.id)
    this.listingService.onWatch(this.id)
      .subscribe(data => {
        console.log(data)
        this.listing.watched = responseWatch(data);
      })
  }
  onSend() {
    this.mailCreate.value.listingId = this.listing.id;
    this.mailCreate.value.recipientUsername = this.listing.createFrom;
    this.msgService.send(this.mailCreate.value)
      .subscribe(data => {
        console.log(data)
      })
    this.mailCreate = this.fb.group(MailForm());

  }
}
