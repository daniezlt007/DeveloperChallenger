package com.developer.challenger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developer.challenger.model.Option;

@Repository
public interface OptionsRepository extends JpaRepository<Option, Long> {
	
	@Query(value = "select count(option_id) as option_id, enquete_poll_id as enquete_poll_id from option where enquete_poll_id=? group by enquete_poll_id", nativeQuery = true)
	public List<?> votesCount(long id);
	
}
