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
            title: 'entrega da frequencia monitoria na PREG entrega da frequencia monitoria na PREG entrega da frequencia monitoria na PREG entrega da frequencia monitoria na PREG entrega da frequencia monitoria na PREG',
            start: '2017-07-21',
            end: '2017-07-23T16:00:00',
            color: '#257e4a'
        },
        {
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24',
            color: '#f39c12'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },{
            title: 'REALIZAÇÃO DA 2ª VA',
            start: '2017-07-24'
        },
        {
            title: 'evento 1',
            start: '2017-07-1'
        },
        {
            title: 'evento 2',
            start: '2017-07-4'
        },
        {
            title: 'evento 3',
            start: '2017-07-10'
        },
        {
            title: 'evento 4',
            start: '2017-07-30'
        },
        {
            title: 'evento 5',
            start: '2017-07-16'
        },
        {
            title: 'evento 6' ,
            start: '2017-07-19'
            
        },
        {
            title: 'teste' ,
            start: '2017-07-18'
            
        }
      ];
      initCalendar(array);
  }

}
