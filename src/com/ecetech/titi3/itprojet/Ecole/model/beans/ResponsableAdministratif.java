package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class ResponsableAdministratif {
	
	private int numero;
	private String nom;
	private String prenom;
	
	public ResponsableAdministratif(int numero, String nom, String prenom) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public ResponsableAdministratif() {
		this.numero = 0;
		this.nom = "";
		this.prenom = "";
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
