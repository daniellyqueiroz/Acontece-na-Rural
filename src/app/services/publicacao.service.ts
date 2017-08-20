import { Component, OnInit } from '@angular/core';
import{ Http, Jsonp, Headers} from "@angular/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Publicacao } from '../classes-basicas/publicacao';
import { Comentario } from '../classes-basicas/comentario';
import { Usuario } from '../classes-basicas/usuario';
import { Reacao } from '../classes-basicas/reacao';
import { TiposReacao } from '../classes-basicas/tipo-reacao';
import { TempoAva } from '../classes-basicas/tempo-ava';

@Injectable()
export class PublicacaoService implements OnInit{
    private timeout: number = 7500;

    //public feed: any;

    public feed: Publicacao[];
    public usuario: Usuario;
    public usuario2: Usuario;

    public usuarios: Usuario[];
    ngOnInit(){
           
    }

    urlUsuarios: string = "http://localhost:9000/user/listar";
    urlPublicacoes: string = "http://localhost:9000/user/pub";

    constructor(public http: Http){     
        this.feed = this.getBanco();//que funciona
        //this.getPublicacoes();

        this.usuario = {
            id: 1,
            idAva: 3,
            matricula: "kdhjkdah",
            nome: 'Danielly Queiroz',
            nomeUsuario: 'dani',
            cidade:"Recife",
            pais: "Brasil",
            instituicao: "UFRPE",
            email: "danny.hj@out",
            departamento: 'Ciência da Computação',
            imagem: "assets/img/fotouser.jpg",
            imagemPequena: "assets/img/fotouser.jpg",
            descricao: "tudo certo",
            publicacoesSalvas: [
                {
                    "id": 2,
                    "usuario": 
                    {
                        "id": 1,
                        "idAva": 3,
                        "matricula": "kdhjkdah",
                        "nome": 'Danny',
                        "nomeUsuario": 'takanio',
                        "cidade":"Recife",
                        "pais": "Brasil",
                        "instituicao": "UFRPE",
                        "email": "danny@out",
                        "departamento": 'Ciência Comp',
                        "imagem": "assets/img/fotouser.jpg",
                        "imagemPequena": "assets/img/fotouser.jpg",
                        "descricao": "tudo certo",
                        "publicacoesSalvas": [],
                        "tempoLembreteAVA": TempoAva.DOZE_HORAS,
                        "token": "kdjhjsga",
                        "dataCriacao": 9494,
                        "dataModificacao": 9487
                    },
                    "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.",
                    "fotos": [],
                    "videos": [],
                    "dataCriacao": 890809,
                    "dataModificacao": 8474,
                    "reacoes": [],
                    "tags": ["ufrpe", "latim"],
                    "comentarios": []
                }
            ],
            tempoLembreteAVA: TempoAva.DOZE_HORAS,
            token: "kdjhjsga",
            dataCriacao: 9494,
            dataModificacao: 9487
          };
    }

    getPublicacoes() {
        this.http.get(this.urlPublicacoes)
                .map(res => res.json())
                .subscribe(
                       data => this.feed = data, 
                       err => this.logErro(err),
                       () => console.log("Pegou Publicações")
                );
    }

    
    getUsuarios() {
        this.http.get(this.urlUsuarios)
                   .map(res => res.json())
                   .subscribe(
                        data => this.usuarios = data,
                        err => this.logErro(err),
                        () => console.log("Pegou Usuários")
                   );
    }

    autenticar(username: String, password: String) {      
        var creds = "{username:" + username + ",password:" + password + "}";
      
        var headers = new Headers();
        headers.append('Content-Type', 'application/json');
      
        this.http.post('http://localhost:9000/req', creds, {
          headers: headers
          })
          .map(res => res.json())
          .subscribe(
            data => this.saveJwt(data.token),
            err => this.logErro(err),
            () => console.log('Authentication Complete')
          );
    }

    saveJwt(jwt) {
        if(jwt) {
          localStorage.setItem('token', jwt)
        }
      }

    logErro(err){
        console.error("Erro: " + err);
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
    
    ehReacaoGostar(reacao: Reacao): boolean{
          return reacao.tipoReacao == TiposReacao.Gostar;
    }

    ehReacaoNaoGostar(reacao: Reacao): boolean{
        return reacao.tipoReacao == TiposReacao.NaoGostar;
    }

    gostarPublicacao (pub: Publicacao, reacao: Reacao){
          let reacoes = pub.reacoes;
          let indexGostar: number = -1;
          let reacaoBD: Reacao;
        for (var index = 0; index < reacoes.length; index++) {
            if (reacoes[index].usuario.id === reacao.usuario.id){
                  indexGostar =  index;
                  reacaoBD = reacoes[index];
                  break;
            } 
        }

        if (indexGostar == -1) {//pessoa ainda não reagiu
            pub.reacoes.unshift(reacao); //add no topo
        } else {
            if (reacaoBD.tipoReacao == TiposReacao.NaoGostar){
                //aproveita-se a reação original
                //só muda o tipo
                reacaoBD.tipoReacao = TiposReacao.Gostar;
            } else {
                pub.reacoes.splice(indexGostar, 1); //remove a reação
            }
        }
    }

    quantidadeGostar(pub: Publicacao){
        return pub.reacoes.filter(this.ehReacaoGostar);
    }

    quantidadeNaoGostar(pub: Publicacao){
        return pub.reacoes.filter(this.ehReacaoNaoGostar);
    }

    naoGostarPublicacao (pub: Publicacao, reacao: Reacao){
        let reacoes = pub.reacoes;
        let indexGostar: number = -1;
        let reacaoBD: Reacao;
        for (var index = 0; index < reacoes.length; index++) {
            if (reacoes[index].usuario.id === reacao.usuario.id){
                indexGostar =  index;
                reacaoBD = reacoes[index];
                break;
            } 
        }

        if (indexGostar == -1) {//pessoa ainda não reagiu
            pub.reacoes.unshift(reacao); //add no topo
        } else {
            if (reacaoBD.tipoReacao == TiposReacao.Gostar){
                reacaoBD.tipoReacao = TiposReacao.NaoGostar;
            } else {
                pub.reacoes.splice(indexGostar, 1); //remove a reação
            }
        }
    }
    
    gostou(pub: Publicacao, idUsuario: number): boolean {
        let reacoes = pub.reacoes;
        let indexGostar: number = -1;
        for (var index = 0; index < reacoes.length; index++) {
            if (reacoes[index].usuario.id === idUsuario
                && reacoes[index].tipoReacao == TiposReacao.Gostar){
                indexGostar =  index;
                break;
            } 
        }
        let ehGostou = false;
        if (indexGostar != -1) {
          ehGostou = true;
        }
        return ehGostou;
    }
    
    naoGostou(pub: Publicacao, idUsuario: number): boolean {
        let reacoes = pub.reacoes;
        let indexNaoGostar: number = -1;
        for (var index = 0; index < reacoes.length; index++) {
            if (reacoes[index].usuario.id === idUsuario
                && reacoes[index].tipoReacao == TiposReacao.NaoGostar){
                indexNaoGostar =  index;
                break;
            } 
        }

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

    filtrarPublicacoesPorUsuario(pubs: Publicacao[], idUsuario: number): Publicacao[]{
        let pubsUsuario: Publicacao[] = [];
        for (var index = 0; index < pubs.length; index++) {
            if (pubs[index].usuario.id == idUsuario){
                console.log(pubs[index].id)
                pubsUsuario.push(pubs[index]);
            } 
        }
        return pubsUsuario;
    }

    public salvarBanco(){

    }
    public getBanco(): any {
        return [
            {
                "id": 2,
                "usuario": 
                {
                    "id": 2,
                    "idAva": 3,
                    "matricula": "kdhjkdah",
                    "nome": 'Otaku',
                    "nomeUsuario": 'takanio',
                    "cidade":"Recife",
                    "pais": "Brasil",
                    "instituicao": "UFRPE",
                    "email": "otaku.hj@out",
                    "departamento": 'Ciência da Computação',
                    "imagem": "assets/img/fotouser.jpg",
                    "imagemPequena": "assets/img/fotouser.jpg",
                    "descricao": "tudo certo",
                    "publicacoesSalvas": [],
                    "tempoLembreteAVA": TempoAva.DOZE_HORAS,
                    "token": "kdjhjsga",
                    "dataCriacao": 9494,
                    "dataModificacao": 9487
                },
                "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.",
                "fotos": [],
                "videos": [],
                "dataCriacao": 890809,
                "dataModificacao": 8474,
                "reacoes": [],
                "tags": ["ufrpe", "latim"],
                "comentarios": []
            },
            {
                "id": 7,
                "usuario":
                {
                    "id": 3,
                    "idAva": 3,
                    "matricula": "kdhjkdah",
                    "nome": 'Mister poool',
                    "nomeUsuario": 'takanio',
                    "cidade":"Recife",
                    "pais": "Brasil",
                    "instituicao": "UFRPE",
                    "email": "otaku.hj@out",
                    "departamento": 'Florestal',
                    "imagem": "assets/img/joao.jpg",
                    "imagemPequena": "assets/img/joao.jpg",
                    "descricao": "tudo certo",
                    "publicacoesSalvas": [],
                    "tempoLembreteAVA": TempoAva.DOZE_HORAS,
                    "token": "kdjhjsga",
                    "dataCriacao": 9494,
                    "dataModificacao": 9487
                },
                "texto": "Virir, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.",
                "fotos": [],
                "videos": [],
                "dataCriacao": 98987,
                "dataModificacao": 8474,
                "reacoes": [],
                "tags": ["ufrpe"],
                "comentarios": []
            },
            {
                "id": 10,
                "usuario":
                {
                    "id": 1,
                    "idAva": 3,
                    "matricula": "kdhjkdah",
                    "nome": 'Danny',
                    "nomeUsuario": 'takanio',
                    "cidade":"Recife",
                    "pais": "Brasil",
                    "instituicao": "UFRPE",
                    "email": "danny@out",
                    "departamento": 'Ciência Comp',
                    "imagem": "assets/img/fotouser.jpg",
                    "imagemPequena": "assets/img/fotouser.jpg",
                    "descricao": "tudo certo",
                    "publicacoesSalvas": [],
                    "tempoLembreteAVA": TempoAva.DOZE_HORAS,
                    "token": "kdjhjsga",
                    "dataCriacao": 9494,
                    "dataModificacao": 9487
                },
                "texto": "Virir, consectetur adipiscing elit. Integer et diam sit amet tortor euismod convallis. Etiam id commodo magna, nec porta sapien. Vestibulum tempus dolor velit, et ornare urna consectetur vitae. Maecenas egestas laoreet dapibus. Cras maximus sem sit amet justo tristique, nec condimentum mauris pretium. Morbi imperdiet porta ligula, a placerat urna sagittis efficitur. Morbi lacus orci, elementum quis maximus et, fringilla nec quam. Pellentesque suscipit tellus nec semper mattis. Suspendisse ultricies eget lectus et efficitur.",
                "fotos": [],
                "videos": [],
                "dataCriacao": 98987,
                "dataModificacao": 8474,
                "reacoes": [],
                "tags": ["ufrpe"],
                "comentarios": []
            }
        ]
    }
}