package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Concert;

@Repository
public interface IConcertRepository extends JpaRepository<Concert, Integer> {
	
	List<Concert> findByNom(String n);
	
	@Query(value ="SELECT COUNT(*) FROM concert",nativeQuery = true )
	int getConcertCount();
}
