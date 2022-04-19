import { Component, OnInit } from '@angular/core';
import { Employ } from '../employ';

@Component({
  selector: 'app-employ-drop-down',
  templateUrl: './employ-drop-down.component.html',
  styleUrls: ['./employ-drop-down.component.css']
})
export class EmployDropDownComponent implements OnInit {
  sname : string;
  employs = [
    new Employ(1,"Manasvi","Angular","Programmer",984234),
    new Employ(2,"Souvik","Java","Expert",88434),
    new Employ(3,"Muskan","Angular","Developer",94234),
    new Employ(4,"Anushka","Java","Developer",84234),
    new Employ(5,"Akshat","Angular","Developer",99424)
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
