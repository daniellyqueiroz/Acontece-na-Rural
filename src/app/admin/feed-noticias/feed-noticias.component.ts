import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feed-noticias',
  templateUrl: './feed-noticias.component.html',
  styleUrls: ['./feed-noticias.component.css']
})

export class FeedNoticiasComponent implements OnInit {

  public feed: any[];
  public usuarioLogado: any;

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
  			comentarios: [
  				
  			]

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
        comentarios: [
         
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
        comentarios: [
          
        ]

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
        comentarios: [
          ],
        curtidas: 0,
       
        nome: this.usuarioLogado.nome,
        curso: this.usuarioLogado.curso,
        imagem: this.usuarioLogado.imagem,
        idUsuario: this.usuarioLogado.id
    }
    
    this.feed.unshift(novaPublicacao);
  }


}
