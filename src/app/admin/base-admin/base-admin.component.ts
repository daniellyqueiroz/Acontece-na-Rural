import { Component, OnInit } from '@angular/core';
import { FeedNoticiasComponent } from '../feed-noticias/feed-noticias.component';

@Component({
  selector: 'app-base-admin',
  templateUrl: './base-admin.component.html',
  styleUrls: ['./base-admin.component.css']
})

export class BaseAdminComponent implements OnInit {

  public feedNoticiasComponent = FeedNoticiasComponent; 

  constructor() {
  }

  ngOnInit() {
  }

}
