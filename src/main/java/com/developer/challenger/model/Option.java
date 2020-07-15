package com.developer.challenger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "option")
public class Option implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id")
	private Long pollId;
	@Column(name = "option_description")
	private String pollDescription;
	@ManyToOne
	@JoinColumn(name="enquete_poll_id", referencedColumnName = "poll_id",nullable=false)
	@JsonIgnore
	private Enquete enquete;
	
	public Option() {
		super();
	}

	public Option(Long pollId, String pollDescription, Enquete enquete) {
		super();
		this.pollId = pollId;
		this.pollDescription = pollDescription;
		this.enquete = enquete;
	}

	public Long getPollId() {
		return pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}

	public String getPollDescription() {
		return pollDescription;
	}

	public void setPollDescription(String pollDescription) {
		this.pollDescription = pollDescription;
	}

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}
	
}
