import { Validators } from "@angular/forms";

export function FeedbackLeftForm() {
    return {
        orderId: [null, Validators.required],
        ownerListingUsername: [null, Validators.required],
        request: [null, Validators.required],
        positive: [null, Validators.required],

    }
}

export function FeedbackResponseForm() {
    return {
        orderId: [null, Validators.required],
        request: [null, Validators.required],
    }
}