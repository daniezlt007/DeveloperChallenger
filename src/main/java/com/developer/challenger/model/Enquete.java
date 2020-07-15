package com.developer.challenger.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "enquete")
public class Enquete implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="poll_id")
	private Long pollId;
	@NotEmpty(message = "Não pode ser vazio")
	@Column(name="poll_description")
	private String pollDescription;
	@OneToMany(mappedBy = "enquete", fetch = FetchType.LAZY)
	private List<Option> options;
	
	public Enquete() {
		
	}
	
	public Enquete(Long pollId, String pollDescription, List<Option> options) {
		super();
		this.pollId = pollId;
		this.pollDescription = pollDescription;
		this.options = options;
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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
