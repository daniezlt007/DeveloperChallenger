package com.developer.challenger.model;

import java.io.Serializable;

public class OptionsStats implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int qty;
	private int optionId;
	private int enqueteOptionId;
	
	public OptionsStats() {
		
	}
	
	public OptionsStats(int qty, int optionId, int enqueteOptionId) {
		super();
		this.qty = qty;
		this.optionId = optionId;
		this.enqueteOptionId = enqueteOptionId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getEnqueteOptionId() {
		return enqueteOptionId;
	}

	public void setEnqueteOptionId(int enqueteOptionId) {
		this.enqueteOptionId = enqueteOptionId;
	}
	
}
