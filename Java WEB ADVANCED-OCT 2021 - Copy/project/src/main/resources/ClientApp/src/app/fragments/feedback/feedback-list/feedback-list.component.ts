import { Component, Input, OnInit } from '@angular/core';
import { FeedbackInList } from 'src/app/models/feedback';
import { FeadbackService } from 'src/app/service/feedback/feadback.service';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent implements OnInit {
  @Input('user') username: string = '';
  feedbacks: FeedbackInList[] = [];
  type: string = 'receiver';

  constructor(private feedbackService: FeadbackService) { }

  ngOnInit(): void {
    this.onBox("receiver")
  }
  onBox(query: string) {
    this.type = query;
    console.log(query)
    console.log(this.username)
    this.feedbackService.getAll(query + "_" + this.username)
      .subscribe(data => {
        console.log(data)
        this.feedbacks = Object(data)['data']['feedbacks']
      })
  }
}
