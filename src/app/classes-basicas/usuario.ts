import {Publicacao} from '../classes-basicas/publicacao';
import { TempoAva } from '../classes-basicas/tempo-ava';

export class Usuario{
    id: number;
    idAva: number;
    matricula: string;
    nome: string;
    nomeUsuario: string;
    cidade: string;
    pais: string;
    instituicao: string;
    email: string;
    imagem: any;
    imagemPequena: any;
    descricao: string;
    departamento: string; //na vdd é curso
    publicacoesSalvas: Publicacao[];
    //listaInteresses: boolean[];//true ou false para cada interesse listado
    tempoLembreteAVA: TempoAva;
    token: string;

    dataCriacao: number;
    dataModificacao: number;

    constructor(id: number, idAva: number, matricula: string, nome: string, nomeUsuario: string,
        cidade: string, pais: string, instituicao: string, email: string, imagem: any, imagemPequena: any,
    descricao: string, departamento: string, token: string){
            this.id = id;
            this.idAva = idAva;
            this.matricula = matricula;
            this.nome = nome;
            this.nomeUsuario = nomeUsuario;
            this.cidade = cidade;
            this.pais = pais;
            this.instituicao = instituicao;
            this.email = email;
            this.imagem = imagem;
            this.imagemPequena = imagemPequena;
            this.descricao = descricao;
            this.departamento = departamento;
            this.publicacoesSalvas = [];
            this.tempoLembreteAVA = TempoAva.OITO_HORAS;
            this.token = token;
            
            this.dataCriacao = Date.now();
            this.dataModificacao = 0;
    }
}