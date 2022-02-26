import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './routing/app-routing.module';
import { AppComponent } from './components/app-component/app.component';
import {MatTableModule} from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

const material=[
  MatTableModule
]
@NgModule({
  declarations: [
    AppComponent,
    routingComponents
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    material,
    FormsModule,
    HttpClientModule
  ],

  exports:[
    material
  ],

  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
