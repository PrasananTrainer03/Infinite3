import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  trainer : string;
  company : string;
  constructor(private _activeRoute : ActivatedRoute) { 
    this.trainer = this._activeRoute.snapshot.params["trainer"];
    this.company = this._activeRoute.snapshot.params["company"];
  }

  ngOnInit() {
  }

}
