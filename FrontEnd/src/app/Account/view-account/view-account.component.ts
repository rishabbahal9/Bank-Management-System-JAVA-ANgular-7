import { Component, OnInit } from '@angular/core';
import { AccountServiceService } from "app/Services/account-service.service";
import { Account } from "app/Models/account";
import { ActivatedRoute, Params } from '@angular/router';


@Component({
  selector: 'app-view-account',
  templateUrl: './view-account.component.html',
  styleUrls: ['./view-account.component.css']
})
export class ViewAccountComponent implements OnInit {

    constructor(private _account:AccountServiceService,private route: ActivatedRoute) { 
        
        
    }
    accountList:Account[];
    customerId:number= +this.route.snapshot.paramMap.get('customerId'); 


errormessage:string;

  ngOnInit() {
      
            this._account.getAllAccounts().subscribe((data)=>
      {
          this.accountList = data;
          console.log("accountList");
          console.log(this.accountList);
      },(error)=>
      {
          this.errormessage = error;
      });
    
      
  }
  deleteAccount(accountNo: number)
  {
      console.log("delete");
       console.log(accountNo);
      this._account.deleteAccount(accountNo).subscribe((data)=>{
          console.log(data);
          
      })
  }  

}
