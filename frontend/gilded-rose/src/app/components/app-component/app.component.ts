import { Component } from '@angular/core';
import { Item } from 'src/app/Item.model';
import { ItemService } from 'src/app/services/item.service';

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

  constructor(public itemService: ItemService) {

  }

  addItem(){
    this.item = new Item(this.name, this.sellIn, this.quality)
    this.itemService.addItem(this.item).subscribe();
  }
}
