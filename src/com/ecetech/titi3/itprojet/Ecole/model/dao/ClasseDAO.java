package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Classe;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class ClasseDAO {

	/**
	 * Renvoie une liste des classes.
	 * @return : 1 liste des classes 
	 */	
	public static ArrayList<Classe> visionnageDesClasses(){
		ArrayList<Classe> listClasse = new ArrayList<Classe>();
		ConnexionDB con = new ConnexionDB();
		ResultSet res = con.envoiRequete("SELECT Nom FROM classe");
		try {
			while(res.next())
			{
				Classe classeTemp = new Classe();
				classeTemp.setNom(res.getString(1));
				listClasse.add(classeTemp);
			}
		}catch(Exception e) {}
		return listClasse;
	}
	
}
