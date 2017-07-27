import { Component, OnInit } from '@angular/core';
import { Comentario } from '../../classes-basicas/comentario';
import { Publicacao } from '../../classes-basicas/publicacao';
import { Usuario } from '../../classes-basicas/usuario';
import { PublicacaoService } from '../../services/publicacao.service';


@Component({
  selector: 'app-feed-noticias',
  templateUrl: './feed-noticias.component.html',
  styleUrls: ['./feed-noticias.component.css'],
  providers: [PublicacaoService]
})

export class FeedNoticiasComponent implements OnInit {

  public feed: Publicacao[];
  public usuarioLogado: Usuario;
 // public pubService: PublicacaoService;

  constructor(private pubService: PublicacaoService) {
    this.usuarioLogado = this.pubService.usuario;
    this.feed = this.pubService.feed;    
  }


  ngOnInit() {
  }

  limparCampoComentario(){
      document.getElementById('coment').nodeValue = "";
}

  adicionarPublicacao(pubTexto: string, pubFotos: any, pubVideos: any, pubTags: string[]) {
    if (pubTexto != null && pubTexto.length > 0) {
      let pub: Publicacao = new Publicacao(Date.now() + this.usuarioLogado.id, this.usuarioLogado.nome, this.usuarioLogado.nomeUsuario,
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
  
  gostarPublicacao(pub: Publicacao, nomeUsuario: string) {
    //se true: gostar
    this.pubService.gostarPublicacao(pub, nomeUsuario);
  }

  naoGostarPublicacao(pub: Publicacao, nomeUsuario: string) {
    this.pubService.naoGostarPublicacao(pub, nomeUsuario);
  }

  gostou(pub: Publicacao, nomeUsuario: string): boolean {
    return this.pubService.gostou(pub, nomeUsuario);
  }

  naoGostou(pub: Publicacao, nomeUsuario: string): boolean {
    return this.pubService.naoGostou(pub, nomeUsuario);
  }

  estaSalvaPublicacao(pub: Publicacao): boolean{
    return this.pubService.estaSalvaPublicacao(pub);
  }
}
