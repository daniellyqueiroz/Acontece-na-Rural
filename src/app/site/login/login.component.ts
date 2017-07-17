import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import {AvaService} from '../../services/ava.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AvaService]
  
})
export class LoginComponent {
    servico: AvaService;

    constructor(servico: AvaService){
      this.servico = servico;
    }

    logar (usuario: string, senha: string){
      console.log(usuario + " " + senha);
      this.servico.logar(usuario, senha);
    }
}
