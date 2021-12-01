import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellingFormatService {

  private url = "http://localhost:8080/api/selling-format";
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.url + "/all")
  }
}
