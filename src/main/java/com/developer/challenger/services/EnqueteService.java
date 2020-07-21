package com.developer.challenger.services;

import java.util.List;

import com.developer.challenger.model.Enquete;
import com.developer.challenger.model.Option;
import com.developer.challenger.model.OptionsStats;
import com.developer.challenger.model.Votes;

public interface EnqueteService {
	
	public List<Enquete> findAll();
	public Enquete create(Enquete enquete);
	public void delete(Long id);
	public Enquete findById(Long id);
	public Enquete update(Long id, Enquete enquete);
	public List<?> votes(long id); 
	public int saveVote(Votes votes);
	
}
