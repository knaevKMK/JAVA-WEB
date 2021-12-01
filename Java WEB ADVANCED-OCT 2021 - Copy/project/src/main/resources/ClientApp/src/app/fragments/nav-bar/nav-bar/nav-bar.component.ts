import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { responceListings } from 'src/app/models/response';
import { ListingService } from 'src/app/service/listing.service';
import { AuthService } from 'src/app/service/usr/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styles: [
  ]
})
export class NavBarComponent implements OnInit {

  isloggedUser: Observable<boolean>;
  loggedUser: any;
  watchlist = [];
  alert = [];
  constructor(private authService: AuthService,
    private listingService: ListingService) {
    // this.listingService.getWatchList()
    //   .subscribe(result => {
    //     console.log(responceListings(result));
    //     this.watchlist = responceListings(result)
    //   });
    this.isloggedUser = this.authService.isLoggedIn;
    this.loggedUser = this.authService.loggedUser;
    console.log(this.authService.getUser())
  }

  ngOnInit(): void {
    this.isloggedUser = this.authService.isLoggedIn;
    this.loggedUser = (JSON.parse(this.authService.getUser()));
  }
  onLogout() {
    console.log("logout");
    console.log(this.authService.getUser())
    this.authService.onLogout();
    window.location.reload();
  }
}
