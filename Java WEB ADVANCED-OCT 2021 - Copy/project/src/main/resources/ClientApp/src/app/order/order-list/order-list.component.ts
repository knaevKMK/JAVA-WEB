import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { responsePurchases } from 'src/app/models/response';
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
        this.orders = responsePurchases(data);
      })
  }
  onCancel(id: string) {
    console.log(id)
    this.orderService.cancel(id)
      .subscribe(data => {
        console.log(data)
        if (Object(data)['data']['delete']) {

          this.orderService.getPruchases('all')
            .subscribe(data => {
              console.log(responsePurchases(data))
              this.orders = responsePurchases(data);
            })
        }
        console.log(data)
      })
  }
  ngOnInit(): void {
  }

}
