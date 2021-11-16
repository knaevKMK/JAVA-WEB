import { FormBuilder, Validators } from "@angular/forms";
export function ListingCreateForm(fb: FormBuilder) {
    return {
        id: [null, Validators.required],
        title: [null, Validators.required],
        description: [null, Validators.required],
        imageUrl: [null, Validators.required],
        condition: fb.group(ConditionCreateForm()),
        category: fb.group(CategoryCreateForm()),
        sellingFormat: fb.group(SellingCreateForm()),
        deliveryOptions: fb.group(DeliveryCreateForm()),
        payment: [null, Validators.required],
    }
}
function ConditionCreateForm() {
    return {
        title: [null, Validators.required],
        id: [null, Validators.required],
    };
}
function CategoryCreateForm() {
    return {
        title: [null, Validators.required],
        parentTitle: [null, Validators.required],
        id: [null, Validators.required],
    }
}
function DeliveryCreateForm() {
    return {
        deliveryService: [null, Validators.required],
        price: [null, Validators.required],
    }
}
function SellingCreateForm() {
    return {
        title: [null, Validators.required],
        daysDuration: [null, Validators.required],
        price: [null, Validators.required],
        quantity: [null, Validators.required],
    }
}