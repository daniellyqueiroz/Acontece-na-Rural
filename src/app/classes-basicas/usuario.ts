import {Publicacao} from '../classes-basicas/publicacao';

export class Usuario{
    id: number;
    nome: string;
    nomeUsuario: string;
    senha: string;
    curso: string;
    imagem: any;
    descricao: string;
    idPublicacoesSalvas: number[];
    listaInteresses: boolean[];//true ou false para cada interesse listado
    tempoLembreteAVA: number; //em horas
}