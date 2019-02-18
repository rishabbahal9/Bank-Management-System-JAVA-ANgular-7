import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from "app/Services/customer-service.service";
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Account } from "app/Models/account";
import { Customer } from "app/Models/customer";

import { AccountServiceService } from "app/Services/account-service.service";
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  constructor(private _account:AccountServiceService, private route: ActivatedRoute) { 
      
      
  }
  customerId:number= +this.route.snapshot.paramMap.get('customerId'); 
 
  
ngOnInit() {
      
      this.createAccountForm.valueChanges.subscribe((data)=>{
//          console.log(data);
         // this.customerId=this._account.custIdReturn();
          
        
          
  })



}


  createAccountForm = new FormGroup({
      
      
      accountNo :new  FormControl('200',Validators.required),
      accountType: new  FormControl('',Validators.required),
      balance: new  FormControl('',Validators.required),
      accountStatus: new  FormControl('',Validators.required),
      customerId:new  FormControl(this.customerId)


    
})
  account:  Account = new Account();
    message: string;
errormesssage:string;

  
  
  
  
createAccount(){
    
    console.log(this.createAccountForm.value);
    this.account.customerId=this.customerId;
    console.log(this.customerId);
    
    this.account.accountType=this.createAccountForm.get('accountType').value;
    this.account.balance=this.createAccountForm.get('balance').value;
    this.account.accountStatus=this.createAccountForm.get('accountStatus').value;
    this.account.accountNo=this.createAccountForm.get('accountNo').value;




      
    console.log("Inserting Customer!");
    console.log(this.createAccountForm.value);
      //console.log(this.customer);
      //Getting data from UI data model to Non ui data model
      this.account = this.createAccountForm.value;
      console.log(this.account);
      //Setting data from Non ui model to UI data model
     // this.formgroup.setValue(this.customer);
      console.log("ggggggggggggggggggggggggggggggggggggggggggggg");
      console.log(this.account);


     this._account.createAccount(this.account).subscribe((data)=>{
         this.account = data;
         this.message = "Student details are registered successfully with STUDENTID:"+this.account.accountNo;
         
         setTimeout(() => {
             this.message=""
           }, 4000);
         
     },(error)=>{
         this.errormesssage = error;
     });
     
    
      
              console.log("Data Saved!");  
     console.log(this.createAccountForm.value);
  }
  
  
  

  
 }
