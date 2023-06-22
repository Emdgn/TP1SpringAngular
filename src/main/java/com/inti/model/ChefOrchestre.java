package com.inti.model;
import java.time.LocalDate;
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
import lombok.ToString.Exclude;


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
	private String nationalite;
	private double cachet;
	private String commentaires;
	
	@OneToMany(mappedBy = "chefOrchestre")
	@Exclude
	private List<Oeuvre>oeuvre;
	
	
	public ChefOrchestre(String nom, String prenom, LocalDate dateNaissance, String nationnalite, double cachet,
			String commentaires) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationnalite;
		this.cachet = cachet;
		this.commentaires = commentaires;
	}
	
	
	
}
