import { Component, OnInit } from '@angular/core';
import { AccountServiceService } from "app/Services/account-service.service";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { ActivatedRoute, Params } from '@angular/router';
import { Account } from "app/Models/account";
import { Transaction } from "app/Models/transaction";
import { Router } from "@angular/router";

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {
    ngOnInit(): void {
        //throw new Error("Method not implemented.");
     /*   this._accountService.getviewAccountByAccountNo(this.accountNo).subscribe((data)=>{
            this.account=data;
            this.deleteAccountform.patchValue({
              accountNo: this.account.accountNo,
              accountType: this.account.accountType,
              balance: this.account.balance,
              accountStatus: this.account.accountStatus
             
            })
        })*/
        console.log(this.accountNo);
    }

    constructor(private route: ActivatedRoute, private _accountService: AccountServiceService,private router:Router) { 
        
        
    }
    //accountType:string;
    balance:number=+this.route.snapshot.paramMap.get('balance');
    //accountStatus:string;

    accountNo:number= +this.route.snapshot.paramMap.get('accountNo');
    customerId:number=+this.route.snapshot.paramMap.get('customerId');
    
    
    account:Account;
    message: string;
    
    deleteAccountform = new FormGroup({
        customerId:new FormControl(this.customerId),
        accountNo: new FormControl(this.accountNo),
        
        balance: new FormControl(this.balance)

    })
    boolResult:boolean;
    deleteAccount(accountNo: number)
    {
        console.log("accountNo");

        console.log(accountNo);
        this._accountService.deleteAccount(accountNo).subscribe((data)=>{
            console.log(data);
            
            this.boolResult=data;
            console.log(this.boolResult);
            this.deleteAccountform.reset({
                customerId:'',
                accountNo:'',
                balance:''
                     })

        })
       // this.router.navigateByUrl('/accountView');
    }  

    //this.accountNo:number =+this.route.snapshot.paramMap.get('accountNo');
    
 /* ngOnInit() {
      
      
      this._accountService.getviewAccountByAccountNo(this.accountNo).subscribe((data)=>{
          this.account=data;
          this.deleteAccountform.patchValue({
            accountNo: this.account.accountNo,
            accountType: this.account.accountType,
            balance: this.account.balance,
            accountStatus: this.account.accountStatus
          })
      })
  }
  */
  

 /* 
  deleteAccount(accountNo: number)
  {
      console.log(accountNo);
      this._accountService.deleteAccount(accountNo).subscribe((data)=>{
          console.log(data);
      })
  }*/
}

