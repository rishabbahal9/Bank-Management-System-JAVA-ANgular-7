import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from "app/Services/customer-service.service";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {


    constructor(_customer:CustomerServiceService) { 
          
          
      }  

  ngOnInit() {
  }

}
