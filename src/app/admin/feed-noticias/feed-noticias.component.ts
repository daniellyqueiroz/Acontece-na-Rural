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

  	this.usuarioLogado = {
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
  			texto : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.',
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
            nome: this.usuarioLogado.nome,
            imagem: this.usuarioLogado.imagem,
            texto : 'Vestibulum auctor dolor vel est vestibulum, ut sodales arcu convallis. Sed faucibus dictum varius. Donec a dictum ante. Vestibulum sollicitudin dui non quam mollis, eget volutpat arcu tristique. Curabitur id accumsan lacus. Nunc vestibulum felis in felis tincidunt porta. Nam vulputate pellentesque hendrerit. Nullam laoreet lectus nunc, sed sollicitudin nisi pulvinar id. Integer pulvinar ipsum nec sapien vestibulum, at ornare quam auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean luctus scelerisque nisl sed fermentum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque malesuada nunc quis erat facilisis, eget aliquet augue lobortis. Fusce quis diam justo.',
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
            nome: this.usuarioLogado.nome,
            imagem: this.usuarioLogado.imagem,
            texto : 'Proin suscipit porta lacus quis suscipit. Morbi dapibus sed felis non congue. Aliquam mollis ac eros ut dictum. Nullam fermentum arcu lacus, eu sagittis purus egestas a. Suspendisse ut cursus velit, ut pretium lacus. Etiam dapibus dolor urna. Nunc blandit urna maximus, convallis libero in, sagittis est. Nam sem ipsum, pretium non lacus et, gravida placerat est. Proin vestibulum ex odio, et eleifend libero rutrum nec. Donec id sapien lacus.',
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
       this.feed.unshift(novaPublicacao);
    }
        
  }

  addComentario(publicacao: any, comentarioTexto: any){
    let novoComentario = {
      id: 1,
      idPublicacao:10,
      texto: comentarioTexto,
      data: Date.now(),
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
