import { TiposReacao } from '../classes-basicas/tipo-reacao';
import { Publicacao } from '../classes-basicas/publicacao';
import { Usuario } from '../classes-basicas/usuario';


export class Reacao{
    id: number;
    publicacao: Publicacao; //publicação ou comentário que a reação está associada
    usuario: Usuario;
    tipoReacao: TiposReacao;

    dataCriacao: number;
    dataModificacao: number;
    
    constructor(id: number, publicacao: Publicacao, usuario: Usuario, tipoReacao: TiposReacao){
        this.id = id;
        this.publicacao = publicacao;
        this.usuario = usuario;
        this.tipoReacao = tipoReacao;

        this.dataModificacao = 0;
    }
}