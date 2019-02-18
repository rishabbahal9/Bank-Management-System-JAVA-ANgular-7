import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { Transaction } from "app/Models/transaction";
import { delay,map, catchError } from 'rxjs/operators';
import {Http, Response,RequestOptions, Headers} from '@angular/http';
import { Router } from "@angular/router";
import{Account} from "app/Models/account";



@Injectable()
export class TransactionServiceService {

    constructor(private http:Http,private router:Router) { }
    
  
  
  handleResponse(resp:any){
      
      if(resp instanceof Response){
          
          if(resp.ok==true){
              
               return resp.json();
            }
              return resp;           
      }else{
          return resp;
      }
      
  }
  
  transaction:Transaction = new Transaction();

   Deposit(transaction:Transaction):Observable<boolean>
  {
      
      return this.http.post("http://localhost:8080/Banking_System/TransactionController/Deposit",transaction).pipe(map((response)=>{
          console.log("details in service");

          console.log(transaction);
          let json = null;
          try{
            
              json =  this.handleResponse(response);
              console.log("*****************"+this.http.post("http://localhost:8080/Banking_System/TransactionController/Deposit",transaction));
              if(json==null)
              {
                  throw new Error("Deposit  failed");
              }
              
          }catch(e){
              console.log(e)
              
              throw new Error("ServerError : "+e);
          }
          
          return json;
   }),catchError((error)=>{
       
       if(error instanceof Response){
           return Observable.throw("Server Communication Failed");
       }           
       return Observable.throw(error);
   }));
      
      
      
      
      
      
  }
 
   
   


   Withdraw(transaction:Transaction):Observable<Transaction>
  {
      
      return this.http.post("http://localhost:8080/Banking_System/TransactionController/Withdraw",transaction).pipe(map((response)=>{
          console.log("details in service");

          console.log(transaction);
          let json = null;
          try{
            
              json =  this.handleResponse(response);
              console.log("*****************"+this.http.post("http://localhost:8080/Banking_System/TransactionController/Withdraw",transaction));
              if(json==null)
              {
                  throw new Error("Withdraw  failed");
              }
              
          }catch(e){
              console.log(e)
              
              throw new Error("ServerError : "+e);
          }
          
          return json;
   }),catchError((error)=>{
       
       if(error instanceof Response){
           return Observable.throw("Server Communication Failed");
       }           
       return Observable.throw(error);
   }));
      
      
      
      
      
      
  }
 
   
   Transfer(transaction:Transaction):Observable<boolean>
   {
       
       return this.http.post("http://localhost:8080/Banking_System/TransactionController/Transfer",transaction).pipe(map((response)=>{
           console.log("details in service");

           console.log(transaction);
           let json = null;
           try{
             
               json =  this.handleResponse(response);
               console.log("*****************"+this.http.post("http://localhost:8080/Banking_System/TransactionController/Transfer",transaction));
               if(json==null)
               {
                   throw new Error("tran  failed");
               }
               
           }catch(e){
               console.log(e)
               
               throw new Error("ServerError : "+e);
           }
           
           return json;
    }),catchError((error)=>{
        
        if(error instanceof Response){
            return Observable.throw("Server Communication Failed");
        }           
        return Observable.throw(error);
    }));
       
       
       
       
       
       
   }
 
 
 
 
 
 
 

}
