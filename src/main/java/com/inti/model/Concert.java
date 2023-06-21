package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.OneToMany;
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
>>>>>>> branch 'master' of https://github.com/landazar/TP1Spring.git
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String nom;
	private LocalDate date;
	
<<<<<<< HEAD
	
	@OneToMany(mappedBy = "concert")
	private List<Oeuvre> listeO;
	
=======
	@OneToOne
	@JoinColumn(name = "lieu_id")
	private Lieu lieu;
>>>>>>> branch 'master' of https://github.com/landazar/TP1Spring.git
	
	public Concert(String nom, LocalDate date) {
		super();
		this.nom = nom;
		this.date = date;
<<<<<<< HEAD

	}
	
=======
	}
>>>>>>> branch 'master' of https://github.com/landazar/TP1Spring.git
}
