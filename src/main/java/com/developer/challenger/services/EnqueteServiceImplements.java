package com.developer.challenger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.challenger.model.Enquete;
import com.developer.challenger.repository.EnqueteOptionsRepository;

@Service
public class EnqueteServiceImplements implements EnqueteService {
	
	@Autowired
	private EnqueteOptionsRepository enqueteOptionsRepository;

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

	
}
