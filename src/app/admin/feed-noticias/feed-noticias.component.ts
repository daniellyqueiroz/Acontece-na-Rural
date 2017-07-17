import { Component, OnInit } from '@angular/core';
import { FormsModule }   from '@angular/forms'; 

@Component({
  selector: 'app-feed-noticias',
  templateUrl: './feed-noticias.component.html',
  styleUrls: ['./feed-noticias.component.css']
})

export class FeedNoticiasComponent implements OnInit {

  public feed: any[];
  public usuarioLogado: any;
  public textValue: string = '';
  

  constructor() { 

  	this.usuarioLogado =
      {

  		id: '1',
  		imagem: "assets/img/fotouser.jpg",
  		curso: 'Ciência da Computação',
  		nome: 'Danielly Queiroz'
    };

  	this.feed =[
  		{
  			id: '2',
  			nome: this.usuarioLogado.nome,
  			imagem: this.usuarioLogado.imagem,
  			texto : 'teste',
  			fotos: [],
  			videos: [],
  			data: 'Publicado - 7:30 PM Hoje',
  			qntCurtidas: '98',
  			qntComentarios: '2',
  			comentarios: [{
  				id :11,
          idPublicacao: 54,
          idUsuario: 8,
          nome: 'Joao',
          curso: 'BCC',
          imagem: "assets/img/joao.jpg",
          texto: "meu comentario",
          data: '15/07/2017 22:58:14',
          qntCurtidas: 3
          },
          {
          id :11,
          idPublicacao: 54,
          idUsuario: 8,
          nome: 'Joao',
          curso: 'BCC',
          imagem: "assets/img/joao.jpg",
          texto: "meu comentario",
          data: '15/07/2017 22:58:14',
          qntCurtidas: 3
          },
          {
          id :11,
          idPublicacao: 54,
          idUsuario: 8,
          nome: 'Joao',
          curso: 'BCC',
          imagem: "assets/img/joao.jpg",
          texto: "meu comentario",
          data: '15/07/2017 22:58:14',
          qntCurtidas: 3
          }]

  		  },
          {
            id: '11',
            nome: this.usuarioLogado.nome,
            imagem: this.usuarioLogado.imagem,
            texto : 'teste',
            fotos: [],
            videos: [],
            data: 'Publicado - 7:30 PM Hoje',
            qntCurtidas: '98',
            qntComentarios: '2',
            comentarios: [{
              id :32,
              idPublicacao: 65,
              idUsuario: 76,
              nome: 'Joao',
              curso: 'BCC',
              imagem: "assets/img/joao.jpg",
              texto: "meu comentario",
              data: '15/07/2017 22:58:14',
              qntCurtidas: 88
              }
            ]
          },
          {
            id: '6',
            nome: this.usuarioLogado.nome,
            imagem: this.usuarioLogado.imagem,
            texto : 'teste',
            fotos: [],
            videos: [],
            data: 'Publicado - 7:30 PM Hoje',
            qntCurtidas: '98',
            qntComentarios: '2',
            comentarios: [{
              id:11,
              idPublicacao: 54,
              idUsuario: 8,
              nome: 'Joao',
              curso: 'BCC',
              imagem: "assets/img/fotouser.jpg",
              texto: "meu comentario",
              data: '15/07/2017 22:58:14',
              qntCurtidas: 3
            }]
          }
  		];

  }


  ngOnInit() {
  }

  publicacao(pubTexto: any){

    let novaPublicacao= {
        
      id: 4,
      texto: pubTexto,
      data: "16/07/2017 00:18",
      fotos: [],
      videos: [],
      comentarios:[],
      curtidas: 0,
        
      nome: this.usuarioLogado.nome,
      curso: this.usuarioLogado.curso,
      imagem: this.usuarioLogado.imagem,
      idUsuario: this.usuarioLogado.id
       
    }
    
    if(pubTexto!=null && pubTexto.length >0){
      
       this.feed.unshift(novaPublicacao);
    }
        
  }

  addComentario(publicacao: any, comentarioTexto: any){
   
    let novoComentario = {
      id: 1,
      idPublicacao:10,
      texto: comentarioTexto,
      data: "16/07/2017 18:28",
      curtidas: 0,
    
          nome: publicacao.nome,
          curso: publicacao.curso,
          imagem: publicacao.imagem
      
    }
     if(comentarioTexto!=null && comentarioTexto.length >0){
        publicacao.comentarios.push(novoComentario);
    }


  }

  contCurtidas(){
    let novaCurtida ={
      id: 50,
      idComentario:20,
      idUsuario: 9,
      data: Date.now()
    }
  }




}
