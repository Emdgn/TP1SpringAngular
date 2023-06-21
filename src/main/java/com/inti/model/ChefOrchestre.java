package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class ChefOrchestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numChef;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationnalite;
	private double cachet;
	private String commentaires;
	
}
