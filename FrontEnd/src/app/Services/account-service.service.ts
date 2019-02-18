import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { Customer } from "app/Models/customer";
import { Account } from "app/Models/account";
import { delay,map, catchError } from 'rxjs/operators';
import {Http, Response,RequestOptions, Headers} from '@angular/http';
import { Router } from "@angular/router";


@Injectable()
export class AccountServiceService {

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
  
  
  
/*  
  customerId:number;
  getCustId(customerId)
  {
      console.log("inside service+++++.........");

  console.log(customerId);
      this.customerId=customerId;
     this.router.navigateByUrl('/accountRegister');
     
      
      
  }
  custIdReturn()
  {
      console.log("custReturn@@@@@@@@@@@@@@@@@");
      console.log(this.customerId);
      return this.customerId;
  }
  
  */
  
  
  createAccount(account:Account):Observable<Account>
  {
      console.log("inside serviceeeeeeeewee");
      console.log(account);

      return this.http.post("http://localhost:8080/Banking_System/AccountController/createAccount",account).pipe(map((response)=>{
          console.log("Account details in service");

          console.log(account);
          let json = null;
          try{
            
              json =  this.handleResponse(response);
              console.log("*****************"+this.http.post("http://localhost:8080/Banking_System/AccountController/createAccount",account));
              if(json==null)
              {
                  throw new Error("Account Insertion failed");
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
  
  
  getAllAccounts(): Observable<Account[]> {

      // return Observable.of( this.customers ).pipe( delay( 4000 ) );
       
       return this.http.get("http://localhost:8080/Banking_System/AccountController/viewAllAccounts").pipe(map((response)=>{
             
              let json = null;
              try{
                
                  json =  this.handleResponse(response);
                 
                  if(json==null){
                      throw new Error("Account details not found");
                  }
                  
              }catch(e){
                  console.log(e)
                  
                  throw new Error(e);
              }
              
              return json;
       }),catchError((error)=>{
           
           if(error instanceof Response){
               return Observable.throw("Server Communication Failed");
           }           
           return Observable.throw(error);
       }));



   }
  
  
  





 deleteAccount(accountNo: number):Observable<boolean>
 {
     console.log(accountNo);
     
     return this.http.delete("http://localhost:8080/Banking_System/AccountController/deleteAccount/"+accountNo).pipe(map((response)=>
     {
     let json = null;
     try{
             json =  this.handleResponse(response);
             if(json==null)
             {
                  throw new Error("Account details not found");
              }

           }
       catch(e)
       {
           console.log(e)
           throw new Error(e);
        }
        return json;
      }),
      catchError((error)=>{
      if(error instanceof Response)
      {
          return Observable.throw("Server Communication Failed");
      }       
  
      return Observable.throw(error);
  
      }));

 }
 

 getviewAccountByAccountNo(accountNo: number):Observable<Account>
 {
     return this.http.get("http://localhost:8080/Banking_System/AccountController/viewAccountByAccountId/"+accountNo).pipe(map((response)=>
     {
     let json = null;
     try{
             json =  this.handleResponse(response);
             if(json==null)
             {
                  throw new Error("Account details not found");
              }

           }
       catch(e)
       {
           console.log(e)
           throw new Error(e);
        }
        return json;
      }),
      catchError((error)=>{
      if(error instanceof Response)
      {
          return Observable.throw("Server Communication Failed");
      }       
  
      return Observable.throw(error);
  
      }));

 }
  
  
  
  
}
