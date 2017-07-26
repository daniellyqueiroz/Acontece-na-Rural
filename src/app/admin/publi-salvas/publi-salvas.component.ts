import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../classes-basicas/usuario';
import { Publicacao } from '../../classes-basicas/publicacao';

import { PublicacaoService } from '../../services/publicacao.service';
@Component({
  selector: 'app-publi-salvas',
  templateUrl: './publi-salvas.component.html',
  styleUrls: ['./publi-salvas.component.css'],
  providers: [PublicacaoService]
})

export class PubliSalvasComponent implements OnInit {
  public usuarioLogado: Usuario;
  public feed: Publicacao[];

  constructor(private pubService: PublicacaoService) {
    this.usuarioLogado = pubService.usuario;
    this.feed = pubService.feed;
   }

  ngOnInit() {
  }

}
