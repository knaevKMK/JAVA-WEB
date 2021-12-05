import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Filter } from 'src/app/models/filter';
import { ListingInListView } from 'src/app/models/listing';
import { ApiResponse, responceListings, responsePageble } from 'src/app/models/response';
import { Page } from 'src/app/pageble/page';
import { ListingService } from 'src/app/service/listing.service';

@Component({
  selector: 'app-all-listings',
  templateUrl: './all-listings.component.html',
  styleUrls: ['./all-listings.component.css']
})
export class AllListingsComponent implements OnInit {
  pageble: Page = new Page();
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
            this.pageble = responsePageble(result);
            console.log(this.pageble)
            console.log(ApiResponse(result).getListings)
            this.listings = ApiResponse(result).getListings
          })
      });


  }
  ngOnInit(): void {
  }
  loadQuery(data: any) {
    // console.log(data)
    var result = "";
    Object.keys(data)
      .forEach(key => {
        if (data[key] !== undefined) {
          result += key + "=" + data[key] + '&'
        }
      })
    console.log(result)
    return result == ''
      ? result
      : result.slice(0, result.length - 1);
  }

  nextClick() {
    if (this.pageble.page < this.pageble.totalPages - 1) {
      this.getPage(++this.pageble.page);
    }
  }

  previousClick() {
    if (this.pageble.page > 0) {
      this.getPage(--this.pageble.page);
    }
  }
  getPage(page: number) {
    console.log(this.query)
    console.log(page)
    this.activateRoute.queryParams
      .subscribe(params => {
        let _params = Object.assign({ "page": page, "limit": 3 }, Object(params));
        console.log(_params)
        console.log(this.query)
        //      return;
        this.listingService.getAll(this.loadQuery(_params))
          .subscribe(result => {
            console.log(responsePageble(result))
            this.pageble = responsePageble(result);
            console.log(ApiResponse(result).getListings)
            this.listings = ApiResponse(result).getListings
          })
      });
  }
}
