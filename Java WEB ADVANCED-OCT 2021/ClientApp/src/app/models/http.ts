import { HttpHeaders } from "@angular/common/http";

export function httpConfigHeader() {
    return { headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token')) };
}

export function httpIfHeader() {

    if (localStorage.getItem('token')) {
        return httpConfigHeader();
    }
    return undefined;
}