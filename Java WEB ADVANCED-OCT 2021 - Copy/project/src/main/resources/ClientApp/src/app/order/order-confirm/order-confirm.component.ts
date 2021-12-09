import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorResponse } from 'src/app/models/errors';
import { Order, OrderFb } from 'src/app/models/order';
import { responceConfirm, responseOrder } from 'src/app/models/response';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-order-confirm',
  templateUrl: './order-confirm.component.html',
  styleUrls: ['./order-confirm.component.css']
})
export class OrderConfirmComponent implements OnInit {
  id = this.activateRoute.snapshot.params['id'];
  confirmForm: FormGroup;
  order: any;

  constructor(
    private orderService: OrderService,
    private fb: FormBuilder,
    private router: Router,
    private activateRoute: ActivatedRoute,) {
    this.id = this.activateRoute.snapshot.params['id'];
    this.order = new Order(this.orderService, this.id);
    this.confirmForm = this.fb.group(OrderFb());

  }
  onConfirm() {
    this.confirmForm.value['quantity'] = this.confirmForm.value['quantity'] == null ? this.order.quantity : this.confirmForm.value['quantity'];
    console.log(this.confirmForm.value)
    if (this.confirmForm.value['deliveryAddress'] === null || new String(this.confirmForm.value['deliveryAddress']).trim() === '') {
      return alert("Delivery address Required")
    }
    if (this.confirmForm.value['quantity'] <= 0) {
      this.confirmForm.value['quantity'] = 1;
      return alert("Quantity must be greater than 0")
    }
    this.confirmForm.value['id'] = this.order.id;
    this.confirmForm.value['price'] = this.order.price;
    this.confirmForm.value['listingId'] = this.order.listingId;
    this.orderService.confirm(this.confirmForm.value)
      .subscribe(data => {
        console.log((data))
        //    window.location.reload();
        alert("Order was confirmed")
        this.order = new Order(this.orderService, responceConfirm(data));
      }
        , err => {
          console.log(err);
          ErrorResponse(err)
        })
  }
  ngOnInit(): void {
    console.log(this.order)
  }

}
