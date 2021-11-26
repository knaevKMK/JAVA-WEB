import { Component, OnInit } from '@angular/core';
import { ListingView } from 'src/app/models/listing';
import { ActivatedRoute, Router } from '@angular/router';
import { ListingService } from 'src/app/service/listing.service';
import { responceListing, responseOrder, responseWatch } from 'src/app/models/response';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BuyForm } from 'src/app/models/buy';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-details-listing',
  templateUrl: './details-listing.component.html',
  styles: [
  ]
})
export class DetailsListingComponent implements OnInit {
  id: string = "";
  listing = new ListingView();

  buyForm: FormGroup;


  constructor(private activateRouter: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router, private listingService: ListingService,
    private orderService: OrderService) {
    this.buyForm = this.fb.group(BuyForm(fb));
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
}
