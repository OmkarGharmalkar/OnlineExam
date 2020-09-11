import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {DataService} from '../data.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  username=new FormControl('');
  password=new FormControl('');
  rollno=new FormControl('');
  constructor(private myservice:DataService) { }
  onMySubmit()
  {
    alert(this.rollno.value+" "+this.username.value+" "+this.password.value);
    this.myservice.postStudentData(this.rollno.value,this.username.value,this.password.value).subscribe((data)=>{
      console.log(data);
    });
  }

  ngOnInit(): void {
    
  }

}
