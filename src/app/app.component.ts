import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


@NgModule({
  imports: [
   FormsModule
  ]
})
export class AppComponent {
  title = 'Acontece Na Rural';
}
