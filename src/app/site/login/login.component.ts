import {Component} from '@angular/core';
import { AvaService } from '../../services/ava.service';
import { FormsModule }   from '@angular/forms'; 
import {Router} from '@angular/router';
import { Http, Headers, RequestOptions } from "@angular/http";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AvaService]

})


export class LoginComponent {
  public erroLogin : boolean;
  public erroSenha : boolean;
  public erroMessage :String;

  public data:  any = {};

    constructor(private avaService: AvaService, private http: Http, private router:Router){
      this.erroSenha = false;
      this.erroLogin = false;
      this.erroMessage = "";

    }

  loginAva(username:any, password: any){
    if(username.length == 0|| password.length == 0){
      this.erroLogin = username.length == 0;
      this.erroSenha = password.length ==0;
      return ;
    }else{
      this.erroLogin = false;
      this.erroSenha = false;
      this.data.username = username;
      this.data.password = password;
      this.avaService.signUp(this.data)
      .subscribe(
        data => {
          if (data.hasOwnProperty('message')) {
            this.erroMessage = data.message;
        // todo msg para o usuário 

          }else {
            this.avaService.setUser(data);
            //this.router.navigate(['/user/feed']);
          }
        },
        error => {
          console.log('erro de conexao');
      });
      
  }
}

}
