import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse, responceListings } from 'src/app/models/response';
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
  ) {
    this.isloggedUser = Object(this.authService.isLoggedIn)['source']['value'];
    this.loggedUser = this.authService.loggedUser
  }

  ngOnInit(): void {
    console.log(this.isloggedUser)
    console.log(this.loggedUser)
  }
  onLogout() {
    console.log("logout");
    console.log(this.authService.getUser())
    this.authService.onLogout();
    window.location.reload();
  }
}
