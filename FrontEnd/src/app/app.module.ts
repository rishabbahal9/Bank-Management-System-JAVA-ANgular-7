import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CreateCustomerComponent } from './Customer/create-customer/create-customer.component';
import { UpdateCustomerComponent } from './Customer/update-customer/update-customer.component';
import { DeleteCustomerComponent } from './Customer/delete-customer/delete-customer.component';
import { ViewCustomerComponent } from './Customer/view-customer/view-customer.component';
import { CreateAccountComponent } from './Account/create-account/create-account.component';
import { DeleteAccountComponent } from './Account/delete-account/delete-account.component';
import { UpdateAccountComponent } from './Account/update-account/update-account.component';
import { ViewAccountComponent } from './Account/view-account/view-account.component';
import { UserLoginComponent } from './User/user-login/user-login.component';
import { ExecutiveDashboardComponent } from './User/executive-dashboard/executive-dashboard.component';
import { CashierDashboardComponent } from './User/cashier-dashboard/cashier-dashboard.component';
import { TransactionServiceService } from "app/Services/transaction-service.service";
import { LoginServiceService } from "app/Services/login-service.service";
import { CustomerServiceService } from "app/Services/customer-service.service";
import { AccountServiceService } from "app/Services/account-service.service";
import { WithdrawComponent } from './Transaction/withdraw/withdraw.component';
import { DepositComponent } from './Transaction/deposit/deposit.component';
import { TransferComponent } from './Transaction/transfer/transfer.component';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './PageLayout/header/header.component';
import { FooterComponent } from './PageLayout/footer/footer.component';
import { ExecnavComponent } from './PageLayout/executiveNav/execnav.component';
import { CashiernavComponent } from './PageLayout/cashierNav/cashiernav.component';



const routes: Routes = [
                        { path: 'login', component: UserLoginComponent  },
                        { path: 'executive', component: ExecutiveDashboardComponent  },
                        { path: 'cashier', component: CashierDashboardComponent  },
                        { path: 'customerRegister', component: CreateCustomerComponent  },
                        { path: 'customerUpdate', component: UpdateCustomerComponent  },
                        { path: 'customerDelete', component: DeleteCustomerComponent  },
                        { path: 'customerView', component: ViewCustomerComponent  },
                        { path: 'accountRegister/:customerId', component: CreateAccountComponent  },
                        { path: 'accountUpdate', component: UpdateAccountComponent  },
                        { path: 'accountDelete/:accountNo/:customerId/:balance', component: DeleteAccountComponent  },
                        { path: 'accountView', component: ViewAccountComponent  },
                        { path: 'withdraw', component: WithdrawComponent  },
                        { path: 'deposit', component: DepositComponent  },
                        { path: 'transfer', component: TransferComponent  }
                      ];

@NgModule({
  declarations: [
    AppComponent,
    CreateCustomerComponent,
    UpdateCustomerComponent,
    DeleteCustomerComponent,
    ViewCustomerComponent,
    CreateAccountComponent,
    DeleteAccountComponent,
    UpdateAccountComponent,
    ViewAccountComponent,
    UserLoginComponent,
    ExecutiveDashboardComponent,
    CashierDashboardComponent,
    WithdrawComponent,
    DepositComponent,
    TransferComponent,
    HeaderComponent,
    FooterComponent,
    ExecnavComponent,
    CashiernavComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes) 
  ],
  providers: [TransactionServiceService,
              LoginServiceService,
              CustomerServiceService,
              AccountServiceService
              ],
  bootstrap: [AppComponent]
})
export class AppModule { }
