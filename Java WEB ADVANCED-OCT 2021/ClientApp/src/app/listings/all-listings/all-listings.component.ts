import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Filter } from 'src/app/models/filter';
import { ListingInListView } from 'src/app/models/listing';
import { responceListings } from 'src/app/models/response';
import { ListingService } from 'src/app/service/listing.service';

@Component({
  selector: 'app-all-listings',
  templateUrl: './all-listings.component.html',
  styleUrls: ['./all-listings.component.css']
})
export class AllListingsComponent implements OnInit {
  query: any = new Filter();
  listings: ListingInListView[] = [];

  constructor(
    private listingService: ListingService,
    private activateRoute: ActivatedRoute
  ) {
    this.activateRoute.queryParams
      .subscribe(params => {

        this.listingService.getAll(this.loadQuery(Object(params)))
          .subscribe(result => {
            console.log(Object(result))
            this.listings = responceListings(result)
          })
      });


  }
  ngOnInit(): void {
  }
  loadQuery(data: any) {
    // console.log(data)
    var result = "";
    Object.keys(this.query)
      .forEach(key => {
        if (data[key] !== undefined) {
          result += key + "=" + data[key]
        }
      })
    //   console.log(result)
    return result;
  }
}
