import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import {ExamComponent} from './exam/exam.component';
const routes: Routes = [
 { path:"home",component:HomeComponent},
 {path:"contact",component:ContactComponent},
 {path:"about",component:AboutComponent},
 {path:"signup",component:SignupComponent},
 {path:"login",component:LoginComponent},
 {path:"exam",component:ExamComponent},
 {path:"*", component:AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
