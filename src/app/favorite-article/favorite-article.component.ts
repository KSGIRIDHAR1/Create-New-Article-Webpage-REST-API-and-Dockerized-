import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NewsApiService } from '../news-api.service';

@Component({
  selector: 'app-favorite-article',
  templateUrl: './favorite-article.component.html',
  styleUrls: ['./favorite-article.component.css']
})
export class FavoriteArticleComponent implements OnInit {

  constructor(private newsApi: NewsApiService, private service: AuthService) { }

  id: any;
  user:any;
  articleList: any[];
  articles: any;
  favouriteArticle: any;
  favoriteArticleId: any;

  ngOnInit() {
    this.id = this.service.getUserId();
    this.newsApi.getUser(this.id).subscribe(data => {
      this.favouriteArticle = data.article;
      console.log(data);
      console.log(this.favouriteArticle);
    })
  }

  deleteArticle(title) {
    this.user = JSON.stringify({
      id: this.id,
      article: [{ title }]
    })
    this.newsApi.deleteArticle(this.user).subscribe(
      data => {
        this.newsApi.getUser(this.id).subscribe(data => {
          this.favouriteArticle = data.article;
          console.log(data);
          console.log(this.favouriteArticle);
        })

      })
  }






}