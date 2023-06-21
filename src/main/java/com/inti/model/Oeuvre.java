package com.inti.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private int duree;
	
	
	@ManyToOne
	@JoinColumn(name = "idConcert")
	private Concert concert;
	
	public Oeuvre(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}
	
	
	

}
