package com.inti.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oeuvre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numOeuvre;
	private String nom;
	private double duree;
	

	@ManyToOne
	@JoinColumn(name="numChef")
	private ChefOrchestre chefOrchestre;

	
	@ManyToOne
	@JoinColumn(name = "idConcert")
	private Concert concert;


	@ManyToMany
	@JoinTable(name = "Soliste_oeuvre", joinColumns = @JoinColumn(name="idOeuvre"),
	inverseJoinColumns = @JoinColumn(name="idSoliste"))
	private List<Soliste> listeSoliste;


	
	public Oeuvre(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}
	
	
	

}
