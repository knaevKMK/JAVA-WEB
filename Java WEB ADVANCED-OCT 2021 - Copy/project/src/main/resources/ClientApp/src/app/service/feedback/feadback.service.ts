import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { httpIfHeader } from 'src/app/models/http';

@Injectable({
  providedIn: 'root'
})
export class FeadbackService {
  url: string = "http://localhost:8080/api/feedback";
  constructor(private http: HttpClient) { }


  getAll(query: string) {
    return this.http.get(this.url + "/all?query=" + query, httpIfHeader());
  }
  left(data: any) {
    return this.http.post(this.url + "/add", data, httpIfHeader());
  }
  response(id: string, data: any) {
    return this.http.put(this.url + "/response/" + id, data, httpIfHeader());
  }


}
