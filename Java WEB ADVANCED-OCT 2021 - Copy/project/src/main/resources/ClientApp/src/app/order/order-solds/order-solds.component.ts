import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { ApiResponse, responsePurchases } from 'src/app/models/response';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-order-solds',
  templateUrl: './order-solds.component.html',
  styleUrls: ['./order-solds.component.css']
})
export class OrderSoldsComponent implements OnInit {
  orders: Order[] = [];
  constructor(private orderService: OrderService) {
    this.orderService.getSolds()
      .subscribe(data => {

        this.orders = ApiResponse(data).getOrders;// Object(data)['data']['orders'];
      })
  }
  onCancel(id: string) {
    console.log(id)
    this.orderService.cancel(id)
      .subscribe(data => {
        console.log(data)
        if (ApiResponse(data).isDelete) {

          this.orderService.getSolds()
            .subscribe(data => {
              console.log(ApiResponse(data).getOrders)
              this.orders = ApiResponse(data).getOrders;
            })
        }
      })
  }
  ngOnInit(): void {
  }

}
