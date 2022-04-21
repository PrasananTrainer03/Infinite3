import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-show',
  templateUrl: './customer-show.component.html',
  styleUrls: ['./customer-show.component.css']
})
export class CustomerShowComponent implements OnInit {

  manager : string;
  constructor() { 
    this.manager = localStorage.getItem("manager")
  }

  ngOnInit(): void {
  }

}
