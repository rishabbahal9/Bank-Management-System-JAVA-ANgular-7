import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from "app/Services/transaction-service.service";
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Transaction } from "app/Models/transaction";
import{Account} from "app/Models/account";

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

constructor(private _transaction:TransactionServiceService) { 
    
    } 



transferForm = new FormGroup({
    
    transactionSource :new  FormControl('',Validators.required),
    transactionDestination: new  FormControl('',Validators.required),
    amount: new  FormControl('',Validators.required),
})
transactionStatus:boolean;
transaction:  Transaction;
message: string;
errormesssage:string;


Transfer(){
    console.log("Withdraw Money!");
    console.log(this.transferForm.value);
      //console.log(this.customer);
      //Getting data from UI data model to Non ui data model
      this.transaction = this.transferForm.value;
      console.log(this.transaction);
      //Setting data from Non ui model to UI data model
     // this.formgroup.setValue(this.customer);
      
     this._transaction.Transfer(this.transaction).subscribe((data)=>{
     this.transactionStatus = data;
     console.log(data);
      this.message = "Money Succesfully  Withdraw from account no:"/*+this.transaction.accountNo*/;
         
         setTimeout(() => {
             this.message=""
           }, 4000);
         
     },(error)=>{
         
         this.errormesssage = error;
     });
     
    
      
              console.log("Data Saved!");  
     console.log(this.transferForm.value);
    
    
    
}




  ngOnInit() {
  }

}
