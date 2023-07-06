package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@NoArgsConstructor @AllArgsConstructor
@Data

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Soliste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSoliste;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Soliste_oeuvre", joinColumns = @JoinColumn(name="idSoliste"),
	inverseJoinColumns = @JoinColumn(name="idOeuvre"))
	@Exclude
	private List<Oeuvre> listeOeuvre;
	
	public Soliste(String nom, String prenom, LocalDate dateNaissance, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
	}
	
	
	

	
}
