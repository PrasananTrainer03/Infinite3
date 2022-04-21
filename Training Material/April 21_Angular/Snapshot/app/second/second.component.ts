import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  company: string;
  constructor(private _activateRoute : ActivatedRoute) {
    this.company = this._activateRoute.snapshot.params["company"]
   }

  ngOnInit(): void {
  }

}
