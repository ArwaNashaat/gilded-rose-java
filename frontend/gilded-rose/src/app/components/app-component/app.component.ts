import { Component } from '@angular/core';
import { Item } from 'src/app/Item.model';
import { ItemServiceService } from 'src/app/services/item-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  name:string;
  sellIn:number;
  quality:number;

  item: Item;

  constructor(public itemService: ItemServiceService) {

  }

  addItem(){
    this.item = new Item(this.name, this.sellIn, this.quality)
    this.itemService.addItem(this.item).subscribe((result)=>
    console.warn(result) );
  }
}
