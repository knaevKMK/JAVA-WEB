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
  errors: any = new Errors();
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
    this.errors = new Errors();
    console.log(this.registerForm.value);
    this.authService.onRegister(this.registerForm.value).subscribe(
      data => {
        console.log(data)
        switch (data.statusCode) {
          case 200: this.router.navigate(['/usr/signin']); break;
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

  get firstName() { return this.registerForm.get('firstName') }
  get lastName() { return this.registerForm.get('lastName') }
  get username() { return this.registerForm.get('username') }
  get email() { return this.registerForm.get('email') }
  get password() { return this.registerForm.get('password') }
  get confirmPassword() { return this.registerForm.get('confirmPassword') }
}

export class Errors {
  fatalError: string[];
  firstName: string[];
  lastName: string[];
  username: string[];
  email: string[];
  password: string[];
  confirmPassword: string[];
  constructor() {
    this.fatalError = [];
    this.firstName = [];
    this.lastName = [];
    this.username = [];
    this.email = [];
    this.password = [];
    this.confirmPassword = []
  }
}