import { Usuario } from '../classes-basicas/usuario';
import '../../bdUsuarios.json';
import '../../bdPostagem.json';
import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions } from "@angular/http";

@Injectable()
export class AvaService {
   
     public static API_HOST:string = "";
     public static readonly TIMEOUT: number = 10000;
     public static user: any;

    constructor(private http: Http) {
     
    }

    signUp(data:any){
      let headers = new Headers({'Content-Type': 'application/json'});
      let options = new RequestOptions({ headers: headers });
      return this.http.post(AvaService.API_HOST+'/api/login', data, options)
         .timeout(AvaService.TIMEOUT)
         .map(res => { return res.json();
         });
   }

   setUser(user:any){
   	AvaService.user = user;
   }

   getUser():any{
   	return AvaService.user;

   }

}