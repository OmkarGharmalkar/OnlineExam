import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {DataService} from '../data.service';
@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  constructor(private myservice: DataService) { }
  str:string;
  questions;
  flag=false;
 que;
 ans=new FormControl('');
 temp;
 answers:Array<string>=[];
  i=0;

  ngOnInit(): void {
    
  }
onStart()
{
  this.myservice.getQuestions().subscribe((data) => {
    this.questions = Array.from(Object.keys(data), (k) => data[k]);
    console.log(this.questions.length);
    this.i=0;

  });
 document.getElementById("myP1").style.visibility="visible";
 document.getElementById("myP2").style.visibility="visible";
 document.getElementById("ans").style.visibility="visible";
 this.que='Press Next Question button to go to Question no.1 ';
 document.getElementById("que").style.visibility="visible";
 
}
getQuestion()
{
  if(this.i<this.questions.length)
  {
this.que=this.questions[this.i];
var myans:string = this.ans.value;
this.answers.push(myans);
//this.answers[this.i]=this.ans.value;
console.log(this.ans.value);
this.i++;

  }
  else{
    //this.answers[this.i]=this.ans.value;
    var myans:string = this.ans.value;
    this.answers.push(myans);
    this.que='This was the last question';
    document.getElementById("ans").style.visibility = "hidden";
    document.getElementById("myP1").style.visibility="hidden";
    document.getElementById("myP2").style.visibility="hidden";
    document.getElementById("nextQue").style.visibility="hidden";
    document.getElementById("startButton").style.visibility="hidden";
    document.getElementById("submitButton").style.visibility="visible";
  }
}
sendAnswers()
{
  this.myservice.postAnsMethod(this.answers).subscribe((data)=>{
    console.log(data);
  });
 // this.myservice.putAnswers(10,this.answers);
 // console.log(this.answers);
}
changeFlag()
{
  if(this.flag==true)
  {
    this.flag=false;
  }
  else
  {
    this.flag=true;
  }
}

}