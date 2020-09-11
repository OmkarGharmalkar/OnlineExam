import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {MatButtonModule} from '@angular/material/button';
import {MatSliderModule} from '@angular/material/slider';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import {DataService} from './data.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ExamComponent } from './exam/exam.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContactComponent,
    AboutComponent,
    SignupComponent,
    LoginComponent,
    ExamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
       FormsModule,
       ReactiveFormsModule,
       BrowserAnimationsModule,
       MatButtonModule,
       MatSliderModule,
       HttpClientModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
