package com.developer.challenger.services;

import java.util.List;

import com.developer.challenger.model.Enquete;

public interface EnqueteService {
	
	public List<Enquete> findAll();
	public Enquete create(Enquete enquete);
	public void delete(Long id);
	public Enquete findById(Long id);
	public Enquete update(Long id, Enquete enquete);
	
}
