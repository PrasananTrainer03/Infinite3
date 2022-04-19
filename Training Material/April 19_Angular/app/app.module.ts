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
    EmployDropDownComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
