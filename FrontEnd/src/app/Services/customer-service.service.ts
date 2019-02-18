import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { Customer } from "app/Models/customer";
import { delay,map, catchError } from 'rxjs/operators';
import {Http, Response,RequestOptions, Headers} from '@angular/http';
import { Router } from "@angular/router";


@Injectable()
export class CustomerServiceService {

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
  customer:Customer = new Customer();
  custGet(customer)
  {
      this.customer=customer;
      this.router.navigateByUrl('/customerUpdate');
      
      
  }
  custReturn()
  {
      console.log("custReturn@@@@@@@@@@@@@@@@@");
      console.log(this.customer);
      return this.customer;
  }
  
  insertCustomer(customer:Customer):Observable<Customer>
  {
      
      return this.http.post("http://localhost:8080/Banking_System/CustomerController/CreateCustomer",customer).pipe(map((response)=>{
          console.log("customer details in service");

          console.log(customer);
          let json = null;
          try{
            
              json =  this.handleResponse(response);
              console.log(this.http.post("http://localhost:8080/Banking_System/CustomerController/CreateCustomer",customer));
              if(json==null)
              {
                  throw new Error("Customer Insertion failed");
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
  
  
  
  getAllCustomers(): Observable<Customer[]> {

      // return Observable.of( this.customers ).pipe( delay( 4000 ) );
       
       return this.http.get("http://localhost:8080/Banking_System/CustomerController/viewAllCustomers").pipe(map((response)=>{
             
              let json = null;
              try{
                
                  json =  this.handleResponse(response);
                 
                  if(json==null){
                      throw new Error("Customer details not found");
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

  

  updateCustomer( cust: Customer ): Observable<boolean> {

      /*let flag: boolean = false;

      this.customers.forEach(( data ) => {
          
          if ( data.custid == cust.custid ) {

              data.custname = cust.custname;
              data.age = cust.age;
              data.gender = cust.gender;
              data.telnum = cust.telnum;

              flag = true;
          }
      } );
      return Observable.of( flag ).pipe( delay( 4000 ) );*/
      
 return this.http.put("http://localhost:8080/Banking_System/CustomerController/updateCustomers",cust).pipe(map((response)=>{
          
          let json = null;
          try{
            
              json =  this.handleResponse(response);
             
              if(json==null || json==""){
                  throw new Error("Customer Updation Failed");
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

  deleteCustomer(customerId: number):Observable<boolean>
  {
      console.log(customerId);
      
      return this.http.delete("http://localhost:8080/Banking_System/CustomerController/deleteCustomer/"+customerId).pipe(map((response)=>
      {
      let json = null;
      try{
              json =  this.handleResponse(response);
              if(json==null)
              {
                   throw new Error("Customer details not found");
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






































