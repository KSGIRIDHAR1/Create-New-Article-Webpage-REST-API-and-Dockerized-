import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedIn :  boolean = false;
  code:any;
  id:any;
  constructor() { }

  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }
  getCode(){
    return  this.code;
   }
 
   setCode(code:string){
       this.code=code;
    }

    getUserId() {
      return this.id;
      }
  
      setUserId(id:number) {
      this.id = id;
     }
}
