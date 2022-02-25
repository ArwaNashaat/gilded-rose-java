import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './routing/app-routing.module';
import { AppComponent } from './components/app-component/app.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

const material=[
  MatFormFieldModule,
  MatInputModule
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
