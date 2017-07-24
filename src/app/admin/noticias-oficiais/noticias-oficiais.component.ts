import { Component, OnInit } from '@angular/core';
import { UfrpeService } from  '../../services/ufrpe.service';
import * as xml2js from 'xml2js';

let resp: any;

@Component({
  selector: 'app-noticias-oficiais',
  templateUrl: './noticias-oficiais.component.html',
  styleUrls: ['./noticias-oficiais.component.css'],
  providers: [UfrpeService]
})
export class NoticiasOficiaisComponent implements OnInit {

 public oficial: any[];
  public usuarioLogado: any;
  public textValue: string = '';


  constructor(private ufrpeService: UfrpeService) { 


  	this.usuarioLogado = {
  		id: '1',
  		imagem: "assets/img/fotouser.jpg",
  		curso: 'Ciência da Computação',
  		nome: 'Danielly Queiroz'
    };

  	this.oficial =[
      {
  			id: '2',
  			nome: "UFRPE",
  			imagem: "assets/img/ufrpe.jpg",
  			texto : 'ENERGIA RESTABELECIDA: A Administração Superior da UFRPE comunica que a energia no Campus Dois Irmãos já foi restabelecida pela Celpe, e que estão mantidas as atividades noturnas. O Restaurante Universitário, no entanto, não fornecerá o jantar, em decorrência da impossibilidade de produção durante esta tarde.',
  			fotos: [],
  			videos: [],
  			data: 890809,
  			qntCurtidas: '98',
  			qntComentarios: '3',
  			comentarios: [{
  				id :11,
          idPublicacao: 54,
          idUsuario: 8,
          nome: 'Joao',
          curso: 'BCC',
          imagem: "assets/img/joao.jpg",
          texto: "meu comentario",
          data: 897987,
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
          data: 89908,
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
          data: 7897,
          qntCurtidas: 3
          }]

  		  },
          {
            id: '11',
            nome: 'UFRPE',
            imagem: "assets/img/ufrpe.jpg",
            texto : 'Segunda Chamada da Lista de Espera do SISU divulgada! Há vagas em todos os cursos de Engenharia da Unidade Acadêmica do Cabo de Santo Agostinho (UACSA). Não perca a oportunidade!',
            fotos: [],
            videos: [],
            data: 890809,
            qntCurtidas: '28',
            qntComentarios: '1',
            comentarios: [{
              id :32,
              idPublicacao: 65,
              idUsuario: 76,
              nome: 'Joao',
              curso: 'BCC',
              imagem: "assets/img/joao.jpg",
              texto: "meu comentario",
              data: 89080,
              qntCurtidas: 88
              }
            ]
          },
          {
            id: '6',
            nome: 'UFRPE',
            imagem: "assets/img/ufrpe.jpg",
            texto : 'O Engenheiro Florestal é o profissional apto a avaliar o potencial biológico dos ecossistemas florestais, e assim, planejar e organizar o seu aproveitamento racional de forma sustentável, garantindo sua perpetuação e a manutenção das formas de vida animal e vegetal. Parabéns a todos e todas!',
            fotos: [],
            videos: [],
            data:  890809,
            qntCurtidas: '40',
            qntComentarios: '1',
            comentarios: [{
              id:11,
              idPublicacao: 54,
              idUsuario: 8,
              nome: 'Joao',
              curso: 'BCC',
              imagem: "assets/img/joao.jpg",
              texto: "Donec vel lobortis eros, vitae elementum metus. Nullam at libero eu sapien feugiat posuere. Ut tincidunt ligula leo, ac ornare nulla varius facilisis. Mauris sed accumsan neque, sit amet sollicitudin dolor. Suspendisse imperdiet porttitor vehicula. Fusce tristique erat a lobortis varius. In egestas purus et pretium laoreet. Phasellus vehicula vitae ante in vulputate. Praesent et turpis mattis dolor imperdiet sagittis molestie quis lorem.",
              data: 890809,
              qntCurtidas: 3
            }]
          }
  		];

  }


  ngOnInit() {
    this.loadNews();
  }

  publicacao(pubTexto: any){
    let novaPublicacao= {
      id: 4,
      texto: pubTexto,
      data: Date.now(),
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
       this.oficial.unshift(novaPublicacao);
    }
        
  }

  addComentario(publicacao: any, comentarioTexto: any){
    let novoComentario = {
      id: 1,
      idPublicacao:10,
      texto: comentarioTexto,
      data: Date.now(),
      curtidas: 0,
      nome: this.usuarioLogado.nome,
      curso: publicacao.curso,
      imagem: this.usuarioLogado.imagem
    }

    if(comentarioTexto!=null && comentarioTexto.length >0){
        publicacao.comentarios.push(novoComentario);
    }
  }
getNews(){return resp;}
loadNews(){
    this.ufrpeService.getNews().subscribe(
        data => {
            xml2js.parseString( data, function (err, result) {
                console.log(result);
                resp = result.rss.channel[0].item;
            });
        },
        error => {
            console.log("ops");
        }
    );
}
}
  


