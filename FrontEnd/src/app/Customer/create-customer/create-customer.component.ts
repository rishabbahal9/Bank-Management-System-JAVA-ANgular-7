import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from "app/Services/customer-service.service";
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Customer } from "app/Models/customer";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor(private _customer:CustomerServiceService) { 
          
        
        
    }  
  
  
  insertCustomerForm = new FormGroup({
      
      
      customerName :new  FormControl('',[Validators.required, Validators.minLength(3)]),
      customerEmail: new  FormControl('',Validators.required),
      customerContact: new  FormControl('',[Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      customerAge: new  FormControl('',Validators.required),
      customerAddress1: new  FormControl('',Validators.required),
      customerAddress2: new  FormControl(),
      city: new  FormControl('',Validators.required),
      state: new  FormControl('',Validators.required)

      
    
})

  
  customer:  Customer;
    message: string;
errormesssage:string;

  
  
  
  
insertCustomer(){
      
    console.log("Inserting Customer!");
    console.log(this.insertCustomerForm.value);
      //console.log(this.customer);
      //Getting data from UI data model to Non ui data model
      this.customer = this.insertCustomerForm.value;
      console.log(this.customer);
      //Setting data from Non ui model to UI data model
     // this.formgroup.setValue(this.customer);
      
     this._customer.insertCustomer(this.customer).subscribe((data)=>{
         this.customer = data;
         this.message = "Student details are registered successfully with STUDENTID:"+this.customer.customerName;
         
         setTimeout(() => {
             this.message=""
           }, 4000);
         
     },(error)=>{
         this.errormesssage = error;
     });
     
    
      
              console.log("Data Saved!");  
     console.log(this.insertCustomerForm.value);
     console.log("Customer Object");  
     console.log(this.customer);
  }
  
  
  
  

  ngOnInit() {
      
      this.insertCustomerForm.valueChanges.subscribe((data)=>{
          console.log(data);
  })


}
}

