import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';
@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  tmp:string;
  date1=new Date();
  myjson={'name':'omkar','company':'RIA'};
  constructor(private data:DataService)
  {

  }
  hello()
  {
    this.data.setTemp(this.tmp);
    
    console.log(this.data.getTemp());
  }

  ngOnInit(): void {
  }

}
