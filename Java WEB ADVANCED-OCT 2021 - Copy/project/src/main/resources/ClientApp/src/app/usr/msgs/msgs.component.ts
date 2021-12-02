import { Component, OnInit } from '@angular/core';
import { Msg, openMsg } from 'src/app/models/msg';
import { ApiResponse } from 'src/app/models/response';
import { MsgService } from 'src/app/service/msg/msg.service';

@Component({
  selector: 'app-msgs',
  templateUrl: './msgs.component.html',
  styleUrls: ['./msgs.component.css']
})
export class MsgsComponent implements OnInit {
  Msgs: Msg[] = [];
  type: string = 'received';
  openMsg: openMsg = new openMsg();
  constructor(private msgService: MsgService
  ) {
  }

  ngOnInit(): void {
    this.onBox('received');
  }
  onBox(query: string) {
    this.msgService.getAll(query)
      .subscribe(data => {
        console.log(data)
        this.type = query;
        this.Msgs = ApiResponse(data).getMessagess
        this.openMsg = new openMsg();
      })
  }
  onRead(id: string) {
    console.log(id)
    this.msgService.getById(id)
      .subscribe(data => {
        console.log(Object(data))
        this.openMsg = ApiResponse(data).getMessagess
      })
  }
  onDelete(id: string) {
    console.log(id)
    this.msgService.getDelete(id)
      .subscribe(data => {
        console.log(Object(data))
        this.openMsg = new openMsg();
      })
  }

}
