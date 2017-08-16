import { Comentario } from '../classes-basicas/comentario';
import { Reacao } from '../classes-basicas/reacao';

export class Publicacao{
    id: number; 
    idUsuario: number;
    nome: string;
    nomeUsuario: string;
    imagem: any;
    texto: string;
    fotos: any[]; //por enquanto deixar any
    videos: any[];
    data: number;
    pessoasReagiram: Reacao[];
    tags: string[];
    comentarios: Comentario[];
    

    constructor(id: number, idUsuario: number, nome: string, nomeUsuario: string, imagem: any, data: number, texto: string, fotos: any[],
        videos: any[], tags: string[]){
            this.id = id;
            this.idUsuario = idUsuario;
            this.nome = nome;
            this.nomeUsuario = nomeUsuario;
            this.imagem = imagem;
            this.texto = texto;
            this.fotos = fotos;
            this.videos = videos;
            this.data = data;
            this.pessoasReagiram = [];
            this.comentarios = [];
            this.tags = tags;
    }
}