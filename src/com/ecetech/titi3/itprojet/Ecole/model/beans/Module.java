package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Module {
	
	private String type;
	
	
	public Module(String type) {
		this.type = type;
	}
	
	public Module(){
		this.type = "";
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
