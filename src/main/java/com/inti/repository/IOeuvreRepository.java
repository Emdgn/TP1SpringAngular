package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Oeuvre;

@Repository
public interface IOeuvreRepository extends JpaRepository<Oeuvre, Integer> {
	
//	@Query(value = "select * from oeuvre where id_concert = :num", nativeQuery = true)
//	List<Oeuvre> getOeuvreFromConcert(@Param("num") int num);
	
	@Query(value = "select id_concert from oeuvre where id_concert = :num", nativeQuery = true)
	List<Integer> getOeuvreFromConcert(@Param("num") int num);

}
