package com.developer.challenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.challenger.model.Enquete;

@Repository
public interface EnqueteOptionsRepository extends JpaRepository<Enquete, Long> {

}
