import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from "app/Services/transaction-service.service";
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Transaction } from "app/Models/transaction";
import{Account} from "app/Models/account";

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

    constructor(private _transaction:TransactionServiceService) { 
        
        
    } 
    
    
    depositForm = new FormGroup({
        
        
        accountNo :new  FormControl('',Validators.required),
        amount: new  FormControl('',Validators.required),
   })
    
    successFlag:boolean=true;
    failFlag:boolean=null;
    transactionStatus:boolean;
    transaction:Transaction;
    message: string;
    errormesssage:string;

    
    Deposit()
    {
        console.log("Deposit Money!");
        console.log(this.depositForm.value);
          //console.log(this.customer);
          //Getting data from UI data model to Non ui data model
          this.transaction = this.depositForm.value;
          console.log("this.transaction"+this.transaction);
          //Setting data from Non ui model to UI data model
         // this.formgroup.setValue(this.customer);
         
          
         this._transaction.Deposit(this.transaction).subscribe((data)=>{
         this.transactionStatus = data;
          this.message = "Money Succesfully  deposited  in account no:"/*+this.transaction.accountNo*/;
            console.log("Data");
            console.log(data);
             setTimeout(() => {
                 this.message=""
               }, 4000);
             
         },(error)=>{
             
             this.errormesssage = error;
         });
         
         //if()
         console.log("Transaction Status:");
         console.log(this.transactionStatus);
          
                  console.log("Data Saved!");  
         console.log(this.depositForm.value);
         console.log(this.transactionStatus);
        
        
        this.depositForm.reset({
            accountNo:'',
            amount:''
                 })
        
    }
    
    
    ngOnInit() {
        
        this.depositForm.valueChanges.subscribe((data)=>{
        console.log(data);
    })


  
}
}
