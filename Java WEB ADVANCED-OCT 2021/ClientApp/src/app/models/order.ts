import { Validators } from "@angular/forms";
import { OrderService } from "../service/order/order.service";
import { responseOrder } from "./response";


export class Order {
    id: string = '';
    listingId: string = '';
    listingImageUrl: string = '';
    listingTitle: string = '';
    price: number = 0;
    quantity: number = 0;
    deliveryAddress: string = '';
    completed: boolean = false;
    constructor(orderService: OrderService, id: string) {

        orderService.getOrder(id)
            .subscribe(data => {
                console.log(responseOrder(data))
                let order = responseOrder(data);
                this.id = order['id'];
                this.listingId = order['listingId'];
                this.listingTitle = order['listingTitle'];
                this.listingImageUrl = order['listingImageUrl'];
                this.price = order['price'];
                this.quantity = order['quantity'];
                this.deliveryAddress = order['deliveryAddress'];
                this.completed = order['completed']
            })
    }

}
export function OrderFb() {
    return {
        id: [null, Validators.required],
        listingId: [null, Validators.required],
        price: [null, Validators.required],
        quantity: [null, Validators.required],
        deliveryAddress: [null, Validators.required]
    }
}