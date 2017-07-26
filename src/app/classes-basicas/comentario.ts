export class Comentario{
    id: number;
    idPublicacao: number; //publicação ao qual o comentário está associado
    idUsuario: number; 
    nome: string;
    nomeUsuario: string;
    imagem: any;
    texto: string;
    data: number;
    pessoasCurtiram: string[];
    pessoasDescurtiram: string[];

    constructor(id: number, idPublicacao: number, idUsuario: number, nome: string, nomeUsuario: string,
         imagem: any, texto: string, data: number){
             this.id = id;
             this.idPublicacao = idPublicacao;
             this.idUsuario = idUsuario;
             this.nome = nome;
             this.nomeUsuario = nomeUsuario;
             this.imagem = imagem;
             this.texto = texto;
             this.data = data;
             this.pessoasCurtiram = [];
             this.pessoasDescurtiram = [];
    }
}