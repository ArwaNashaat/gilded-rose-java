import { Injectable } from '@angular/core';
import { Item } from '../Item.model';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
    'Access-Control-Allow-Origin': '*',

  })
};
@Injectable({
  providedIn: 'root'
})

export class ItemService {
  items: Array<Item> = []

  constructor(private http: HttpClient) {

  }

  addItem(item: Item): Observable<Item> {
    const url = `http://127.0.0.1:8080/Item/add`;
    return this.http.post<Item>(url, item, httpOptions)
      .pipe(
        catchError(this.handleError)
      );

  }

  getAllItems(){
    const url = `http://127.0.0.1:8080/Item/getAllItems`;

    return this.http.get<Item[]>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occurred:', error.error);
    } else {
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    return throwError(() => new Error(error.statusText))
  }
}
