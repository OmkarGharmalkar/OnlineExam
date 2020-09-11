import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';

import {DataService} from '../data.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username=new FormControl('');
  password=new FormControl('');
  student;
  
  status;
  marks;
  constructor(private myservice:DataService) { }

  ngOnInit(): void {
  }
  onMysubmit()
  {
    
    this.myservice.login(this.username.value,this.password.value).subscribe((data)=>{
      this.marks = Array.from(Object.keys(data), (k) => data[k]);
     
    
    
      console.log(this.marks);
    });
   
  }
  

}
