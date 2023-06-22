package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Concert;
import com.inti.model.Lieu;

@Repository
public interface ILieuRepository extends JpaRepository<Lieu, Integer>{
	
	@Query("SELECT l.concerts FROM Lieu l WHERE l.id = :id")
	List<Concert> getConcertsByLieuId(@Param("id") int lieuId);

 
}
