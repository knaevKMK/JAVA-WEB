import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string;
  constructor(@Inject('BASE_URL') baseUrl: string,
    private http: HttpClient) {
    this.url = baseUrl + "api/identity"
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

  private saveUser(user: any) {
    localStorage.setItem('user', user);
  }
  getUser() {
    return localStorage.getItem('user')
  }
}
