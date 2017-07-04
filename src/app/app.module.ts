import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule }   from '@angular/router';

import { AppComponent } from './app.component';
import { TimelineComponent } from './timeline/timeline.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelineComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {
	    path: '',
	    component: TimelineComponent
	  },
	  {
	    path: 'timeline',
	    component: TimelineComponent
	  }
	])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }




