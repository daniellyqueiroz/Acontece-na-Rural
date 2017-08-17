import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-configuracao',
  templateUrl: './configuracao.component.html',
  styleUrls: ['./configuracao.component.css']
})
export class ConfiguracaoComponent implements OnInit {

  constructor() { 

  }

  fazerAlteracoes(descricao: string, tempoAva: string, checkNoticias: any){
    if (descricao != null && descricao.length > 0){
      //poderia alterar descrição
    }
    console.log(descricao);
    console.log(tempoAva);
    if (checkNoticias.checked){
      console.log("eh");
    }
  }

  ngOnInit() {
  }

}
