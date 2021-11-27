import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Order, OrderFb } from 'src/app/models/order';
import { responceConfirm, responsePurchases } from 'src/app/models/response';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {
  confirmForm: FormGroup;
  orders: Order[] = [];
  constructor(private orderService: OrderService,
    private fb: FormBuilder) {
    this.confirmForm = this.fb.group(OrderFb());
    this.orderService.getPruchases('basket')
      .subscribe(data => {
        console.log(responsePurchases(data))
        this.orders = responsePurchases(data);
      })
  }
  onCancel(id: string) {
    console.log(id)
    this.orderService.cancel(id)
      .subscribe(data => {
        console.log(data)
        if (Object(data)['data']['delete']) {

          // this.orderService.getPruchases('basket')
          //   .subscribe(data => {
          //     console.log(responsePurchases(data))
          //     this.orders = responsePurchases(data);
          //   })
        }
        console.log(data)
      })
  }
  ngOnInit(): void {
  }
  onConfirm() {

    console.log(this.confirmForm.value)

    if (this.confirmForm.value['deliveryAddress'] === null || new String(this.confirmForm.value['deliveryAddress']).trim() === '') {
      return alert("Delivery address Required")
    }
    if (this.confirmForm.value['quantity'] <= 0) {
      this.confirmForm.value['quantity'] = 1;
      return alert("Quantity must be greater than 0")
    }

    this.orderService.confirm(this.confirmForm.value)
      .subscribe(data => {
        console.log((data))
        //    window.location.reload();
        console.log(data);
        this.orderService.getPruchases('basket')
          .subscribe(data => {
            console.log(responsePurchases(data))
            this.orders = responsePurchases(data);
          })

      }
        , err => { console.log(err) })
  }
}
