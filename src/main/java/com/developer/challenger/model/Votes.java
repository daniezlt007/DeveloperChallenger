package com.developer.challenger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Votes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_vote")
	private long id;
	
	@Column(name = "poll_id")
	private int enquete;
	
	@Column(name = "option_id")
	private int option;
	
	public Votes() {
		super();
	}

	public Votes(long id, int enquete, int option) {
		super();
		this.id = id;
		this.enquete = enquete;
		this.option = option;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEnquete() {
		return enquete;
	}

	public void setEnquete(int enquete) {
		this.enquete = enquete;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}
	
}
