export class Usuario{
    nome: string;
    senha: string;
    nome_usuario: string;
}
export class AvaService {
    usuarios: Array<Usuario>;
    constructor() {
        this.usuarios = [
            {
                nome: "João Marcos Nascimento da Silva",
                senha: "batatadoce",
                nome_usuario: "jnmarcos"
            },
            {
                nome: "Dannyele",
                senha: "danibananinha",
                nome_usuario: "dani"
            },
            {
                nome: "Bruno",
                senha: "angular2ehmaisfacil",
                nome_usuario: "brunomax"
            },
            {
                nome: "Alex Sandro N da Silva",
                senha: "kimika",
                nome_usuario: "alx"
            }
        ]
    }

    get() {
        return this.usuarios;
    }

    logar(usuario: string, senha: string): boolean {
        for (var index = 0; index < this.usuarios.length; index++) {
          if (this.usuarios[index].nome == usuario && 
            this.usuarios[index].senha == senha){
                console.log("entrou");
          }

        }
        return true;
    }
}