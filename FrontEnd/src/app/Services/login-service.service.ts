import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { delay,map, catchError } from 'rxjs/operators';
import {Http, Response,RequestOptions, Headers} from '@angular/http';
import { User } from "app/Models/user";

@Injectable()
export class LoginServiceService {

    constructor(private http:Http) { }

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

    //Login Method
    login(user:User):Observable<string>
    {
           console.log(user.userPassword);
        return this.http.post("http://localhost:8080/Banking_System/CustomerController/loginUser",user).pipe(map((response)=>{

            let json = null;
            try{

                json =  this.handleResponse(response);

                if(json==null){
                    throw new Error("User Login failed");
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


    /*insertCustomer(user:User):Observable<User>
    {

        return this.http.post("http://localhost:8080/DemoProject/StudentController/insertStudent",user).pipe(map((response)=>{

            let json = null;
            try{

                json =  this.handleResponse(response);

                if(json==null){
                    throw new Error("User Insertion failed");
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
*/
