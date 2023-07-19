/**
* CustomerRequest Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.model.request;

public class CustomerRequest {

	private String customer_id;

	// Constructor
	public CustomerRequest() {
		
	}
	
	public CustomerRequest(String customer_id) {
		super();
		this.customer_id = customer_id;
	}

	// Getter and setter
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
