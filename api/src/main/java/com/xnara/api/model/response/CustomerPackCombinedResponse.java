/**
* CustomerPackCombinedResponse Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.model.response;

import java.util.List;

public class CustomerPackCombinedResponse {

	private String customer_id;
	private List<String> pack1;
	private List<String> pack2;
	private String id;

	// Constructors
	public CustomerPackCombinedResponse() {

	}

	public CustomerPackCombinedResponse(String customer_id, List<String> pack1, List<String> pack2, String id) {
		super();
		this.customer_id = customer_id;
		this.pack1 = pack1;
		this.pack2 = pack2;
		this.id = id;
	}

	// Getters and Setters
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public List<String> getPack1() {
		return pack1;
	}

	public void setPack1(List<String> pack1) {
		this.pack1 = pack1;
	}

	public List<String> getPack2() {
		return pack2;
	}

	public void setPack2(List<String> pack2) {
		this.pack2 = pack2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
