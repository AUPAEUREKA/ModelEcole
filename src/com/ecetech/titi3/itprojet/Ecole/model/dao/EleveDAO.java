package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Eleve;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class EleveDAO {
	
	/**
	 * Renvoie une liste des eleves.
	 * @return : 1 liste des eleves 
	 */	
	public static ArrayList<Eleve> visionnageDesEleves(){
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		ConnexionDB con = new ConnexionDB();
		ResultSet res = con.envoiRequete("SELECT Numero, Nom, Prenom, Nb_absences FROM eleve");
		try {
			while(res.next())
			{
				Eleve eleveTemp = new Eleve();
				eleveTemp.setNumeroCarte(res.getInt(1));
				eleveTemp.setNom(res.getString(2));
				eleveTemp.setPrenom(res.getString(3));
				eleveTemp.setNombreAbsence(res.getInt(4));
				listEleve.add(eleveTemp);
			}
		}catch(Exception e) {}
		return listEleve;
	}

}
