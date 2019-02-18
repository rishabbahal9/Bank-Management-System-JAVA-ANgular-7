import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from "app/Services/customer-service.service";
import { Customer } from "app/Models/customer";
import { AccountServiceService } from "app/Services/account-service.service";

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
    customerList:Customer[];
customer:Customer;

errormessage:string;



    constructor(private _customer:CustomerServiceService,private _account:AccountServiceService) { 
          
          
      }  


  ngOnInit() 
  {

      this._customer.getAllCustomers().subscribe((data)=>
      {
          this.customerList = data;
          console.log("customerList");
          console.log(this.customerList);
      },(error)=>
      {
          this.errormessage = error;
      });
    
  }
  
  //customerIdSaved:number;
  updateCall(customer)
  {
      this._customer.custGet(customer);
      console.log("Printing Customer ID");
      console.log(customer);
      this.customer=customer;
      
      
      
  }
  
  //This method will be called by Update Customer Form
/*  getAccountId(customerId)
  {
      console.log("inside view ts.........");
      console.log(customerId);

      this._account.getCustId(customerId);
      

  }
  
  */
  
  
  deleteCustomer(customerId:number)
  {
      console.log(customerId);
      this._customer.deleteCustomer(customerId).subscribe((data)=>{
          console.log(data);
      })
      
  }


}
