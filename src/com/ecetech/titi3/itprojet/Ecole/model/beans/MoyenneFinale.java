package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class MoyenneFinale {
	
	private int id;
	private String appreciationDirecteur;
	private double calculMoyenneFinale;
	private int numero;
	private String mention;
	
	public MoyenneFinale(int id, String appreciationDirecteur, double calculMoyenneFinale, int numero, String mention) {
		this.id = id;
		this.appreciationDirecteur = appreciationDirecteur;
		this.calculMoyenneFinale = calculMoyenneFinale;
		this.numero = numero;
		this.mention = mention;
	}
	
	public MoyenneFinale(int id, String appreciationDirecteur, double calculMoyenneFinale) {
		this.id = id;
		this.appreciationDirecteur = appreciationDirecteur;
		this.calculMoyenneFinale = calculMoyenneFinale;
		this.numero = 0;
		this.mention = "";
	}
	
	public MoyenneFinale(int id, double calculMoyenneFinale, int numero) {
		this.id = id;
		this.appreciationDirecteur = "";
		this.calculMoyenneFinale = calculMoyenneFinale;
		this.numero = numero;
		this.mention = "";
	}
	
	public MoyenneFinale() {
		this.id = 0;
		this.appreciationDirecteur = "";
		this.calculMoyenneFinale = 0.0;
		this.numero = 0;
		this.mention = "";
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
}
