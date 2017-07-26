import { Usuario } from '../classes-basicas/usuario';
import '../../bdUsuarios.json';
import '../../bdPostagem.json';


export class AvaService {
    public usuarios: Usuario[];

    constructor() {
        
    }


    getBanco(): Usuario[] {
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