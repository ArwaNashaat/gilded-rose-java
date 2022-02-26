import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/Item.model';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-show-all-items',
  templateUrl: './show-all-items.component.html',
  styleUrls: ['./show-all-items.component.css']
})
export class ShowAllItemsComponent implements OnInit {

  headers:string[] = ['id','name', 'sell_in', 'quality']

  public items: Item[]
  constructor(public itemService: ItemService) {

  }

  ngOnInit(): void {

    this.getAllItems()
  }

  private getAllItems() {
    return this.itemService.getAllItems().subscribe(result => {
      this.items = result;
    });
  }

}
