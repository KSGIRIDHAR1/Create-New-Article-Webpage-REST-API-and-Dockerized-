import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { AuthService } from '../auth.service';
@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  id: any;
  articleList: any[];
  articles: any;
  favouriteArticle: any;
  favoriteArticleId: any;
  value: any;
  keyword: any;

  ngOnInit() {
    this.id = this.service.getUserId();
    this.newsApi.initSources().subscribe(data => {
      console.log(data);
      this.articleList = data.articles;
      console.log(this.articleList)
    })
  }

  constructor(private newsApi: NewsApiService, private service: AuthService) { }

  search() {
    console.log(this.keyword);
    this.newsApi.searchArticles(this.keyword).subscribe(
      data => {
        console.log(data)
        this.value = data['articles'];
      }
    );
  }

  saveArticle(item) {
    console.log(item);
    let user = JSON.stringify({
      id: this.service.getUserId(),
      article: item
      
    })
    console.log(user);
    this.newsApi.saveArticle(user).subscribe();
  }

}
