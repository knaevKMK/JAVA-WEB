import { Component, Input, OnInit } from '@angular/core';
import { ListingInListView } from 'src/app/models/listing';
import { responceListings } from 'src/app/models/response';
import { ListingService } from 'src/app/service/listing.service';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styles: [
  ]
})
export class CarouselComponent implements OnInit {
  @Input('query') query: string = '';

  startIndex = 0;
  lastIndex = 2;
  listings: ListingInListView[] = [];
  mediator: ListingInListView[] = [];
  constructor(private listingService: ListingService) {

  }

  ngOnInit(): void {
    console.log(this.query)
    this.listingService.getAll(this.query)
      .subscribe(result => {
        console.log(this.query)
        console.log(Object(result))
        this.listings = responceListings(result)
        this.mediator = this.listings.slice(0, 3)// [this.listings[0], this.listings[1], this.listings[2]];
      })

  }
  leftClick() {
    console.log('Left')

    if (this.startIndex === 0) {
      this.startIndex = this.listings.length - 1
      this.lastIndex--
      this.mediator.unshift(this.listings[this.listings.length - 1])
      this.mediator.pop()
    }
    else if (this.lastIndex === 0) {
      this.lastIndex = this.listings.length - 1
      this.startIndex--
      this.mediator.unshift(this.listings[this.startIndex])
      this.mediator.pop()
    }
    else {
      this.startIndex--
      this.lastIndex--
      this.mediator.unshift(this.listings[this.startIndex])
      this.mediator.pop()
    }

    return
  }
  rightClick() {
    console.log('Right')
    if (this.listings.length < 3) { return }
    if (this.lastIndex === this.listings.length - 1) {
      this.lastIndex = 0
      this.startIndex++
      this.mediator.shift()
      this.mediator.push(this.listings[0])
    }
    else if (this.startIndex === this.listings.length - 1) {
      this.startIndex = 0
      this.lastIndex++
      this.mediator.shift()
      this.mediator.push(this.listings[this.lastIndex])
    }
    else {
      this.startIndex++
      this.lastIndex++
      this.mediator.shift()
      this.mediator.push(this.listings[this.lastIndex])
    }
  }
}
