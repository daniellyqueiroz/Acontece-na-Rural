import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../classes-basicas/usuario';
import { Publicacao } from '../../classes-basicas/publicacao';
import { Comentario } from '../../classes-basicas/comentario';
import { Reacao } from '../../classes-basicas/reacao';
import { TiposReacao } from '../../classes-basicas/tipo-reacao';

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

  adicionarPublicacao(pubTexto: string, pubFotos: any, pubVideos: any, pubTags: string[]) {
    if (pubTexto != null && pubTexto.length > 0) {
      let pub: Publicacao = new Publicacao(Date.now() + this.usuarioLogado.id, this.usuarioLogado.id, this.usuarioLogado.nome, this.usuarioLogado.nomeUsuario,
        this.usuarioLogado.imagem, Date.now(), pubTexto, pubFotos, pubVideos, pubTags);
      this.pubService.adicionarPublicacao(pub);
    }
  }

  removerPublicacao(pub: Publicacao, nomeUsuario: string) {
    if (pub.nomeUsuario == nomeUsuario) {
      let index = this.feed.indexOf(pub);
      this.pubService.removerPublicacao(index);
    }
  }

  adicionarComentario(pub: Publicacao, comentarioTexto: string) {
    if (comentarioTexto != null && comentarioTexto.length > 0) {
      let com: Comentario = new Comentario(Date.now() + this.usuarioLogado.id, pub.id,
        this.usuarioLogado.id, this.usuarioLogado.nome, this.usuarioLogado.nomeUsuario,
        this.usuarioLogado.imagem, comentarioTexto, Date.now());
        this.pubService.adicionarComentario(pub, com);
    }
  }

  removerComentario(pub: Publicacao, com: Comentario, nomeUsuario: string) {
    if (com.nomeUsuario == nomeUsuario) {
      let index = pub.comentarios.indexOf(com);
      this.pubService.removerComentario(pub, com, index);
    }
  }

  salvarPublicacao(pub: Publicacao) {
    this.pubService.salvarPublicacao(pub);
  }
  
  gostarPublicacao(pub: Publicacao, idUsuario: number) {
    //pegar a data atual e somar ao id do usuário (garante)
    let reacao: Reacao = new Reacao(Date.now() + this.usuarioLogado.id*this.usuarioLogado.id, pub.id, 
      idUsuario, TiposReacao.Gostar);      
    this.pubService.gostarPublicacao(pub, reacao);
  }

  naoGostarPublicacao(pub: Publicacao, idUsuario: number) {
    let reacao: Reacao = new Reacao(Date.now() + this.usuarioLogado.id*this.usuarioLogado.id, pub.id, 
    idUsuario, TiposReacao.NaoGostar);  
    this.pubService.naoGostarPublicacao(pub, reacao);
  }

<<<<<<< HEAD
  quantidadeGostar(pub: Publicacao){
    return this.pubService.quantidadeGostar(pub);
  }

  quantidadeNaoGostar(pub: Publicacao){
    return this.pubService.quantidadeNaoGostar(pub);
  }

  gostou(pub: Publicacao, idUsuario: number): boolean {
    return this.pubService.gostou(pub, idUsuario);
  }

=======
  gostou(pub: Publicacao, idUsuario: number): boolean {
    return this.pubService.gostou(pub, idUsuario);
  }

>>>>>>> fd3b0d96b5398f0fc8115c1d8030a16a430c32c4
  naoGostou(pub: Publicacao, idUsuario: number): boolean {
    return this.pubService.naoGostou(pub, idUsuario);
  }

  estaSalvaPublicacao(pub: Publicacao): boolean{
    return this.pubService.estaSalvaPublicacao(pub);
  }

}
