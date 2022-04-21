import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { ThirdComponent } from './third/third.component';
import { FourthComponent } from './fourth/fourth.component';
import { TwoWayComponent } from './two-way/two-way.component';
import { FormsModule } from '@angular/forms';
import { CalcComponent } from './calc/calc.component';
import { EmployComponent } from './employ/employ.component';
import { EmployDropDownComponent } from './employ-drop-down/employ-drop-down.component';
import { MenuComponent } from './menu/menu.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';

const routes : Routes = 
[
  {path:'',component:LoginComponent},
  {path:'menu',component:MenuComponent},
  {path:'menu',component:MenuComponent, 
  children:
  [
      {path:'first',component:FirstComponent,outlet:'hexaware'},
      {path:'second',component:SecondComponent,outlet:'hexaware'},
      {path:'third',component:ThirdComponent,outlet:'hexaware'},
      {path:'fourth',component:FourthComponent,outlet:'hexaware'},
      {path:'TwoWay',component:TwoWayComponent,outlet:'hexaware'},
      {path:'calc',component:CalcComponent,outlet:'hexaware'},
      {path:'employ',component:EmployComponent,outlet:'hexaware'},
      {path:'employdropdown',component:EmployDropDownComponent,outlet:'hexaware'}
  ]
}
  // {path:'first',component:FirstComponent},
  // {path:'second',component:SecondComponent},
  // {path:'third',component:ThirdComponent},
  // {path:'fourth',component:FourthComponent},
  // {path:'TwoWay',component:TwoWayComponent},
  // {path:'calc',component:CalcComponent},
  // {path:'employ',component:EmployComponent},
  // {path:'employdropdown',component:EmployDropDownComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    ThirdComponent,
    FourthComponent,
    TwoWayComponent,
    CalcComponent,
    EmployComponent,
    EmployDropDownComponent,
    MenuComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
