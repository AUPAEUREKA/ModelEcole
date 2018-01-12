package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Eleve {
	
	private String nom;
	private String prenom;
	private int numeroCarte;
	private int nombreAbsence;
	private String nomClasse;
	private String loginEleve;
	
	public Eleve(String nom, String prenom, int numeroCarte, int nombreAbsence, String nomClasse, String loginEleve) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCarte = numeroCarte;
		this.nombreAbsence = nombreAbsence;
		this.nomClasse = nomClasse;
		this.loginEleve = loginEleve;
	}
	
	public Eleve(String nom, String prenom, int numeroCarte, int nombreAbsence) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCarte = numeroCarte;
		this.nombreAbsence = nombreAbsence;
		this.nomClasse = "";
		this.loginEleve = "";
	}
	
	public Eleve(String nom, String prenom, int numeroCarte){
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCarte = numeroCarte;
		this.nombreAbsence = 0;
		this.nomClasse = "";
		this.loginEleve = "";
	}
	
	public Eleve(){
		this.nom = "";
		this.prenom = "";
		this.numeroCarte = 0;
		this.nombreAbsence = 0;
		this.nomClasse = "";
		this.loginEleve = "";
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public String getLoginEleve() {
		return loginEleve;
	}

	public void setLoginEleve(String loginEleve) {
		this.loginEleve = loginEleve;
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
	public int getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public int getNombreAbsence() {
		return nombreAbsence;
	}
	public void setNombreAbsence(int nombreAbsence) {
		this.nombreAbsence = nombreAbsence;
	}

}
