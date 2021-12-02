import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FeedbackLeftForm } from 'src/app/models/feedback';
import { ApiResponse } from 'src/app/models/response';
import { FeadbackService } from 'src/app/service/feedback/feadback.service';

@Component({
  selector: 'app-feedback-form',
  templateUrl: './feedback-form.component.html',
  styles: [
  ]
})
export class FeedbackFormComponent implements OnInit {

  @Input('order') orderId: string = '';
  @Input('recipient') recipient: string = '';

  feedbackCreate: FormGroup;
  constructor(private feedService: FeadbackService, private fb: FormBuilder) {
    this.feedbackCreate = this.fb.group(FeedbackLeftForm());
  }

  ngOnInit(): void {
  }
  onLeft() {
    this.feedbackCreate.value.orderId = this.orderId;
    this.feedbackCreate.value.ownerListingUsername = this.recipient;
    console.log(this.feedbackCreate.value)
    this.feedService.left(this.feedbackCreate.value)
      .subscribe(data => {
        console.log(ApiResponse(data).msg)
        //todo notify
        this.feedbackCreate.reset
      })
  }
}
