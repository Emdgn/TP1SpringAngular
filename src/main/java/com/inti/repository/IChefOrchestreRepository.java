package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.ChefOrchestre;

import lombok.Value;

@Repository
public interface IChefOrchestreRepository extends JpaRepository<ChefOrchestre, Integer>{
	
	@Query(value="select * from chef_orchestre where num_chef = (select num_chef from oeuvre where id_concert = :num limit 1)", nativeQuery = true)
	ChefOrchestre getChefByConcert(@Param("num") int num);

}
