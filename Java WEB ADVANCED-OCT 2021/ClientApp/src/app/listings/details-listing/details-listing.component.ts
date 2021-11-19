import { Component, OnInit } from '@angular/core';
import { ListingView } from 'src/app/models/listing';
import { ActivatedRoute, Router } from '@angular/router';
import { ListingService } from 'src/app/service/listing.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-details-listing',
  templateUrl: './details-listing.component.html',
  styles: [
  ]
})
export class DetailsListingComponent implements OnInit {
  id: string = "";
  listing = new ListingView();
  constructor(private activateRouter: ActivatedRoute,
    private router: Router, private listingService: ListingService,) {

  }

  ngOnInit(): void {
    this.id = this.activateRouter.snapshot.params['id'];

    this.listingService.getById(this.id)
      .subscribe(result => {
        console.log(Object(result)['data']['listing'])
        this.listing = (Object(result)['data']['listing']);
      })
  }
  onEnd(id: string) {
    console.log(id)
  }
}
