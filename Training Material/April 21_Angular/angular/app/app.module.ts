import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { ThirdComponent } from './third/third.component';
import { EventComponent } from './event/event.component';
import { TwowayComponent } from './twoway/twoway.component';
import { CalcComponent } from './calc/calc.component';
import { ConditionComponent } from './condition/condition.component';
import { EmployComponent } from './employ/employ.component';
import { StudentComponent } from './student/student.component';
import { EmployDropdownComponent } from './employ-dropdown/employ-dropdown.component';
import { StudentDropdownComponent } from './student-dropdown/student-dropdown.component';
import { MenuComponent } from './menu/menu.component';

const appRoutes : Routes = [
  {path:'first',component:FirstComponent},
  {path:'second',component:SecondComponent},
  {path:'third',component:ThirdComponent},
  {path:'event',component:EventComponent},
  {path:'calc',component:CalcComponent},
  {path:'twoway',component:TwowayComponent},
  {path:'condition',component:ConditionComponent},
  {path:'employ',component:EmployComponent},
  {path:'student',component:StudentComponent},
  {path:'menu',component:MenuComponent},
  {path:'',component:MenuComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    ThirdComponent,
    EventComponent,
    TwowayComponent,
    CalcComponent,
    ConditionComponent,
    EmployComponent,
    StudentComponent,
    EmployDropdownComponent,
    StudentDropdownComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
