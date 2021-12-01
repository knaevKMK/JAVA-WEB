import { Validators } from "@angular/forms";


export function SellingCreateForm() {
    return {
        title: [null, Validators.required],
        duration: [null, Validators.required],
        price: [null, Validators.required],
        quantity: [null, Validators.required],
    }
}

export interface SellingFormatView {

    id: string,
    title: string
    price: number
    duration: number
    quantity: number
}