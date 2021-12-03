import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MailForm } from 'src/app/models/msg';
import { MsgService } from 'src/app/service/msg/msg.service';

@Component({
  selector: 'app-msg-form',
  templateUrl: './msg-form.component.html',
  styleUrls: ['./msg-form.component.css']
})
export class MsgFormComponent implements OnInit {
  @Input('order') orderId: string = '';
  @Input('list') listId: string = '';
  @Input('recipient') recipient: string = '';

  mailCreate: FormGroup;
  constructor(private msgService: MsgService, private fb: FormBuilder) {
    this.mailCreate = this.fb.group(MailForm());
  }

  ngOnInit(): void {
  }
  onSend() {
    this.mailCreate.value.listingId = this.listId;
    this.mailCreate.value.recipientUsername = this.recipient;
    console.log(this.mailCreate.value)

    this.msgService.send(this.mailCreate.value)
      .subscribe(data => {
        console.log(data)
      })
    this.mailCreate.reset

  }
  onCancel() {
    this.mailCreate.reset;
  }
}
