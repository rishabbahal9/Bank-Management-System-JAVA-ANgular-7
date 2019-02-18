import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from "app/Services/customer-service.service";
import { FormGroup, Validators } from "@angular/forms";
import { FormControl } from "@angular/forms";
import { Customer } from "app/Models/customer";
import { ViewCustomerComponent } from "app/Customer/view-customer/view-customer.component";

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

      
    customer:Customer;

    
    
    constructor(private _customer:CustomerServiceService) { 
          
          
      }  
    

    
    ngOnInit() {
        
        
        
        
        
        
        /* 
         this._customer.getAllCustomers().subscribe((data)=>{
             this.customerList = data;
             console.log("customerList");
             console.log(this.customerList);
         },(error)=>{
             this.errormessage = error;
         });*/
        console.log("return from view page***********************************");
        console.log(this._customer.custReturn());

         this.customer=this._customer.custReturn();
         console.log("customerDetailsOfViewPage"+this.customer);
       /*  this.updateCustomerForm.patchValue
         ({ 
             "customerName":this.customer.customerName,
             "customerEmail":this.customer.customerEmail,
             "customerContact":this.customer.customerContact,
             "customerAge":this.customer.customerAge,
             "customerAddress1":this.customer.customerAddress1,
             "customerAddress2":this.customer.customerAddress2,
             "city":this.customer.city,
             "state":this.customer.state
             
         });*/
         
         
         this.updateCustomerForm.patchValue(this.customer);

   }
updateCustomerForm = new FormGroup({
        
    customerId :new  FormControl(''),
        customerName :new  FormControl(''),
        customerEmail: new  FormControl(''),
        customerContact: new  FormControl(''),
        customerAge: new  FormControl(''),
        customerAddress1: new  FormControl(''),
        customerAddress2: new  FormControl(''),
        city: new  FormControl(''),
        state: new  FormControl('')

        
      
  });

message:string;
errorMessage:string;
boolObj:boolean;
updateCustomer()
{
    console.log("updating Customer!");
    console.log(this.updateCustomerForm.value);
      //console.log(this.customer);
      //Getting data from UI data model to Non ui data model
      this.customer = this.updateCustomerForm.value;
      console.log(this.customer);
      //Setting data from Non ui model to UI data model
     // this.formgroup.setValue(this.customer);
      
     this._customer.updateCustomer(this.customer).subscribe((data)=>{
         this.boolObj = data;
         this.message = "Customer details are updated successfully with customerName:"+this.customer.customerName;
         
         setTimeout(() => {
             this.message=""
           }, 4000);
         
     },(error)=>{
         this.errorMessage = error;
     });
     
    
      
              console.log("Data Saved!");  
     console.log(this.updateCustomerForm.value);
}
    
   
    
    
  

}
