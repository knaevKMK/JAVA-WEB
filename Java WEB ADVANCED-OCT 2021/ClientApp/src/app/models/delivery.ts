import { Validators } from "@angular/forms";


export function DeliveryCreateForm() {
    return {
        deliveryService: [null, Validators.required],
        price: [null, Validators.required],
    }
}

export interface DeliveryView {
    deliveryArea: string,
    deliveryService: string[],
    price: number
}