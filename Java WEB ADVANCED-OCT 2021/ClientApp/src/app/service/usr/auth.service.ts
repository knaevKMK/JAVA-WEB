import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = "http://localhost:8080/api/identity";
  constructor(private http: HttpClient) {

  }
  onLogin(data: any): Observable<any> {
    return this.http.post(this.url + "/login", data);
  }
  onRegister(data: any): Observable<any> {
    return this.http.post(this.url + "/register", data);
  }
  onLogout() {
    this.http.get(this.url + "/logout", { headers: new HttpHeaders().set('Authorization', 'Bearer ' + this.getUser) })
  }

  saveUser(token: any) {
    localStorage.setItem('token', token);
  }
  getUser() {
    return localStorage.getItem('token')
  }
}
