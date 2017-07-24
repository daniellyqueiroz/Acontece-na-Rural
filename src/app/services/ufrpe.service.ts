import { Injectable } from '@angular/core';
import{ Http} from "@angular/http";
import * as xml2js from 'xml2js';
import 'rxjs/Rx';
 
@Injectable()

export class UfrpeService {
	

	constructor(public http: Http) {
		this.http =http;

	}
   
 getNews(){
      return this.http.get("https://brunohpmarques.000webhostapp.com/rss.php")
      .map(res => res.text());
}
   /*getNews(){
      return this.http.get("https://brunohpmarques.000webhostapp.com/rss.php")
      .timeout(7500)
      .map(res => res.text());
   }*/
}