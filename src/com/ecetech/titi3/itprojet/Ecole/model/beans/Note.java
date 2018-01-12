package com.ecetech.titi3.itprojet.Ecole.model.beans;

public class Note {

	private int id;
	private float note;
	private int coef;
	private String module;
	private int numeroEleve;
	
	public Note(int id, float note, int coef, String module, int numeroEleve) {
		this.id = id;
		this.note = note;
		this.coef = coef;
		this.module = module;
		this.numeroEleve = numeroEleve;
	}
	
	public Note(int id, float note, int coef) {
		this.id = id;
		this.note = note;
		this.coef = coef;
		this.module = "";
		this.numeroEleve = 0;
	}
	
	public Note() {
		this.id = 0;
		this.note = 0;
		this.coef = 0;
		this.module = "";
		this.numeroEleve = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public int getNumeroEleve() {
		return numeroEleve;
	}
	public void setNumeroEleve(int numeroEleve) {
		this.numeroEleve = numeroEleve;
	}
	
	
}
