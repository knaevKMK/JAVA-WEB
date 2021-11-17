import { Component, OnInit } from '@angular/core';
import { ListingService } from 'src/app/service/listing.service';

@Component({
  selector: 'app-all-listings',
  templateUrl: './all-listings.component.html',
  styleUrls: ['./all-listings.component.css']
})
export class AllListingsComponent implements OnInit {

  constructor(private listingService: ListingService) { }

  ngOnInit(): void {
    this.listingService.getAll()
      .subscribe(result => {
        console.log(result)
      })
  }

}
