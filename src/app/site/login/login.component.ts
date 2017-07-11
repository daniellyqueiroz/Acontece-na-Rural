import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  senha: string = "dois";
	tamMaximoSenha: number = 8;
	tamMinimoSenha: number = 12;
	maxCaract: boolean = true;
	minCaract: boolean = true;
	conteudoSenha: boolean = true;
	senhaMaiusc: boolean = true;
	letraMin: boolean = true;
	caractEsp: boolean = true;
	semPV: boolean = true;
	semAspasD: boolean = true;
  
  constructor() { }

  ngOnInit() {
  }

}
