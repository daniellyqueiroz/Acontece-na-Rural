import { Comentario } from '../classes-basicas/comentario';
import { Usuario } from '../classes-basicas/usuario';
import { Reacao } from '../classes-basicas/reacao';

export class Publicacao{
    id: number; 
    usuario: Usuario;
    texto: string;
    fotos: any[]; //por enquanto deixar any
    videos: any[];
    reacoes: Reacao[];
    tags: string[];
    comentarios: Comentario[];

    dataCriacao: number;
    dataModificacao: number;

    constructor(id: number, usuario: Usuario, texto: string, fotos: any[], videos: any[], 
        tags: string[]){
            this.id = id;
            this.usuario = usuario;
            this.texto = texto;
            this.fotos = fotos;
            this.videos = videos;
            this.reacoes = [];
            this.comentarios = [];
            this.tags = tags;

            this.dataCriacao = Date.now();
            this.dataModificacao = 0;
    }
}