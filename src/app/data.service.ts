import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders,HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
private myurl="http://jsonplaceholder.typicode.com/users";
private mylocalurl="http://localhost:8080/dataGet";
private mylocalurl2="http://localhost:8080/dataPost";
private addStudent = 'http://localhost:8080/addStudent';
private myAns;

private postAns = "http://localhost:8080/submitExam?rollno=10";
  private temp:string;
  postdata='{"empid":16,"ename":"John", "salary":90}';
postdata1='{"rollno":16,"username":"John", "password":"pass"}';
  constructor(private http:HttpClient) { }
getData()
{
return this.http.get(this.myurl);
}
getHttpData()
{
return this.http.get(this.mylocalurl);
}
postHttpData(id,name,sal)
{
this.postdata='{"empid":'+ id +',"ename":"'+ name +'", "salary":'+ sal +'}';
console.log(this.postdata);
return this.http.post(this.mylocalurl2,this.postdata,{headers : new HttpHeaders({'Content-Type':'application/json'})});
}
postStudentData(rollno, username, password) {
  this.postdata1 =
    '{ "rollno":'+
    rollno +
    ', "username":"' +
    username +
    '","password":"' +
    password +
    '"}';
  console.log(this.postdata1);
  return this.http.post(this.addStudent, this.postdata1, {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  });
}
login(username,password)
{
   
const params = new HttpParams()
.set('username', username)
.set('password', password);
return this.http.get('http://localhost:8080/displayMarks',{params});
 
}
studentProfile()
{
  return this.http.get('http://localhost:8080/studentProfileTrial',{
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })});
}
getQuestions()
{
  return this.http.get('http://localhost:8080/startExam',{
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })});
}

postAnsMethod(str) {
  this.myAns =
    '{ "answers":'
    +
    JSON.stringify(str)
    +
    '}';
  console.log(this.myAns);
  //console.log();
  return this.http.post(this.postAns, this.myAns, {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  });
}
  getTemp()
  {
    return this.temp;
  }

  setTemp(temp)
  {
    this.temp=temp;
  }
}
