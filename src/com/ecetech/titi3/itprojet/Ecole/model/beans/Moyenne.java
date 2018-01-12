package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Moyenne {
	
	private int id;
	private String appreciation;
	private double calculMoyenne;
	
	public Moyenne(int id, String appreciation, double calculMoyenne) {
		this.id = id;
		this.appreciation = appreciation;
		this.calculMoyenne = calculMoyenne;
	}
	
	public Moyenne() {
		this.id = 0;
		this.appreciation = "";
		this.calculMoyenne = 0.0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppreciation() {
		return appreciation;
	}
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	public double getCalculMoyenne() {
		return calculMoyenne;
	}
	public void setCalculMoyenne(double calculMoyenne) {
		this.calculMoyenne = calculMoyenne;
	}

}
