package com.developer.challenger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.developer.challenger.model.Enquete;
import com.developer.challenger.model.OptionsStats;

@Repository
public interface EnqueteOptionsRepository extends JpaRepository<Enquete, Long> {
	
	//@Query(value = "select count(o.option_id) as option_id, o.enquete_poll_id from Option o where o.enquete_poll_id=3 group by o.enquete_poll_id", nativeQuery = true)
	
	
}
