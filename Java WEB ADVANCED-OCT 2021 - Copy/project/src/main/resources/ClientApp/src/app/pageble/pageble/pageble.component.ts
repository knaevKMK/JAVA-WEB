import { Component, Inject, OnInit } from '@angular/core';
import { Page } from '../page';

@Component({
  selector: 'app-pageble',
  templateUrl: './pageble.component.html',
  styles: [
  ]
})
export class PagebleComponent implements OnInit {
  // @Inject('page') page!: number;
  // @Inject('limit') limit!: number;
  // @Inject('totalPage') totalPage!: number;
  _page: Page;
  constructor() {
    this._page = new Page();
  }

  ngOnInit(): void {
  }

}
