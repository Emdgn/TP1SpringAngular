package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Concert {
	
	private int num;
	private String nom;
	private LocalDate date;
	
	
	
}
