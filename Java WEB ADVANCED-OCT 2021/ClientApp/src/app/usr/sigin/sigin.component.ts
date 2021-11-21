import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/usr/auth.service';

@Component({
  selector: 'app-sigin',
  templateUrl: './sigin.component.html',
  styles: [
  ]
})
export class SiginComponent implements OnInit {

  signInForm: FormGroup;
  errors = new SignInErrors();

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService) {
    this.signInForm = this.fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required],
    });
  }

  ngOnInit(): void {
  }
  onSignIn() {
    console.log(this.signInForm.value);
    this.authService.onLogin(this.signInForm.value).subscribe(
      data => {
        console.log(Object(data)['data']['login']['token'])
        this.authService.saveUser(Object(data)['data']['login']['token']);
        this.router.navigate(['/'])
      }
      , err => {
        if (err.status = 400) {
          console.log(err);

          //   this.errors = err.error.errors;
        }
      });
  }

  get username() { return this.signInForm.get('username') }
  get password() { return this.signInForm.get('password') }

}
class SignInErrors {

  Username: string[];
  Password: string[];

  constructor() {
    this.Username = [];
    this.Password = [];
  }
}