import { Component, OnInit } from '@angular/core';
import { FeedNoticiasComponent } from '../feed-noticias/feed-noticias.component';
import { Usuario } from '../../classes-basicas/usuario';
import { PublicacaoService } from '../../services/publicacao.service';

@Component({
  selector: 'app-base-admin',
  templateUrl: './base-admin.component.html',
  styleUrls: ['./base-admin.component.css'],
  providers: [PublicacaoService]
})

export class BaseAdminComponent implements OnInit {

  public feedNoticiasComponent = FeedNoticiasComponent; 
  public usuarioLogado: Usuario;

  constructor(private pubService: PublicacaoService) {
      this.usuarioLogado = pubService.usuario;
  }

  ngOnInit() {  	
  }

}
