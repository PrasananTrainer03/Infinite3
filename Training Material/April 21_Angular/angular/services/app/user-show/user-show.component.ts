import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
import { Users } from '../users';

@Component({
  selector: 'app-user-show',
  templateUrl: './user-show.component.html',
  styleUrls: ['./user-show.component.css']
})
export class UserShowComponent implements OnInit {

  users : Observable<Users[]>;
  constructor(private _userService : UserService) { 
    this.users = this._userService.showUsers();
  }

  ngOnInit() {
  }

}
