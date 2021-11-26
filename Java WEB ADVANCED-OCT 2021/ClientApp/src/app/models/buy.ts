import { FormBuilder, Validators } from "@angular/forms";


export function BuyForm(fb: FormBuilder) {
    return {
        id: [null, Validators.required],
        price: [null, Validators.required],
        quantity: [null, Validators.required],


    }
}