import { TiposReacao } from '../classes-basicas/tipo-reacao';

export class Reacao{
    id: number;
    idPubliCom: number; //publicação ou comentário que a reação está associada
    idUsuario: number;
    tipoReacao: TiposReacao;
    
    constructor(id: number, idPubliCom: number, idUsuario: number, tipoReacao: TiposReacao){
        this.id = id;
        this.idPubliCom = idPubliCom;
        this.idUsuario = idUsuario;
        this.tipoReacao = tipoReacao;
    }
}