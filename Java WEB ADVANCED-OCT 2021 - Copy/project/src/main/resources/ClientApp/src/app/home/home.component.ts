import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: [
  ]
})
export class HomeComponent implements OnInit {

  listingsWatch: string = "filter=watchlist";
  listingsDaily: string = "filter=daily_deals";
  all: string = "";
  constructor() { }

  ngOnInit(): void {

  }


}

