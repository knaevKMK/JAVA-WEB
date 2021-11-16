import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styles: [
  ]
})
export class NavBarComponent implements OnInit {
  loggedUser = { username: "knev_ka", email: "knev@mail.bg", fullName: "Krasen Kanev", score: 1 }
  watchlist = [];
  alert = [];
  constructor() {
    // this.loggedUser = sessionStorage.getItem("user")

  }

  ngOnInit(): void {
  }
  onLogout() {
    console.log("logout")
  }
}
