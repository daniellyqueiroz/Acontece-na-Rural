import { Comentario } from '../classes-basicas/comentario';

export class Publicacao{
    id: number; 
    nome: string;
    nomeUsuario: string;
    imagem: any;
    texto: string;
    fotos: any[]; //por enquanto deixar any
    videos: any[];
    data: number;
    pessoasCurtiram: string[];
    pessoasDescurtiram: string[];
    comentarios: Comentario[];
    tags: string[];

    constructor(id: number, nome: string, nomeUsuario: string, imagem: any, texto: string, fotos: any[],
        videos: any[], data: number, tags: string[]){
            this.id = id;
            this.nome = nome;
            this.nomeUsuario = nomeUsuario;
            this.imagem = imagem;
            this.texto = texto;
            this.fotos = fotos;
            this.videos = videos;
            this.data = data;
            this.pessoasCurtiram = [];
            this.pessoasDescurtiram = [];
            this.comentarios = [];
            this.tags = tags;
    }
}