package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Classe {
	
	private String nom;

	public Classe(String nom) {
		this.nom = nom;
	}
	
	public Classe() {
		this.nom = "";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
