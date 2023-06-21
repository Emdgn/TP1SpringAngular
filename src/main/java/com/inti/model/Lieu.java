package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String numerue;
	private int nbrfaut;
	
	@OneToMany(mappedBy = "lieu")
	private List<Concert> concerts;
	
	public Lieu(String nom, String numerue, int nbrfaut) {
		super();
		this.nom = nom;
		this.numerue = numerue;
		this.nbrfaut = nbrfaut;
	}
}
