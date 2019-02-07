import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})
export class NewsApiService {

  languageCode: any;
  code:any;

  api_key = 'c2bc8fd6da5845dfbb0afbda061674c6';

  constructor(private http: HttpClient, private service: AuthService) { }

  initSources(): Observable<any> {
    this.languageCode = this.service.getCode();
    console.log(this.languageCode);
    return this.http.get('https://newsapi.org/v2/top-headlines?language=' + this.languageCode + '&apiKey=' + this.api_key);
  }

  savefavoriteArticleUrl = "/newsarticle-service/saveArticle"
  getUserUrl = "/newsarticle-service/user/"
  deletefavoriteArticleUrl = "/newsarticle-service/delete"

  saveArticle(favoriteArticle) {
    console.log("inside save article service")
    console.log(favoriteArticle);
    return this.http.post(this.savefavoriteArticleUrl, favoriteArticle, httpOptions)

  }

  searchArticles(keyword){
    return this.http.get("https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + this.api_key);

  }

  getUser(id): Observable<any> {
    console.log(id);
    return this.http.get(this.getUserUrl + id);

  }

  deleteArticle(favoriteArticle) {
    console.log("inside delete article service")
    return this.http.post(this.deletefavoriteArticleUrl, favoriteArticle, httpOptions)

  }

}
