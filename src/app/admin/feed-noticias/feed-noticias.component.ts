import { Component, OnInit } from '@angular/core';
import { Comentario } from '../../classes-basicas/comentario';
import { Publicacao } from '../../classes-basicas/publicacao';
import { Usuario } from '../../classes-basicas/usuario';
import { Reacao } from '../../classes-basicas/reacao';
import { TiposReacao } from '../../classes-basicas/tipo-reacao';
import { PubService } from '../../services/pub.service';
import { AvaService } from '../../services/ava.service';

//remover depois
import { PublicacaoService } from '../../services/publicacao.service';


@Component({
  selector: 'app-feed-noticias',
  templateUrl: './feed-noticias.component.html',
  styleUrls: ['./feed-noticias.component.css'],
  providers: [AvaService, PubService, PublicacaoService]
})

export class FeedNoticiasComponent implements OnInit {

  public feed: any[];

  //necessário serem diferentes para evitar acúmulo de propriedades no objeto
  public dataPub: any = {};
  public dataCom: any = {};
  public dataReacao: any = {}; 

  public usuario: Usuario;

  constructor(private pubService: PubService, private avaService: AvaService, 
    private publiService: PublicacaoService) {
    //this.usuario = this.publiService.usuario;
    //this.feed = this.publiService.feed;

    this.usuario = avaService.getUser();
    //this.feed = pubService.getPubs();
  }


  ngOnInit() {
    
  }

  carregarPostagens(){
    return this.pubService.listarPub()
    .subscribe(
      data => 
	{
	if (data != null & data.length) this.feed = data;
	else this.feed = [];
	},
      err => { console.log("Deu ruim Post") },
      () => console.log("Tudo Certo Post")
   );
  }


  adicionarPublicacao(pubTexto: string, pubFotos: any, pubVideos: any, pubTags: string[]) {
    if (pubTexto != null && pubTexto.length > 0) {
      this.dataPub.usuario = this.usuario;
      this.dataPub.texto = pubTexto;
      this.pubService.adicionarPub(this.dataPub)
      //.subscribe()
      ;

      //COM O PUBLISERVICE (OU SEJA, SEM USAR O BACK)
      /*let pub: Publicacao = new Publicacao(Date.now() + this.usuario.id*this.usuario.id, 
      this.usuario, pubTexto, pubFotos, pubVideos, pubTags);
      this.publiService.adicionarPublicacao(pub);*/
    }
  }

  removerPublicacao(pub: Publicacao, idUsuario: number) {
      if (pub.usuario.id == idUsuario) {
      this.pubService.deletarPub(pub.id)
      //.subscribe()
      ;


      //COM O PUBLISERVICE (OU SEJA, SEM USAR O BACK)
      /*let index = this.feed.indexOf(pub);
      this.publiService.removerPublicacao(index);*/
    }
  }

  adicionarComentario(pub: Publicacao, texto: string) {
    if (texto != null && texto.length > 0) {
      this.dataCom.texto = texto;
      this.dataCom.idPublicacao = pub.id;
      this.pubService.adicionarCom(this.dataCom)
      //.subscribe()
      ;

      //COM O PUBLISERVICE (OU SEJA, SEM USAR O BACK)
      /*let com: Comentario = new Comentario(Date.now() + this.usuario.id*this.usuario.id, 
      pub, this.usuario, comentarioTexto);
      this.publiService.adicionarComentario(pub, com);*/
    }
  }

  removerComentario(pub: Publicacao, com: Comentario, idUsuario: number) {
    if (com.usuario.id == idUsuario) {
      this.pubService.deletarCom(com.id)
      //.subscribe()
      ;
      //COM O PUBLISERVICE (OU SEJA, SEM USAR O BACK)
      /*let index = pub.comentarios.indexOf(com);
      this.publiService.removerComentario(pub, com, index);*/
    }
  }

  salvarPublicacao(pub: Publicacao) {
    //this.publiService.salvarPublicacao(pub);
  }
  
  gostarPublicacao(pub: Publicacao, idUsuario: number) {
    this.dataReacao.tipo = TiposReacao.Gostar;
    this.dataReacao.idPublicacao = pub.id;
    this.pubService.adicionarReacao(this.dataReacao)
    //.subscribe()
    ;

    //COM O PUBLISERVICE (OU SEJA, SEM USAR O BACK)
    /*let reacao: Reacao = new Reacao(Date.now() + this.usuario.id*this.usuario.id, pub, 
    this.usuario, TiposReacao.Gostar);   
    this.publiService.gostarPublicacao(pub, reacao);*/
  }

  naoGostarPublicacao(pub: Publicacao, idUsuario: number) {
    this.dataReacao.tipo = TiposReacao.NaoGostar;
    this.dataReacao.idPublicacao = pub.id;
    this.pubService.adicionarReacao(this.dataReacao)
    //.subscribe()
    ;
    //COM O PUBLISERVICE (OU SEJA, SEM USAR O BACK)
    /*let reacao: Reacao = new Reacao(Date.now() + this.usuario.id*this.usuario.id, pub, 
    this.usuario, TiposReacao.NaoGostar);  
    this.publiService.naoGostarPublicacao(pub, reacao);*/
  }

  
  quantidadeGostar(pub: Publicacao){
    return this.publiService.quantidadeGostar(pub);
  }

  quantidadeNaoGostar(pub: Publicacao){
    return this.publiService.quantidadeNaoGostar(pub);
  }

  gostou(pub: Publicacao, idUsuario: number): boolean {
    return this.publiService.gostou(pub, idUsuario);
  }

  naoGostou(pub: Publicacao, idUsuario: number): boolean {
    return this.publiService.naoGostou(pub, idUsuario);
  }

  estaSalvaPublicacao(pub: Publicacao): boolean{
    return this.publiService.estaSalvaPublicacao(pub);
  }

}
