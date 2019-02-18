package com.bean;

import java.util.ArrayList;

public class Customer {
	
			private int customerId;
			private int ssnId;
			private String customerName;
			private int customerAge;
			private long customerContact;
			private String customerEmail;
			private String customerAddress1;
			private String customerAddress2;
			private String city;
			private String state;
			private Account account;
			public Account getAccount() {
				return account;
			}
			public void setAccount(Account account) {
				this.account = account;
			}
			ArrayList<Account> accountList=new ArrayList<Account>();
			public int getCustomerId() {
				return customerId;
			}
			public void setCustomerId(int customerId) {
				this.customerId = customerId;
			}
			public int getSsnId() {
				return ssnId;
			}
			public void setSsnId(int ssnId) {
				this.ssnId = ssnId;
			}
			public String getCustomerName() {
				return customerName;
			}
			public void setCustomerName(String customerName) {
				this.customerName = customerName;
			}
			public int getCustomerAge() {
				return customerAge;
			}
			public void setCustomerAge(int customerAge) {
				this.customerAge = customerAge;
			}
			public long getCustomerContact() {
				return customerContact;
			}
			public void setCustomerContact(long customerContact) {
				this.customerContact = customerContact;
			}
			public String getCustomerEmail() {
				return customerEmail;
			}
			public void setCustomerEmail(String customerEmail) {
				this.customerEmail = customerEmail;
			}
			public String getCustomerAddress1() {
				return customerAddress1;
			}
			public void setCustomerAddress1(String customerAddress1) {
				this.customerAddress1 = customerAddress1;
			}
			public String getCustomerAddress2() {
				return customerAddress2;
			}
			public void setCustomerAddress2(String customerAddress2) {
				this.customerAddress2 = customerAddress2;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public ArrayList<Account> getAccountList() {
				return accountList;
			}
			public void setAccountList(ArrayList<Account> accountList) {
				this.accountList = accountList;
			}
			
			
			public Customer(String customerName, int customerAge, long customerContact, String customerEmail,
					String customerAddress1, String customerAddress2, String city, String state) {
				super();
				this.customerName = customerName;
				this.customerAge = customerAge;
				this.customerContact = customerContact;
				this.customerEmail = customerEmail;
				this.customerAddress1 = customerAddress1;
				this.customerAddress2 = customerAddress2;
				this.city = city;
				this.state = state;
			}
			public Customer(String customerName, int customerAge, long customerContact, String customerEmail,
					String customerAddress1, String customerAddress2, String city, String state,
					ArrayList<Account> accountList) {
				super();
				this.customerName = customerName;
				this.customerAge = customerAge;
				this.customerContact = customerContact;
				this.customerEmail = customerEmail;
				this.customerAddress1 = customerAddress1;
				this.customerAddress2 = customerAddress2;
				this.city = city;
				this.state = state;
				this.accountList = accountList;
			}
			
			
			
			
			public Customer(int customerId, int ssnId, String customerName, int customerAge, long customerContact,
					String customerEmail, String customerAddress1, String customerAddress2, String city, String state) {
				super();
				this.customerId = customerId;
				this.ssnId = ssnId;
				this.customerName = customerName;
				this.customerAge = customerAge;
				this.customerContact = customerContact;
				this.customerEmail = customerEmail;
				this.customerAddress1 = customerAddress1;
				this.customerAddress2 = customerAddress2;
				this.city = city;
				this.state = state;
			}
			public Customer(int customerId, int ssnId, String customerName, int customerAge, long customerContact,
					String customerEmail, String customerAddress1, String customerAddress2, String city, String state,
					ArrayList<Account> accountList) {
				super();
				this.customerId = customerId;
				this.ssnId = ssnId;
				this.customerName = customerName;
				this.customerAge = customerAge;
				this.customerContact = customerContact;
				this.customerEmail = customerEmail;
				this.customerAddress1 = customerAddress1;
				this.customerAddress2 = customerAddress2;
				this.city = city;
				this.state = state;
				this.accountList = accountList;
			}
			@Override
			public String toString() {
				return "Customer [customerId=" + customerId + ", ssnId=" + ssnId + ", customerName=" + customerName
						+ ", customerAge=" + customerAge + ", customerContact=" + customerContact + ", customerEmail="
						+ customerEmail + ", customerAddress1=" + customerAddress1 + ", customerAddress2="
						+ customerAddress2 + ", city=" + city + ", state=" + state + ", accountList=" + accountList
						+ "]";
			}
			
			
			
			
			
}