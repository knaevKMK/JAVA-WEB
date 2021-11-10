import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListingService {
  private url: string;
  constructor(private http: HttpClient, @Inject('BASE_URL') baseUrl: string) {
    this.url = baseUrl + "api/listings";
  }

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
