import { Component, OnInit } from '@angular/core';
import { Comentario } from '../../classes-basicas/comentario';
import { Publicacao } from '../../classes-basicas/publicacao';
import { Usuario } from '../../classes-basicas/usuario';

import { PublicacaoService } from '../../services/publicacao.service';

@Component({
  selector: 'app-feed-noticias',
  templateUrl: './feed-noticias.component.html',
  styleUrls: ['./feed-noticias.component.css']
})

export class FeedNoticiasComponent implements OnInit {

  public feed: Publicacao[];
  public usuarioLogado: Usuario;

  //public usuarioLogado: any;
  public textValue: string = '';


  constructor() {

    this.usuarioLogado = {
      id: 1,
      nome: 'Danielly Queiroz',
      nomeUsuario: 'dani',
      senha: '1234',
      curso: 'Ciência da Computação',
      imagem: "assets/img/fotouser.jpg",
      idPublicacoesSalvas: []
    };

    this.feed = [
      {
        "id": 2,
        "nome": "Danny",
        "nomeUsuario": "dani",
        "imagem": "assets/img/fotouser.jpg",
        "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.",
        "fotos": [],
        "videos": [],
        "data": 890809,
        "pessoasCurtiram": [],
        "pessoasDescurtiram": [],
        "tags": ["ufrpe", "latim"],
        "comentarios": [
          {
            "id": 10,
            "idPublicacao": 54,
            "idUsuario": 8,
            "nomeUsuario": "jnmarcos",
            "nome": "Joao",
            "imagem": "assets/img/joao.jpg",
            "texto": "meu comentario",
            "data": 897987,
            "pessoasCurtiram": [],
            "pessoasDescurtiram": []
          },
          {
            "id": 11,
            "idPublicacao": 54,
            "idUsuario": 8,
            "nomeUsuario": "jnmarcos",
            "nome": "Joao",
            "imagem": "assets/img/joao.jpg",
            "texto": "meu comentario",
            "data": 89908,
            "pessoasCurtiram": [],
            "pessoasDescurtiram": []
          },
          {
            "id": 12,
            "idPublicacao": 54,
            "idUsuario": 8,
            "nomeUsuario": "jnmarcos",
            "nome": "Joao",
            "imagem": "assets/img/joao.jpg",
            "texto": "meu comentario",
            "data": 7897,
            "pessoasCurtiram": [],
            "pessoasDescurtiram": []
          }
        ]
      },
      {
        "id": 11,
        "nome": "Danny",
        "nomeUsuario": "dani",
        "imagem": "assets/img/fotouser.jpg",
        "texto": "Vestibulum auctor dolor vel est vestibulum, ut sodales arcu convallis. Sed faucibus dictum varius. Donec a dictum ante. Vestibulum sollicitudin dui non quam mollis, eget volutpat arcu tristique. Curabitur id accumsan lacus. Nunc vestibulum felis in felis tincidunt porta. Nam vulputate pellentesque hendrerit. Nullam laoreet lectus nunc, sed sollicitudin nisi pulvinar id. Integer pulvinar ipsum nec sapien vestibulum, at ornare quam auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean luctus scelerisque nisl sed fermentum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque malesuada nunc quis erat facilisis, eget aliquet augue lobortis. Fusce quis diam justo.",
        "fotos": [],
        "videos": [],
        "data": 890809,
        "pessoasCurtiram": [],
        "pessoasDescurtiram": [],
        "tags": ["ufrpe", "latim"],
        "comentarios": [
          {
            "id": 32,
            "idPublicacao": 65,
            "idUsuario": 76,
            "nome": "Joao",
            "nomeUsuario": "jnmarcos",
            "imagem": "assets/img/joao.jpg",
            "texto": "meu comentario",
            "data": 89080,
            "pessoasCurtiram": [],
            "pessoasDescurtiram": []
          }
        ]
      },
      {
        "id": 6,
        "nome": "Danny",
        "nomeUsuario": "dani",
        "imagem": "assets/img/fotouser.jpg",
        "texto": "Proin suscipit porta lacus quis suscipit. Morbi dapibus sed felis non congue. Aliquam mollis ac eros ut dictum. Nullam fermentum arcu lacus, eu sagittis purus egestas a. Suspendisse ut cursus velit, ut pretium lacus. Etiam dapibus dolor urna. Nunc blandit urna maximus, convallis libero in, sagittis est. Nam sem ipsum, pretium non lacus et, gravida placerat est. Proin vestibulum ex odio, et eleifend libero rutrum nec. Donec id sapien lacus.",
        "fotos": [],
        "videos": [],
        "data": 890809,
        "pessoasCurtiram": [],
        "pessoasDescurtiram": [],
        "tags": ["ufrpe"],
        "comentarios": [
          {
            "id": 11,
            "idPublicacao": 54,
            "idUsuario": 8,
            "nomeUsuario": "jnmarcos",
            "nome": "Joao",
            "imagem": "assets/img/joao.jpg",
            "texto": "Donec vel lobortis eros, vitae elementum metus. Nullam at libero eu sapien feugiat posuere. Ut tincidunt ligula leo, ac ornare nulla varius facilisis. Mauris sed accumsan neque, sit amet sollicitudin dolor. Suspendisse imperdiet porttitor vehicula. Fusce tristique erat a lobortis varius. In egestas purus et pretium laoreet. Phasellus vehicula vitae ante in vulputate. Praesent et turpis mattis dolor imperdiet sagittis molestie quis lorem.",
            "data": 890809,
            "pessoasCurtiram": [],
            "pessoasDescurtiram": []
          }
        ]
      }
    ];
  }


  ngOnInit() {
  }

  adicionarPublicacao(pubTexto: string, pubFotos: any, pubVideos: any, pubTags: string[]) {
    if (pubTexto != null && pubTexto.length > 0) {
      let pub: Publicacao = new Publicacao(Date.now() + this.usuarioLogado.id, this.usuarioLogado.nome, this.usuarioLogado.nomeUsuario,
        this.usuarioLogado.imagem, Date.now(), pubTexto, pubFotos, pubVideos, pubTags);
      this.feed.unshift(pub);
    }

  }

  removerPublicacao(pub: Publicacao, nomeUsuario: string) {
    if (pub.nomeUsuario == nomeUsuario) {
      let index = this.feed.indexOf(pub);
      this.feed.splice(index, 1);
    }
  }

  adicionarComentario(pub: Publicacao, comentarioTexto: string) {
    if (comentarioTexto != null && comentarioTexto.length > 0) {
      let coment: Comentario = new Comentario(Date.now() + this.usuarioLogado.id, pub.id,
        this.usuarioLogado.id, this.usuarioLogado.nome, this.usuarioLogado.nomeUsuario,
        this.usuarioLogado.imagem, comentarioTexto, Date.now());
      pub.comentarios.push(coment);
    }
  }

  removerComentario(pub: Publicacao, comentario: Comentario, nomeUsuario: string) {
    if (comentario.nomeUsuario == nomeUsuario) {
      let index = pub.comentarios.indexOf(comentario);
      pub.comentarios.splice(index, 1);
    }
  }

  salvarPublicacao(pub: Publicacao) {
    let indexPub: number = this.usuarioLogado.idPublicacoesSalvas.indexOf(pub.id);
    if (indexPub != -1) {//existe, então remover
      this.usuarioLogado.idPublicacoesSalvas.splice(indexPub, 1);//mais novas primeiro
    } else {
      this.usuarioLogado.idPublicacoesSalvas.unshift(pub.id);//mais novas primeiro
    }
  }

  gostarPublicacao(pub: Publicacao, nomeUsuario: string) {
    //se true: gostar
    let indexGostar: number = pub.pessoasCurtiram.indexOf(nomeUsuario);
    if (indexGostar == -1) {//pessoa ainda não curtiu
      pub.pessoasCurtiram.unshift(nomeUsuario);
      let indexNaoGostar = pub.pessoasDescurtiram.indexOf(nomeUsuario);
      pub.pessoasDescurtiram.splice(indexNaoGostar, 1);
    } else {
      pub.pessoasCurtiram.splice(indexGostar, 1);
    }
  }

  naoGostarPublicacao(pub: Publicacao, nomeUsuario: string) {
    let indexNaoGostar: number = pub.pessoasDescurtiram.indexOf(nomeUsuario);
    if (indexNaoGostar == -1) {//pessoa ainda não clicou em 'não gostei'
      pub.pessoasDescurtiram.unshift(nomeUsuario);
      let indexGostar = pub.pessoasCurtiram.indexOf(nomeUsuario);
      pub.pessoasCurtiram.splice(indexGostar, 1);
    } else {
      pub.pessoasDescurtiram.splice(indexNaoGostar, 1);
    }
  }

  gostou(publicacao: Publicacao, nomeUsuario: string): boolean {
    let indexGostar = publicacao.pessoasCurtiram.indexOf(nomeUsuario);
    let retorno = false;
    if (indexGostar != -1) {
      retorno = true;
    }
    return retorno;
  }

  naoGostou(publicacao: Publicacao, nomeUsuario: string): boolean {
    let indexNaoGostar = publicacao.pessoasDescurtiram.indexOf(nomeUsuario);
    let retorno = false;
    if (indexNaoGostar != -1) {
      retorno = true;
    }
    return retorno;
  }
}
