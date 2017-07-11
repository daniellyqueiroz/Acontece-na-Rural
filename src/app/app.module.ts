import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule }   from '@angular/router';

import { AppComponent } from './app.component';
import { BaseSiteComponent } from './site/base-site/base-site.component';
import { LoginComponent } from './site/login/login.component';
import { FeedNoticiasComponent } from './admin/feed-noticias/feed-noticias.component';
import { BaseAdminComponent } from './admin/base-admin/base-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    BaseSiteComponent,
    LoginComponent,
    FeedNoticiasComponent,
    BaseAdminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
    {
	    path: '',
	    component: BaseSiteComponent,
      children:[]
	  },
    { 
      path: 'login', 
      component: LoginComponent 
    },
    {
      path: 'user',
      component: BaseAdminComponent,
      children:[
        { path: '', component: FeedNoticiasComponent}
      ]
    }
	])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }




