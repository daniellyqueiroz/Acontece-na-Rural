import { Component, OnInit } from '@angular/core';
declare function initCalendar(array);


@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})



export class CalendarioComponent implements OnInit {



  constructor() {
  	 
   }

  ngOnInit() {
  	this.loadCalendar();
  	
  	
  }

  loadCalendar(){
    // consultar do service
    var array = [
        {
            title: 'Prazo final para os Colegiados de Coordenação Didática (CCD) devolverem os processos de dispensa de disciplina',
            start: '2017-07-14',
            color: '#f39c12'

            //end: '2017-07-23T16:00:00',
            //color: '#257e4a'
        },
        {
            title: 'Data limite para abertura de processo referente às Atividades Acadêmicas Curriculares Complementares (AACC)',
            start: '2017-07-14',
            color: '#f39c12'
        },
        {
            title: 'Solicitação de inscrição em disciplinas isoladas para 2017.2',
            start: '2017-07-17',
            end: '2017-07-21T16:00:00',
            color: '#f39c12'

        },
        {
            title: 'Último dia para cadastramento dos seguros de estágios a serem realizados em agosto',
            start: '2017-07-18',
            color: '#f39c12'

        },
        {
            title: 'Último dia para entrega da frequência de monitoria na PREG',
            start: '2017-07-21',
            color: '#f39c12'

        },
        {
            title: 'Data limite para solicitar ao DRCA mudança de turno para o semestre letivo de 2017.2',
            start: '2017-07-28',
            color: '#f39c12'

        },
        {
            title: 'Data limite para solicitar ao DRCA reintegração para efeito de colação de grau referente ao semestre letivo de 2017.1,',
            start: '2017-07-31',
            color: '#f39c12'

        },
        {
            title: 'Último dia para realização da Autoavaliação Institucional via SIG@',
            start: '2017-07-31',
            color: '#f39c12'

        },
        {
            title: 'Data limite para requerer Regime de Movimentação Temporária (REMT) para o período letivo de 2017.2',
            start: '2017-08-1',
            color: '#f39c12'

        },
        {
            title: 'PREVISÃO para publicação do edital do Processo Seletivo Extra 2017.2 em www.ufrpe.br ',
            start: '2017-08-1',
            color: '#f39c12'

        },
        {
            title: 'PERÍODO SUGERIDO PARA REALIZAÇÃO DA 2ª VERIFICAÇÃO DA APRENDIZAGEM (VA)',
            start: '2017-08-7',
            end: '2017-08-12T16:00:00',
            color: '#f39c12'

        },
        {
            title: 'PREVISÃO do lançamento do edital para ingresso 2017.2 no curso de licenciatura em Ciências Agrícolas em www.ufrpe.br',
            start: '2017-08-11',
            color: '#f39c12'

        },
        {
            title: 'Último dia para cadastramento dos seguros de estágios a serem realizados em setembro',
            start: '2017-08-18',
            color: '#f39c12'

        },
        {
            title: 'Último dia para entrega da frequência de monitoria na PREG',
            start: '2017-08-21',
            color: '#f39c12'

        },
        {
            title: 'PERÍODO PARA REALIZAÇÃO DA 3ª VERIFICAÇÃO DA APRENDIZAGEM (VA)' ,
            start: '2017-08-21',
            end: '2017-08-12T16:00:00',
            color: '#f39c12'

            
        },
        {
            title: 'Último dia para defesa de ESO e/ou monografia referente ao semestre letivo de 2017.1' ,
            start: '2017-08-31',
            color: '#f39c12'

            
        },
        {
            title: 'Término do PRIMEIRO semestre letivo de 2017',
            start: '2017-08-31',
            color: '#f39c12'

        },
        {
            title: 'Provas finais',
            start: '2017-09-4',
            end: '2017-09-9T16:00:00',
            color: '#f39c12'

        },
        {
            title: 'Feriado nacional: Independência do Brasil',
            start: '2017-09-7',
            color: '#257e4a'
        }
      ];
      initCalendar(array);
  }

}
