import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpConfigHeader, httpIfHeader } from '../models/http';

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
  getAll(query: string) {
    //console.log(query)
    return this.http.get(this.url + "/all?" + query, httpIfHeader())
  }
  getById(id: string) {
    return this.http.get(this.url + "/listing/" + id, httpIfHeader())
  }
  delete(id: string) {
    return this.http.delete(this.url + "/delete/" + id, httpIfHeader())
  }
  create(data: any) {
    return this.http.post(this.url + "/add", data, httpIfHeader())
  }
  update(id: string, data: any) {
    return this.http.put(this.url + "/update/" + id, data, httpIfHeader())
  }

  getWatchList() {
    return this.http.get(this.url + "/watch-list/", httpIfHeader());
  }
  onWatch(id: string) {
    return this.http.get(this.url + "/watch/" + id, httpIfHeader());
  }
  search(data: any) {
    return this.http.post(this.url + "/adv-search", data, httpIfHeader())
  }
}
