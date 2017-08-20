import { Usuario } from '../classes-basicas/usuario';
import '../../bdUsuarios.json';
import '../../bdPostagem.json';
import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions } from "@angular/http";

@Injectable()
export class PubService {
   
     public static API_HOST:string = "";
     public static readonly TIMEOUT: number = 10000;
     public static pub: any;

    constructor(private http: Http) {
     
    }

    cadastrarPub(data:any){
      let headers = new Headers({'Content-Type': 'application/json'});
      let options = new RequestOptions({ headers: headers });
      return this.http.post(PubService.API_HOST+'/api/user/pub', data, options)
         .timeout(PubService.TIMEOUT)
         .map(res => { return res.json();
         });
   }
   listarPub(data:any){
      let headers = new Headers({'Content-Type': 'application/json'});
      let options = new RequestOptions({ headers: headers });
      return this.http.post(PubService.API_HOST+'/api/user/pub', data, options)
         .timeout(PubService.TIMEOUT)
         .map(res => { return res.json();
         });
   }


   setUser(pub:any){
   	PubService.pub = pub;
   }

   getUser():any{
   	return PubService.pub;

   }
 

}