import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders} from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
    }
  )
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  saveUrl: string="/newsarticle-service/authenticate"

  login(json):Observable<any>{
    console.log("inside service");
    return this.http.post(this.saveUrl, json,  httpOptions)
  
  }
}
