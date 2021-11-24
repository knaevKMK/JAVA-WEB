import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
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
  constructor(private authService: AuthService) {
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
