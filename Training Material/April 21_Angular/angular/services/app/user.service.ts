import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Users } from './users';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _http : Http) { }

  // searchUser(userId : number) : Observable<User> {

  // }
  showUsers() : Observable<Users[]> {
    return this._http.get("https://jsonplaceholder.typicode.com/users").
    map((res:Response)=>res.json())
  }
}
