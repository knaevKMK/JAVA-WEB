import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { httpConfigHeader, httpIfHeader } from 'src/app/models/http';
import { Profile, SetUser } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = "http://localhost:8080/api/identity";

  _isLoggedIn = new BehaviorSubject<boolean>(this.getToken() != null);

  constructor(private http: HttpClient) {
  }


  emit(value: any) {
    this._isLoggedIn.next(value);
  }

  onLogin(data: any): Observable<any> {
    return this.http.post(this.url + "/login", data);
  }
  onRegister(data: any): Observable<any> {
    return this.http.post(this.url + "/register", data);
  }
  onLogout() {
    this.http.get(this.url + "/logout", httpIfHeader())
      .subscribe(result => console.log(result));
    localStorage.clear();
  }
  onConfirmRegistration(url: string) {
    return this.http.get(url);
  }
  saveToken(token: any) {
    localStorage.setItem('token', token);
  }
  saveUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }
  getUser(): any {
    return localStorage.getItem('user');
  }
  getToken() {
    return localStorage.getItem('token')
  }
  getLoggedUser() {
    return this.http.get(this.url + "/user", httpIfHeader());
  }
  get isLoggedIn() { return this._isLoggedIn.asObservable() }
  get loggedUser() { return (JSON.parse(this.getUser())); }
}
