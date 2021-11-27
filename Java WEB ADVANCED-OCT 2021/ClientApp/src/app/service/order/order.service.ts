import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { httpIfHeader } from 'src/app/models/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private url = "http://localhost:8080/api/orders";
  constructor(private http: HttpClient) {
  }

  buy(data: any) {
    return this.http.post(this.url + "/buy", data, httpIfHeader())
  }
  getOrder(id: string) {
    return this.http.get(this.url + "/order/" + id, httpIfHeader())
  }
  confirm(data: any) {
    return this.http.put(this.url + "/confirm", data, httpIfHeader())
  }
  getPruchases() {
    return this.http.get(this.url + "/purchases", httpIfHeader())
  }
  getSolds() {
    return this.http.get(this.url + "/solds", httpIfHeader())
  }
  cancel(id: string) {
    return this.http.delete(this.url + "/cancel/" + id, httpIfHeader())
  }
}
