import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FavoriteArticleComponent } from './favorite-article/favorite-article.component';
import { AdminComponent } from './admin/admin.component';
import { Routes } from '@angular/router';
import { ArticlesComponent } from './articles/articles.component';
import { HeaderComponent } from './header/header.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { APP_BASE_HREF } from '@angular/common';

describe('AppComponent', () => {

  const routes: Routes = [
    { path : "", component: LoginComponent},
    { path : "login", component: LoginComponent},
    { path : "signup", component: SignupComponent},
    { path : "news", component: ArticlesComponent},
    { path : "admin", component : AdminComponent},
    { path : "favourite", component : FavoriteArticleComponent}
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        ReactiveFormsModule, 
        FormsModule, 
        AppRoutingModule, 
        RouterTestingModule
      ],
      declarations: [
        AppComponent,
        LoginComponent,
        SignupComponent,
        ArticlesComponent,
        AdminComponent,
        FavoriteArticleComponent,
        HeaderComponent
      ],
      providers: [
        {provide : APP_BASE_HREF  , USE_VALUE:'/'}
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'newsarticle'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('newsarticle');
  });

});
