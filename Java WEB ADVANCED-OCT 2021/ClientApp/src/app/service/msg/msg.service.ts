import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { httpIfHeader } from 'src/app/models/http';

@Injectable({
  providedIn: 'root'
})
export class MsgService {
  private url = "http://localhost:8080/api/msg";
  constructor(private http: HttpClient) {
  }

  send(data: any) {
    return this.http.post(this.url + "/send", data, httpIfHeader())
  }
  getAll(query: string) {
    return this.http.get(this.url + "/all?query=" + query, httpIfHeader())
  }
  getById(id: string) {
    return this.http.get(this.url + "/" + id, httpIfHeader())
  }
  getDelete(id: string) {
    return this.http.delete(this.url + "/delete/" + id, httpIfHeader())
  }
}
