import { Component, OnInit } from '@angular/core';
import { Publicacao } from '../../classes-basicas/publicacao';
import { TiposReacao } from '../../classes-basicas/tipo-reacao';
import { Comentario } from '../../classes-basicas/comentario';
import { Usuario } from '../../classes-basicas/usuario';
import { Reacao } from '../../classes-basicas/reacao';
import { PublicacaoService } from '../../services/publicacao.service';

import { AvaService } from '../../services/ava.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
  providers: [PublicacaoService, AvaService]
})
export class PerfilComponent implements OnInit {

  public feed: Publicacao[];
  public usuarioLogado: Usuario;

  constructor(private pubService: PublicacaoService, private avaService: AvaService) {
    this.usuarioLogado = this.avaService.getUser();
    this.feed = this.pubService.feed;
    //this.pubService.getBanco3().then(postagens => this.feed = postagens);    
  }

  ngOnInit() {
  }

  somentePubsUsuario(pubs: Publicacao[]): Publicacao[]{
    return this.pubService.filtrarPublicacoesPorUsuario(pubs, this.usuarioLogado.id);
  }

  adicionarComentario(pub: Publicacao, comentarioTexto: string) {
    if (comentarioTexto != null && comentarioTexto.length > 0) {
      let com: Comentario = new Comentario(Date.now() + this.usuarioLogado.id*this.usuarioLogado.id, 
      pub, this.usuarioLogado, comentarioTexto);
        this.pubService.adicionarComentario(pub, com);
    }
  }

  removerComentario(pub: Publicacao, com: Comentario, idUsuario: number) {
    if (com.usuario.id == idUsuario) {
      let index = pub.comentarios.indexOf(com);
      this.pubService.removerComentario(pub, com, index);
    }
  }

  salvarPublicacao(pub: Publicacao) {
    this.pubService.salvarPublicacao(pub);
  }
  
  gostarPublicacao(pub: Publicacao, idUsuario: number) {
    //pegar a data atual e somar ao id do usuário (garante)
    let reacao: Reacao = new Reacao(Date.now() + this.usuarioLogado.id*this.usuarioLogado.id, pub, 
      this.usuarioLogado, TiposReacao.Gostar);   
    this.pubService.gostarPublicacao(pub, reacao);
  }

  naoGostarPublicacao(pub: Publicacao, idUsuario: number) {
    let reacao: Reacao = new Reacao(Date.now() + this.usuarioLogado.id*this.usuarioLogado.id, pub, 
    this.usuarioLogado, TiposReacao.NaoGostar);  
    this.pubService.naoGostarPublicacao(pub, reacao);
  }

  quantidadeGostar(pub: Publicacao){
    return this.pubService.quantidadeGostar(pub);
  }

  quantidadeNaoGostar(pub: Publicacao){
    return this.pubService.quantidadeNaoGostar(pub);
  }

  gostou(pub: Publicacao, idUsuario: number): boolean {
    return this.pubService.gostou(pub, idUsuario);
  }

  naoGostou(pub: Publicacao, idUsuario: number): boolean {
    return this.pubService.naoGostou(pub, idUsuario);
  }

  estaSalvaPublicacao(pub: Publicacao): boolean{
    return this.pubService.estaSalvaPublicacao(pub);
  }

}
