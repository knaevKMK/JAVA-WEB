import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { responseError, setErrors, UserRegisterErrors } from 'src/app/models/errors';
import { responceConfirm } from 'src/app/models/response';
import { AuthService } from 'src/app/service/usr/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: [
  ]
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  errors: any = new UserRegisterErrors();
  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService) {
    this.registerForm = this.fb.group({

      'firstName': ['', Validators.required],
      'lastName': ['', Validators.required],
      'username': ['', Validators.required],
      'email': ['', Validators.required],
      'password': ['', Validators.required],
      'confirmPassword': ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }
  onRegister() {
    this.errors = new UserRegisterErrors();
    this.authService.onRegister(this.registerForm.value).subscribe(
      data => {
        console.log(data)
        switch (data.statusCode) {
          case 200:
            //   console.log(data)
            this.onLoadRegistration(responceConfirm(data));

            ; break;
          default:
            this.errors.fatalError.push(responseError(data)); break;
        }
      }
      , err => {
        //   console.log(Object(err)['error']['errors'])
        this.errors = setErrors(err, this.errors)
      });
  }
  onLoadRegistration(url: string) {
    var enable = confirm("Please Confirm your registration")
    if (enable) {
      console.log(url)
      this.authService.onConfirmRegistration(url).subscribe(result => console.log(result));
    }
    this.router.navigate(['/usr/signin'])
  }
  get firstName() { return this.registerForm.get('firstName') }
  get lastName() { return this.registerForm.get('lastName') }
  get username() { return this.registerForm.get('username') }
  get email() { return this.registerForm.get('email') }
  get password() { return this.registerForm.get('password') }
  get confirmPassword() { return this.registerForm.get('confirmPassword') }
}
