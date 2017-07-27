import { Publicacao } from '../classes-basicas/publicacao';
import { Comentario } from '../classes-basicas/comentario';
import { Usuario } from '../classes-basicas/usuario';//remover depois essa importação

export class PublicacaoService {
    private banco: Publicacao[];
    public feed: Publicacao[];
    public usuario: Usuario;

    constructor() {
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

    public getBanco(): Publicacao[] {
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
        ]
    }
}