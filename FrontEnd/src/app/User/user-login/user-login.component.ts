import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { User } from "app/Models/user";
import { LoginServiceService } from "app/Services/login-service.service";
import { Router } from "@angular/router";


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private _looginService:LoginServiceService, private router:Router) { }
  loginFlag=true;



  loginForm = new FormGroup({


      userName :new  FormControl('',Validators.required),
      userPassword: new  FormControl('',Validators.required)

   })

  onLoginPress()
  {
      this.loginFlag=!this.loginFlag;
  }

 ngOnInit() {

      this.loginForm.valueChanges.subscribe((data)=>{
          //console.log(data);
      })
  }

 message:string;
 errormesssage:string;
 userType:string;
      flagLoginMismatch:boolean=false;
 login(){
     console.log("executed: Login()");
     console.log(this.loginForm.value);
     this._looginService.login(this.loginForm.value).subscribe((data)=>{
         this.userType=data;
         console.log(this.userType);
    if(this.userType=="Executive")
    {
      console.log("UserType if Executive");
      this.router.navigateByUrl('/executive');
    }
    else if(this.userType=="Cashier")
    {
        console.log("UserType if Cashier");
        this.router.navigateByUrl('/cashier');
     }
    else if(this.userType=="not found")
        {
            this.flagLoginMismatch=true;
        }
    else
        {
        console.log("Error ");
        }
        
          

    this.loginForm.reset({
        userName:'',
        password:''
             })


     })

 }}
