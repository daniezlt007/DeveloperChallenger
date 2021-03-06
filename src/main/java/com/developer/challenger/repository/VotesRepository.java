package com.developer.challenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.challenger.model.Votes;

@Repository
public interface VotesRepository extends JpaRepository<Votes, Long> {

}
