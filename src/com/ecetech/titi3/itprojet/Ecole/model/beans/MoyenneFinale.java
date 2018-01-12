package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class MoyenneFinale {
	
	private int id;
	private String appreciationDirecteur;
	private double calculMoyenneFinale;
	
	public MoyenneFinale(int id, String appreciationDirecteur, double calculMoyenneFinale) {
		this.id = id;
		this.appreciationDirecteur = appreciationDirecteur;
		this.calculMoyenneFinale = calculMoyenneFinale;
	}
	
	public MoyenneFinale() {
		this.id = 0;
		this.appreciationDirecteur = "";
		this.calculMoyenneFinale = 0.0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppreciationDirecteur() {
		return appreciationDirecteur;
	}
	public void setAppreciationDirecteur(String appreciationDirecteur) {
		this.appreciationDirecteur = appreciationDirecteur;
	}
	public double getCalculMoyenneFinale() {
		return calculMoyenneFinale;
	}
	public void setCalculMoyenneFinale(double calculMoyenneFinale) {
		this.calculMoyenneFinale = calculMoyenneFinale;
	}

}
