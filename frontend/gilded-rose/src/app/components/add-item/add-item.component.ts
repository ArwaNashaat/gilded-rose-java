import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/Item.model';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  name: string;
  sellIn: number;
  quality: number;

  item: Item;


  constructor(public itemService: ItemService) {

  }

  ngOnInit(): void {
  }

  addItem() {
    this.item = new Item(this.name, this.sellIn, this.quality)
    this.itemService.addItem(this.item).subscribe();
  }

}
