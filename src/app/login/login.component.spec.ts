import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { DebugElement } from '@angular/core';
import { Routes } from '@angular/router';
import { SignupComponent } from '../signup/signup.component';
import { By, BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { LoginService } from '../login.service';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let el : HTMLElement;

  beforeEach(async(() => {
   
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports : [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
  ],
  providers : [
    { provide : LoginService }
  ]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;

    });
  }));

  
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should validate when field are filled',()=> {
   
    component.form.controls['email'].setValue('Giridhar@gmail.com');
    component.form.controls['password'].setValue('Giridhar');
    expect(component.form.valid).toBeTruthy();
  });
  it('form should not validate when fields are empty',()=> {
    
    component.form.controls['email'].setValue('');
    component.form.controls['password'].setValue('');
    expect(component.form.valid).toBeFalsy();
  });

  it('form invalid when email pattern is wrong ',()=>{
    component.form.controls['email'].setValue('Giri');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['email'].valid).toBeFalsy();
  });

  it('form invalid when password character less than 6',()=>{
    component.form.controls['password'].setValue('Giri');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  });
  
  it('is form invalid when password character more than 50',()=>{
    component.form.controls['password'].setValue('giridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhargiridhar');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }); 

  it('should call the login method', ()=> {
    fixture.detectChanges();
    spyOn(component, 'login');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(1);
  });


});
