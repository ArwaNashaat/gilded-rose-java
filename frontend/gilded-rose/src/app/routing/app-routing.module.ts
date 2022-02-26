import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from '../components/add-item/add-item.component';
import { ShowAllItemsComponent } from '../components/show-all-items/show-all-items.component';

const routes: Routes = [
  { path: 'showAllItems', component: ShowAllItemsComponent },
  { path: 'addItem', component: AddItemComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [AddItemComponent, ShowAllItemsComponent]
