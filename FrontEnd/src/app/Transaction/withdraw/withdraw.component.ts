import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from "app/Services/transaction-service.service";
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Transaction } from "app/Models/transaction";
import{Account} from "app/Models/account";

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {

constructor(private _transaction:TransactionServiceService) { 
        
    
        
    } 



withdrawForm = new FormGroup({
    
    
    accountNo :new  FormControl('',Validators.required),
    amount: new  FormControl('',Validators.required),
})

transaction:  Transaction;
message: string;
errormesssage:string;


Withdraw(){
    console.log("Withdraw Money!");
    console.log(this.withdrawForm.value);
      //console.log(this.customer);
      //Getting data from UI data model to Non ui data model
      this.transaction = this.withdrawForm.value;
      console.log(this.transaction);
      //Setting data from Non ui model to UI data model
     // this.formgroup.setValue(this.customer);
      
      
      
      this.transaction.transactionStatus="debited";

      this.transaction.accountNo=this.withdrawForm.get('accountNo').value;
      this.transaction.amount=this.withdrawForm.get('amount').value;
      this.transaction.transactionDestination=this.withdrawForm.get('accountNo').value;
     
      this._transaction.Withdraw(this.transaction).subscribe((data)=>{
     this.transaction = data;
     console.log(data);
      this.message = "Money Succesfully  Withdraw from account no:"/*+this.transaction.accountNo*/;
         
         setTimeout(() => {
             this.message=""
           }, 4000);
         
     },(error)=>{
         
         this.errormesssage = error;
     });
     
    
      
              console.log("Data Saved!");  
     console.log(this.withdrawForm.value);
    
    
    
}


ngOnInit() {
    
    this.withdrawForm.valueChanges.subscribe((data)=>{
    console.log(data);
})



}
 
}
  
  
