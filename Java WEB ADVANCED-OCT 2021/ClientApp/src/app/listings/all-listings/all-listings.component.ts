import { Component, OnInit } from '@angular/core';
import { ListingInListView } from 'src/app/models/listing';
import { ListingService } from 'src/app/service/listing.service';

@Component({
  selector: 'app-all-listings',
  templateUrl: './all-listings.component.html',
  styleUrls: ['./all-listings.component.css']
})
export class AllListingsComponent implements OnInit {
  listings: ListingInListView[] = [];
  constructor(private listingService: ListingService) {
    this.listingService.getAll()
      .subscribe(result => {
        console.log(Object(result)['data']['listings'])
        this.listings = Object(result)['data']['listings']
      })

  }

  ngOnInit(): void {

  }

}
