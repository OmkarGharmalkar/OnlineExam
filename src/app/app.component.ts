import { Component } from '@angular/core';

import {DataService} from './data.service';
import { NgIf } from '@angular/common';
import { FormControl } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hello-router';
  username=new FormControl('angular');
  password=new FormControl('');
  public userdata=[];
  public empdata=[];
  constructor(private myservice: DataService){}
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
   
  }
  onMySubmit()
  {
    if(this.username.value=='admin')
    {
      alert(this.username.value+" "+this.password.value);
    
    }
    else
    {
      alert("Incorrect username");
    }
  }
  
  hello()
  {
    alert("Hello from mat button");
  }
}
