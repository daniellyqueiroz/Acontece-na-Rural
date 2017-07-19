import { Component, OnInit } from '@angular/core';

declare function setLoginBg();

@Component({
  selector: 'app-base-site',
  templateUrl: './base-site.component.html',
  styleUrls: ['./base-site.component.css']
})
export class BaseSiteComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  	setLoginBg();
  }

}
