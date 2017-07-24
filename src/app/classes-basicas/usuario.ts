import {Publicacao} from '../classes-basicas/publicacao';

export class Usuario{
    id: number;
    nome: string;
    nomeUsuario: string;
    senha: string;
    curso: string;
    imagem: any;
    idPublicacoesSalvas: number[];
}