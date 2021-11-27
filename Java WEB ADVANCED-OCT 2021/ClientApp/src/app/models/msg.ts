import { Validators } from "@angular/forms";

export function MailForm() {
    return {
        listingId: [null, Validators.required],
        // senderUsername: [null, Validators.required],
        recipientUsername: [null, Validators.required],
        text: [null, Validators.required]
    }
}