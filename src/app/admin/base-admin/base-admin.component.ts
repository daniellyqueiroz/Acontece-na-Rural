import { Component, OnInit } from '@angular/core';
import { FeedNoticiasComponent } from '../feed-noticias/feed-noticias.component';
import { Usuario } from '../../classes-basicas/usuario';
import { AvaService } from '../../services/ava.service';

@Component({
  selector: 'app-base-admin',
  templateUrl: './base-admin.component.html',
  styleUrls: ['./base-admin.component.css'],
  providers: [AvaService]
})

export class BaseAdminComponent implements OnInit {

  public user: any ={};

  constructor(private avaService : AvaService) {
     this.user = avaService.getUser()
  }

  ngOnInit() {  	
  }

}
