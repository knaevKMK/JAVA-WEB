import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private url = "http://localhost:8080/api/categories";
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.url + "/all")
  }
}
