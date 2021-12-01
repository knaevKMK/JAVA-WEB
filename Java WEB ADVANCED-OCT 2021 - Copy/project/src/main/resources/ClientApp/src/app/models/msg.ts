import { Validators } from "@angular/forms";

export function MailForm() {
    return {
        listingId: [null, Validators.required],
        // senderUsername: [null, Validators.required],
        recipientUsername: [null, Validators.required],
        text: [null, Validators.required]
    }
}

export class Msg {
    id: string = '';
    listingId: string = '';
    title: string = '';
    recipient: string = '';
    sender: string = '';
    createOn: any = Date.now;
    text: string = '';
}
export class openMsg {
    id: string = '';
    listing: any = {
        id: '',
        imageUrl: '',
        title: '', price: 0
    }
        ;
    title: string = '';
    recipient: string = '';
    sender: string = '';
    createOn: any = Date.now;
    text: string = '';

}