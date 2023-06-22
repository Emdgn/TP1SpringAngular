package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Soliste;

@Repository
public interface ISolisteRepository extends JpaRepository<Soliste, Integer> {
	
	//A modifier --> limit 1 prend pas tout
	@Query(value = "select id_soliste from soliste_oeuvre where id_oeuvre = "
			+ "(select num_oeuvre from oeuvre where id_concert = :num limit 1);", nativeQuery = true)
	List<Integer> getSolistesByConcert(@Param("num") int num);

}
