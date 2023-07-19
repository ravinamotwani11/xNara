/**
* CustomerPack Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.model.response;

import java.util.List;

public class CustomerPack {

	private String customer_id;
	private List<Pack> pack_data;
	private String id;
	
	// Constructors
	public CustomerPack() {
		
	}
	
	public CustomerPack(String customer_id, List<Pack> pack_data, String id) {
		super();
		this.customer_id = customer_id;
		this.pack_data = pack_data;
		this.id = id;
	}
	
	// Getters and Setters
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public List<Pack> getPack_data() {
		return pack_data;
	}
	public void setPack_data(List<Pack> pack_data) {
		this.pack_data = pack_data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
