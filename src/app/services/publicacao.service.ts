import{ Http, Jsonp} from "@angular/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Publicacao } from '../classes-basicas/publicacao';
import { Comentario } from '../classes-basicas/comentario';
import { Usuario } from '../classes-basicas/usuario';

@Injectable()
export class PublicacaoService {
    private timeout: number = 7500;

    //private banco: Publicacao[];
    public feed: Publicacao[];
    public usuario: Usuario;

   // constructor(public http: Http, public jsonp: Jsonp) {
    //this.http = http;
    //this.jsonp = jsonp;
    constructor(){ 
        this.feed = this.getBanco();
        this.usuario = {
            id: 1,
            nome: 'Danielly Queiroz',
            nomeUsuario: 'dani',
            senha: '1234',
            curso: 'Ciência da Computação',
            imagem: "assets/img/fotouser.jpg",
            descricao: 'tudo certo',
            publicacoesSalvas: [
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
                            "texto": "Proin facilisis in eros quis euismod. Etiam pharetra vestibulum turpis sit amet congue. Mauris molestie lorem non mauris consectetur, quis volutpat urna rhoncus. Pellentesque condimentum justo enim, a bibendum lacus lobortis a. Nunc non venenatis magna, et interdum sem. Sed blandit velit a ipsum consectetur, non auctor nisi condimentum. Morbi in iaculis justo, in tempus turpis.",
                            "data": 897987,
                            "pessoasCurtiram": [],
                            "pessoasDescurtiram": []
                        },
                        {
                            "id": 11,
                            "idPublicacao": 54,
                            "idUsuario": 8,
                            "nomeUsuario": "Usuario 1",
                            "nome": "Joao",
                            "imagem": "assets/img/usuario1.jpg",
                            "texto": "Curabitur interdum urna nec ex egestas, et mattis tortor gravida. Aenean id diam nec arcu pulvinar luctus. Phasellus sollicitudin dictum leo, vitae luctus ante facilisis id. Mauris non consequat erat. In congue tortor in volutpat lobortis. In rutrum a neque vel eleifend. Nullam tincidunt ante quis egestas hendrerit.",
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
                }
            ],
            listaInteresses: [],
            tempoLembreteAVA: 24
          };
    }

    adicionarPublicacao(pub: Publicacao) {
        this.feed.unshift(pub);
    }

    removerPublicacao(index: number) {
        this.feed.splice(index, 1);
    }

    adicionarComentario(pub: Publicacao, com: Comentario) {
        pub.comentarios.push(com);
    }

    removerComentario(pub: Publicacao, comentario: Comentario, index: number) {
        pub.comentarios.splice(index, 1);
    }

    salvarPublicacao(pub: Publicacao) {
        let indexPub: number = this.usuario.publicacoesSalvas.indexOf(pub);
        if (indexPub != -1) {//existe, então remover
          this.usuario.publicacoesSalvas.splice(indexPub, 1);//mais novas primeiro
        } else {
          this.usuario.publicacoesSalvas.unshift(pub);//mais novas primeiro
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
        let ehGostou = false;
        if (indexGostar != -1) {
          ehGostou = true;
        }
        return ehGostou;
      }
    
      naoGostou(publicacao: Publicacao, nomeUsuario: string): boolean {
        let indexNaoGostar = publicacao.pessoasDescurtiram.indexOf(nomeUsuario);
        let ehNaoGostou = false;
        if (indexNaoGostar != -1) {
          ehNaoGostou = true;
        }
        return ehNaoGostou;
      }
    
      estaSalvaPublicacao(pub: Publicacao): boolean{
        let indexPub: number = this.usuario.publicacoesSalvas.indexOf(pub);
        let estaSalvo = false;
        if (indexPub != -1){//a publicação está salva
          estaSalvo = true;
        }
        return estaSalvo;
      }

    public salvarBanco(){

    }

    /*
    public getBanco2(): any {
        return this.http.get("http://localhost:3000/postagens")
        .timeout(this.timeout)
        .map(res => res.text());
    }

    public getBanco3(): any {
        return this.jsonp.get("http://localhost:3000/postagens")
        .toPromise().then(resp => resp.text());
    }
    */

    public getBanco(): any {
        return [
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
                        "nomeUsuario": "Usuario 1",
                        "nome": "Usuario 1",
                        "imagem": "assets/img/usuario1.jpg",
                        "texto": "Proin facilisis in eros quis euismod. Etiam pharetra vestibulum turpis sit amet congue. Mauris molestie lorem non mauris consectetur, quis volutpat urna rhoncus. Pellentesque condimentum justo enim, a bibendum lacus lobortis a. Nunc non venenatis magna, et interdum sem. Sed blandit velit a ipsum consectetur, non auctor nisi condimentum. Morbi in iaculis justo, in tempus turpis.",
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
                        "texto": "Aliquam orci lectus, venenatis et tempor sed, varius eu ipsum. Duis congue ultricies felis et gravida. Vestibulum a nunc porttitor, sodales tortor sit amet, consequat est. Proin eleifend diam iaculis quam vestibulum finibus. Donec quis accumsan lorem. Sed porttitor venenatis ultricies. Sed blandit, nisi nec pulvinar dapibus, dui justo aliquam diam",
                        "data": 89908,
                        "pessoasCurtiram": [],
                        "pessoasDescurtiram": []
                    },
                    {
                        "id": 12,
                        "idPublicacao": 54,
                        "idUsuario": 8,
                        "nomeUsuario": "Usuario2",
                        "nome": "Usuario2",
                        "imagem": "assets/img/usuario2.jpg",
                        "texto": " a tempor urna augue at sapien. Etiam id aliquet odio, non fermentum dui. Nunc lobortis nulla ut turpis scelerisque, at convallis leo hendrerit. Pellentesque et ante scelerisque, sagittis nunc at, rutrum est. Praesent non quam nec elit pulvinar tincidunt. :)",
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
                        "nome": "Usuario 3",
                        "nomeUsuario": "Usuario 3",
                        "imagem": "assets/img/usuario3.jpg",
                        "texto": "Donec at ipsum lectus. Ut id rutrum eros, vel condimentum urna. Vestibulum id erat ac erat porta hendrerit. Vestibulum placerat pellentesque luctus. ",
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
        ]
    }
}