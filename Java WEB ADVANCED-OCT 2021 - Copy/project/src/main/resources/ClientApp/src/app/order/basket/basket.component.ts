import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ErrorResponse } from 'src/app/models/errors';
import { Order, OrderFb } from 'src/app/models/order';
import { ApiResponse } from 'src/app/models/response';
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

  }
  onCancel(id: string) {
    console.log(id)

    this.orderService.cancel(id)
      .subscribe(data => {
        console.log(data)
        console.log(ApiResponse(data).isDelete)
        if (ApiResponse(data).isDelete) {
          this.ngOnInit();
        }
      }, err => {
        console.log(err);
        ErrorResponse(err)
      })
  }
  ngOnInit(): void {
    this.orderService.getPruchases('basket')
      .subscribe(data => {
        this.orders = ApiResponse(data).getPurchses;
      }, err => {
        console.log(err);
        ErrorResponse(err)
      })
  }
  onConfirm() {
    if (this.confirmForm.value['deliveryAddress'] === null || new String(this.confirmForm.value['deliveryAddress']).trim() === '') {
      return alert("Delivery address Required")
    }
    if (this.confirmForm.value['quantity'] <= 0) {
      this.confirmForm.value['quantity'] = 1;
      return alert("Quantity must be greater than 0")
    }

    this.orderService.confirm(this.confirmForm.value)
      .subscribe(data => this.ngOnInit()
        , err => {
          console.log(err);
          ErrorResponse(err)
        })
  }
}
