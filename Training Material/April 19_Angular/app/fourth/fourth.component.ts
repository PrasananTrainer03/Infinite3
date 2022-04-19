import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fourth',
  templateUrl: './fourth.component.html',
  styleUrls: ['./fourth.component.css']
})
export class FourthComponent implements OnInit {

  name : string;
  company : string;
  
  constructor() {
    this.name="Prasanna";
    this.company="Hexaware";
   }

  ngOnInit(): void {
  }

}
