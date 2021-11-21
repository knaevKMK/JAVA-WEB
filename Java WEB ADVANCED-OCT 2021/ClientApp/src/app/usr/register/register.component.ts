import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/usr/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: [
  ]
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  errors = new RegErrors();
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
    console.log(this.registerForm.value);
    this.authService.onRegister(this.registerForm.value).subscribe(
      data => {
        console.log(data)
        this.router.navigate(['/usr/signin'])
      }
      , err => {
        if (err.status = 400) {
          console.log(err);

          //   this.errors = err.error.errors;
        }
      });
  }

  get firstName() { return this.registerForm.get('firstName') }
  get lastName() { return this.registerForm.get('lastName') }
  get username() { return this.registerForm.get('username') }
  get email() { return this.registerForm.get('email') }
  get password() { return this.registerForm.get('password') }
  get confirmPassword() { return this.registerForm.get('confirmPassword') }
}
class RegErrors {

  Username: string[];
  Email: string[];
  Password: string[];
  ConfirmPassword: string[];

  constructor() {
    this.Username = [];
    this.Email = [];
    this.Password = [];
    this.ConfirmPassword = [];
  }
}