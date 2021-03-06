import { Component, OnInit } from '@angular/core';
import { UfrpeService } from  '../../services/ufrpe.service';
import { AvaService } from  '../../services/ava.service';
import * as xml2js from 'xml2js';

let resp: any;
declare function setSettings();

@Component({
  selector: 'app-noticias-oficiais',
  templateUrl: './noticias-oficiais.component.html',
  styleUrls: ['./noticias-oficiais.component.css'],
  providers: [UfrpeService, AvaService]
})
export class NoticiasOficiaisComponent implements OnInit {

  public oficial: any[];
  public usuarioLogado: any;
  public textValue: string = '';


  constructor(private ufrpeService: UfrpeService, private avaService: AvaService) { 
  	this.usuarioLogado = this.avaService.getUser();
  }


  ngOnInit() {
    this.loadNews();
  }

getNews(){return resp;}

loadNews(){
    this.ufrpeService.getNews().subscribe(
        data => {
            xml2js.parseString( data, function (err, result) {
                console.log(result);
                resp = result.rss.channel[0].item;
                setSettings();
            });
        },
        error => {
            console.log("ops");
        }
    );
}
}
  


