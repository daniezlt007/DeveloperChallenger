package com.developer.challenger.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.developer.challenger.model.Enquete;
import com.developer.challenger.model.Option;
import com.developer.challenger.model.OptionsStats;
import com.developer.challenger.model.Votes;
import com.developer.challenger.services.EnqueteService;

@RestController
@RequestMapping("/poll")
public class EnqueteResource {
	
	@Autowired
	private EnqueteService enqueteService;
	
	public EnqueteResource(EnqueteService enqueteService) {
		super();
		this.enqueteService = enqueteService;
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll(){
		List<Enquete> enquetes = this.enqueteService.findAll();
		return new ResponseEntity<List>(enquetes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}/stats")
	@ResponseBody
	public ResponseEntity<?> votes(Long id){
		List<Option> votes = (List<Option>) this.enqueteService.votes(id);
		if(votes != null) {
			System.out.println("Vazio");
		}
		return new ResponseEntity<List>(votes, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<?> find(@PathVariable(value = "id") Long id) {
		Enquete enqueteSearch = this.enqueteService.findById(id);
		return new ResponseEntity<Enquete>(enqueteSearch, HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Enquete enquete) {
			Enquete enqueteCreated = this.enqueteService.create(enquete);
			return new ResponseEntity<Enquete>(enqueteCreated, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id, HttpServletResponse response) {
		this.enqueteService.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Enquete enquete) {
		Enquete enqueteUpdate = this.enqueteService.update(id, enquete);
		return new ResponseEntity<Enquete>(enqueteUpdate, HttpStatus.OK);
	}
	
	@PostMapping(value="/{id}/vote")
	@ResponseBody
	public int saveVotes(@Valid @RequestBody Votes votes){
		int enquete = this.enqueteService.saveVote(votes);
		return enquete;
	}
	
}
