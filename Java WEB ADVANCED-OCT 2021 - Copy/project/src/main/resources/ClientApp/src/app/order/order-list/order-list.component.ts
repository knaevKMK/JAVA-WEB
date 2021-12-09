import { Component, OnInit } from '@angular/core';
import { ErrorResponse } from 'src/app/models/errors';
import { Order } from 'src/app/models/order';
import { ApiResponse, responsePurchases } from 'src/app/models/response';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  orders: Order[] = [];
  constructor(private orderService: OrderService) {
    this.orderService.getPruchases('all')
      .subscribe(data => {
        console.log(responsePurchases(data))
        this.orders = ApiResponse(data).getPurchses;
      })
  }
  onCancel(id: string) {
    console.log(id)
    this.orderService.cancel(id)
      .subscribe(data => {
        console.log(ApiResponse(data))
        if (ApiResponse(data).isDelete) {

          this.orderService.getPruchases('all')
            .subscribe(data => {
              console.log(ApiResponse(data).getPurchses)
              this.orders = ApiResponse(data).getPurchses;
            })
        }
        console.log(data)
      }, err => ErrorResponse(err))
  }
  ngOnInit(): void {
  }

}
