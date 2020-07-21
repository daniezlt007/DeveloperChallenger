package com.developer.challenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.challenger.model.Enquete;
import com.developer.challenger.model.Option;
import com.developer.challenger.model.OptionsStats;
import com.developer.challenger.model.Votes;
import com.developer.challenger.repository.EnqueteOptionsRepository;
import com.developer.challenger.repository.OptionsRepository;
import com.developer.challenger.repository.VotesRepository;

@Service
public class EnqueteServiceImplements implements EnqueteService {
	
	@Autowired
	private EnqueteOptionsRepository enqueteOptionsRepository;
	
	@Autowired
	private OptionsRepository optionsRepository;
	
	@Autowired
	private VotesRepository votesRepository;

	@Override
	public List<Enquete> findAll() {	
		return this.enqueteOptionsRepository.findAll();
	}

	@Override
	public Enquete create(Enquete enquete) {
		this.enqueteOptionsRepository.save(enquete);
		return enquete;
	}

	@Override
	public void delete(Long id) {
		Optional<Enquete> enquete = this.enqueteOptionsRepository.findById(id);
		if(enquete != null) {
			this.enqueteOptionsRepository.delete(enquete.get());
		}
	}

	@Override
	public Enquete findById(Long id) {
		Optional<Enquete> enquete = this.enqueteOptionsRepository.findById(id);
		return enquete.get();
	}

	@Override
	public Enquete update(Long id, Enquete enquete) {
		Optional<Enquete> enqueteExists = this.enqueteOptionsRepository.findById(id);
		if(enqueteExists != null) {
			enquete.setPollId(enqueteExists.get().getPollId());
			this.enqueteOptionsRepository.save(enquete);
			return enquete;
		}
		return null;
	}

	@Override
	public List<?> votes(long id) {
		List<Option> votes = (List<Option>) this.optionsRepository.votesCount(id);
		if(votes == null) {
			System.out.println("Erro, está vazio");
		}
		return votes;
	}

	@Override
	public int saveVote(Votes votes) {
		Votes newVotes = this.votesRepository.save(votes);
		return newVotes.getEnquete();
	}
	
}
