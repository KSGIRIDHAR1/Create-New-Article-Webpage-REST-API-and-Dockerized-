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
export class SignupService {

  constructor(private http: HttpClient) { }
  saveUrl: string="/newsarticle-service/save";
  getLang: string="/newsarticle-service/getLanguages";
 
  signup(json):Observable<any>{
   console.log(json);
   return this.http.post<any>(this.saveUrl, json,  httpOptions);
 }

  getLanguage():Observable<any>{
  return this.http.get(this.getLang)
  }
}
