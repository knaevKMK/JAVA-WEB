import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListingService {
  private url = "http://localhost:8080/api/listings";
  constructor(private http: HttpClient) {
  }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'POST'
      // 'Authorization': ''
    })
  };
  getAll() {
    return this.http.get(this.url + "/all")
  }
  getById(id: string) {
    return this.http.get(this.url + "/listing/" + id)
  }
  delete(id: string) {
    return this.http.delete(this.url + "/delete/" + id)
  }
  create(data: any) {
    return this.http.post(this.url + "/add", data)
  }
  update(id: string, data: any) {
    return this.http.put(this.url + "/update/" + id, data)
  }

}
