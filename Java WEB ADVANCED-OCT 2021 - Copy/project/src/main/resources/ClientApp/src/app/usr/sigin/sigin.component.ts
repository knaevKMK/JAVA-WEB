import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { responseError, setErrors, UserRegisterErrors } from 'src/app/models/errors';
import { ApiResponse, responceToken, responeseUser } from 'src/app/models/response';
import { AuthService } from 'src/app/service/usr/auth.service';

@Component({
  selector: 'app-sigin',
  templateUrl: './sigin.component.html',
  styles: [
  ]
})
export class SiginComponent implements OnInit {

  signInForm: FormGroup;
  errors: any = new UserRegisterErrors();

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService) {
    this.signInForm = this.fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required],
    });
  }

  ngOnInit(): void {
  }
  async onSignIn() {
    this.errors = new UserRegisterErrors();
    console.log(this.signInForm.value);
    await this.authService.onLogin(this.signInForm.value).subscribe(
      data => {
        console.log(Object(data));
        switch (data.statusCode) {
          case 200:
            this.authService.saveToken(responceToken(data));
            console.log(this.authService.getToken())
            this.authService.getLoggedUser().subscribe(result => {
              console.log(ApiResponse(result).getUser)
              this.authService.saveUser(responeseUser(result));
              this.router.navigate(['listing/all']);
            })
            break;
          default:
            console.log(Object(data)['errors']['errors'])
            this.errors.fatalError.push(responseError(data)); break;
        }
      }
      , err => {
        console.log(Object(err)['error']['errors'])
        this.errors = setErrors(err, this.errors);
      });
  }

  get username() { return this.signInForm.get('username') }
  get password() { return this.signInForm.get('password') }

}
