/**
* Pack Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-19
*/
package com.xnara.api.model.response;

public class Pack {
	private String ingredient;
	private int quantity;
	private String unit;

	// Constructors
	public Pack() {

	}

	public Pack(String ingredient, int quantity, String unit) {
		super();
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.unit = unit;
	}

	// Getters and Setters
	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
