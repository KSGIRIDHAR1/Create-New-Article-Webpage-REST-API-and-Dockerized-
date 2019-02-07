import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { ArticlesComponent } from './articles/articles.component';
import { AdminComponent } from './admin/admin.component';
import { FavoriteArticleComponent } from './favorite-article/favorite-article.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"articles",component:ArticlesComponent},
  {path:"admin",component:AdminComponent},
  {path:"favourite",component:FavoriteArticleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
