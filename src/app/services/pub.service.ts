import { Usuario } from '../classes-basicas/usuario';
import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions } from "@angular/http";

@Injectable()
export class PubService {
   
     public static API_HOST:string = "";
     public static readonly TIMEOUT: number = 10000;
     public static pub: any;

    constructor(private http: Http) {
     
    }

    adicionarPub(data:any){
      let headers = new Headers({'Content-Type': 'application/json'});
      let options = new RequestOptions({ headers: headers });
      return this.http.post(PubService.API_HOST+'/api/user/pub', data, options)
         .timeout(PubService.TIMEOUT)
         .map(res => { return res.json();
         });
   }

   //listarPub(data:any){
   listarPub(){
      let headers = new Headers({'Content-Type': 'application/json'});
      let options = new RequestOptions({ headers: headers });
      //return this.http.post(PubService.API_HOST+'/api/user/pub', data, options)
      return this.http.get(PubService.API_HOST+'/api/user/pub', options)  
         .timeout(PubService.TIMEOUT)
         .map(res => { return res.json();});
   }

   //data = id da publicação
   deletarPub(data:any){
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(PubService.API_HOST+'/api/user/pub/id=' + data, options)  
       .timeout(PubService.TIMEOUT)
       .map(res => { return res.json();});
 }

 adicionarCom(data:any){
  let headers = new Headers({'Content-Type': 'application/json'});
  let options = new RequestOptions({ headers: headers });
  return this.http.post(PubService.API_HOST+'/api/user/comentario', data, options)
     .timeout(PubService.TIMEOUT)
     .map(res => { return res.json();
     });
}

//listarCom(data:any){
listarCom(){
  let headers = new Headers({'Content-Type': 'application/json'});
  let options = new RequestOptions({ headers: headers });
  return this.http.get(PubService.API_HOST+'/api/user/comentario', options)  
     .timeout(PubService.TIMEOUT)
     .map(res => { return res.json();});
}

//data = id de comentário
deletarCom(data:any){
let headers = new Headers({'Content-Type': 'application/json'});
let options = new RequestOptions({ headers: headers });
return this.http.delete(PubService.API_HOST+'/api/user/comentario/id=' + data, options)  
   .timeout(PubService.TIMEOUT)
   .map(res => { return res.json();});
}

adicionarReacao(data:any){
  let headers = new Headers({'Content-Type': 'application/json'});
  let options = new RequestOptions({ headers: headers });
  return this.http.post(PubService.API_HOST+'/api/user/reacao', data, options)
     .timeout(PubService.TIMEOUT)
     .map(res => { return res.json();
     });
}

//listarCom(data:any){
listarReacao(){
  let headers = new Headers({'Content-Type': 'application/json'});
  let options = new RequestOptions({ headers: headers });
  return this.http.get(PubService.API_HOST+'/api/user/reacao', options)  
     .timeout(PubService.TIMEOUT)
     .map(res => { return res.json();});
}

//data = id de reação
deletarReacao(data:any){
let headers = new Headers({'Content-Type': 'application/json'});
let options = new RequestOptions({ headers: headers });
return this.http.delete(PubService.API_HOST+'/api/user/reacao/id=' + data, options)  
   .timeout(PubService.TIMEOUT)
   .map(res => { return res.json();});
}

 /*
 salvarPub(){
  let headers = new Headers({'Content-Type': 'application/json'});
  let options = new RequestOptions({ headers: headers });
  //return this.http.post(PubService.API_HOST+'/api/user/pub', data, options)
  return this.http.post(PubService.API_HOST+'/api/user/pub', options)  
     .timeout(PubService.TIMEOUT)
     .map(res => { return res.json();});
 }*/


   setPubs(pub:any){
   	PubService.pub = pub;
   }

   getPubs():any{
   	return PubService.pub;

   }

   logErro(err){
      console.error("Erro: " + err);
  }
 

}