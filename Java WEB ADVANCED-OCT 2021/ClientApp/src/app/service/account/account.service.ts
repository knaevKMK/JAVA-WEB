import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { httpIfHeader } from 'src/app/models/http';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  url: string = "http://localhost:8080/api/account";
  constructor(private http: HttpClient) { }

  getProfile(username: string) {
    return this.http.get(this.url + "/" + username, httpIfHeader());
  }

}
