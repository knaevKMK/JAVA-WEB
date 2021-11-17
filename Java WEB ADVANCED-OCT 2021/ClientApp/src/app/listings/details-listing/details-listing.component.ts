import { Component, OnInit } from '@angular/core';
import { ListingView } from 'src/app/models/listing';

@Component({
  selector: 'app-details-listing',
  templateUrl: './details-listing.component.html',
  styles: [
  ]
})
export class DetailsListingComponent implements OnInit {
  id: string = "";
  listing = new ListingView();
  constructor() { }

  ngOnInit(): void {
  }

}
