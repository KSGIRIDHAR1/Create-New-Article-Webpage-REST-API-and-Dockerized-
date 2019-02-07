import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit{

  analyst1:any;
  isUser=false;
  
  constructor(private analyst:AdminService,private newsApi: NewsApiService) {}

    ngOnInit() {
        }
    
    getUser(email){
      this.analyst.search(email).subscribe(
        data => {
          if(data!=null){
           this.isUser=true;
            this.analyst1=data;
          }
   
      
          console.log(this.analyst1)
        }
      );
    }
    changeStatus(email){
      this.analyst.status(email).subscribe(
        data=>{
          this.analyst1=data;
        }
      )
  
    }

  /* 
    saveArticle(articleTitle) {
      //console.log(articleTitle);
      this.articleList.forEach(favouriteArticle => {
  
        // console.log(element.title);
        if (favouriteArticle.title == articleTitle) {
          console.log(favouriteArticle.title);
          // console.log(favoriteArticle)
  
          this.newsApi.saveArticle(favouriteArticle).subscribe(data => {
            this.favouriteArticle = data;
            console.log(this.favouriteArticle);
          })
        }});
   } */
   
  }