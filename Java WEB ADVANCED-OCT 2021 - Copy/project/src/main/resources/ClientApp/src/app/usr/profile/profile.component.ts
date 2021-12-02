import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiResponse, responeseUser } from 'src/app/models/response';
import { Profile } from 'src/app/models/user';
import { AccountService } from 'src/app/service/account/account.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styles: [
  ]
})
export class ProfileComponent implements OnInit {
  username: string;
  user: Profile = new Profile();
  constructor(private activateRouter: ActivatedRoute,
    private profileService: AccountService) {
    this.username = this.activateRouter.snapshot.params['username'];
  }

  ngOnInit(): void {
    this.profileService.getProfile(this.username)
      .subscribe(data => {
        console.log(data)
        this.user = ApiResponse(data).getUser;
      })
  }

}
