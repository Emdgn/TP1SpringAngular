package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Lieu;

@Repository
public interface ILieuRepository extends JpaRepository<Lieu, Integer>{
	
	@Query(value = "select * from lieu where id = (select lieu_id from concert where num = :num)", nativeQuery = true)
	Lieu getLieuConcert(@Param("num") int num);
 
}
