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

    logar(login: string, senha: string): boolean{
        return true;
    }
}