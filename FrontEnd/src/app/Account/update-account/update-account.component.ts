import { Component, OnInit } from '@angular/core';
import { AccountServiceService } from "app/Services/account-service.service";

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {

    constructor(_account:AccountServiceService) { 
        
        
    }

  ngOnInit() {
  }

}
