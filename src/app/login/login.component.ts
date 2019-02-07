import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { AuthService } from '../auth.service';
import { NewsApiService } from '../news-api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  code: any;
  constructor(private loginService: LoginService, private router: Router, private service: AuthService, private newsapi: NewsApiService) { }
  form = new FormGroup({
    email: new FormControl(
      '',
      [Validators.required,
      Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
      Validators.maxLength(255),
      ]),
    password: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(6),
      Validators.maxLength(50)]),
  })
  ngOnInit() {
  }
  authenticated = false;
  isAdmin = false;

  login() {
    console.log(this.form.value);
    this.loginService.login(JSON.stringify(this.form.value)).subscribe(
      data => {
        console.log(data);
        console.log("success");
        if (data.authenticated) {
          this.service.login();
          this.code = data.user.language.code;
          this.newsapi.code = this.code;
          this.service.setUserId(data.user.id);
          this.code = this.service.setCode(this.code);
          this.router.navigate(['/articles']);
        }

        if (data.admin) {
          this.router.navigate(['/admin']);
        }
      })
    this.form.reset();
  }
}
