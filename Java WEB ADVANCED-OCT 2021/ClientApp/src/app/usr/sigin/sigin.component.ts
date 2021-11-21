import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/usr/auth.service';
import { Errors } from '../register/register.component';

@Component({
  selector: 'app-sigin',
  templateUrl: './sigin.component.html',
  styles: [
  ]
})
export class SiginComponent implements OnInit {

  signInForm: FormGroup;
  errors: any = new Errors();

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService) {
    this.signInForm = this.fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required],
    });
  }

  ngOnInit(): void {
  }
  onSignIn() {
    this.errors = new Errors();
    console.log(this.signInForm.value);
    this.authService.onLogin(this.signInForm.value).subscribe(
      data => {
        console.log(Object(data));
        switch (data.statusCode) {
          case 200:
            console.log(Object(data)['data']['login']['token'])
            this.authService.saveUser(Object(data)['data']['login']['token']);
            this.router.navigate(['/']);
            break;
          default:
            console.log(Object(data)['errors']['errors'])
            this.errors.fatalError.push(Object(data)['errors']['errors']); break;
        }


      }
      , err => {
        console.log(Object(err)['error']['errors'])
        let responce: [] = (Object(err)['error']['errors']);
        (responce.forEach(e => {
          let field = e['field'];
          let error_ = e['defaultMessage']
          this.errors[field].push(error_);
        }));
      });
  }

  get username() { return this.signInForm.get('username') }
  get password() { return this.signInForm.get('password') }

}
