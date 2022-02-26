import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 

import { AppRoutingModule, routingComponents } from './routing/app-routing.module';
import { AppComponent } from './components/app-component/app.component';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule, MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddItemComponent } from './components/add-item/add-item.component';

const material=[
  MatTableModule,
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule
]
@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    AddItemComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    material,
    FormsModule,
    HttpClientModule
  ],

  exports:[
    material
  ],

  providers: [
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'fill'}}
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
