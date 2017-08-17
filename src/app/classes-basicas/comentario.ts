import { Reacao } from '../classes-basicas/reacao';
import { Publicacao } from '../classes-basicas/publicacao';
import { Usuario } from '../classes-basicas/usuario';

export class Comentario{
    id: number;
    publicacao: Publicacao;
    usuario: Usuario;
    texto: string;
    reacoes: Reacao[];

    dataCriacao: number;
    dataModificacao: number;

    constructor(id: number, publicacao: Publicacao, usuario: Usuario, texto: string){
             this.id = id;
             this.publicacao = publicacao;
             this.usuario = usuario;
             this.texto = texto;
             this.reacoes = [];

             this.dataCriacao = Date.now();
             this.dataModificacao = 0;
    }
}