package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Eleve;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class EleveDAO {
	
	/**
	 * Renvoie une liste des eleves.
	 * @return : 1 liste des eleves 
	 * @throws SQLException 
	 */	
	public static ArrayList<Eleve> visionnageDesEleves() throws SQLException{
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		String res = "SELECT Numero, Nom, Prenom, Nb_absences FROM eleve";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next())
		{
			Eleve noteTemp = new Eleve();
			noteTemp.setNumeroCarte(ConnexionDB.getRes().getInt(1));
			noteTemp.setNom(ConnexionDB.getRes().getString(2));
			noteTemp.setPrenom(ConnexionDB.getRes().getString(3));
			noteTemp.setNombreAbsence(ConnexionDB.getRes().getInt(4));
			listEleve.add(noteTemp);
		}
		ConnexionDB.DBClose();
		return listEleve;
	}
	
	public static int ajouterEleve(int numero, String nom, String prenom, String nomClasse, String loginEleve){
		int result = -1;
		ConnexionDB.DBConnexion();
		String caractRandom = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String randomPassword = "";
		for(int x=0; x < 10 ; x++) {
			int i = (int)Math.floor(Math.random() * 62);
			randomPassword += caractRandom.charAt(i);
		}
		String req = "INSERT INTO authentification (LoginEleve, PasswordEleve) VALUES ('"+ loginEleve +"', '"+ randomPassword +"')";
		try {
			
		}
		String res = "INSERT INTO eleve (Numero, Nom, Prenom, nomClasse, Numero) VALUES ("+ numero +" ,'"+ nom +"' , '" + prenom + "', '"+ nomClasse +"' , '" + loginEleve + "')";
		try {
			result = ConnexionDB.getStm().executeUpdate(res);
			System.out.println("Requete executée");
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		ConnexionDB.DBClose();
		return result;
	}

}
