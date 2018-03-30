package com.ecetech.titi3.itprojet.Ecole.model.dao;

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
		ConnexionDB.DBConnexion();
		String res = "SELECT Numero, Nom, Prenom, Nb_absences FROM eleve";
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
			result = ConnexionDB.getStm().executeUpdate(req);
			System.out.println("Requete executée");
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		ConnexionDB.DBClose();
		ConnexionDB.DBConnexion();
		String res = "INSERT INTO eleve (Numero, Nom, Prenom, Nb_absences ,nom_classe, LoginEleve) VALUES ("+ numero +" ,'"+ nom +"' , '" + prenom + "', 0,'"+ nomClasse +"' , '" + loginEleve + "')";
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
	
	public static int supprimerEleve(int numero) throws SQLException {
		int result = -1;
		String login = "";
		ConnexionDB.DBConnexion();
		String res = "DELETE FROM Note WHERE Numero = "+ numero;
		try {
			result = ConnexionDB.getStm().executeUpdate(res);
			System.out.println("Requete executée");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
			
		}
		System.out.println(res);
		String res1 = "DELETE FROM Moyenne WHERE Numero = " + numero;
		try {
			result = ConnexionDB.getStm().executeUpdate(res1);
			System.out.println("Requete executée");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
			
		}
		System.out.println(res1);
		String res2 = "DELETE FROM Moyenne_finale WHERE Numero = " + numero;
		try {
			result = ConnexionDB.getStm().executeUpdate(res2);
			System.out.println("Requete executée");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
			
		}
		System.out.println(res2);
		String rechercheLogin = "SELECT LoginEleve FROM Eleve WHERE Numero =" + numero;
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(rechercheLogin));
		while(ConnexionDB.getRes().next()) {
			login = ConnexionDB.getRes().getString(1);
			//System.out.println(login);
		}
		System.out.println(login);
		String req = "DELETE FROM Eleve WHERE Numero = "+ numero;
		try {
			result = ConnexionDB.getStm().executeUpdate(req);
			System.out.println("Requete executée");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
			
		}
		System.out.println(req);
		String supprLogin = "DELETE FROM authentification WHERE loginEleve = '" + login +"'";
		try {
			result = ConnexionDB.getStm().executeUpdate(supprLogin);
			System.out.println("Requete executée");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
			
		}
		System.out.println(supprLogin);
		return result;
	}
	
	public static int modifierEleve(int numero, String nom, String prenom, int nbAbsences){
		int result = -1;
		ConnexionDB.DBConnexion();
		String res = "UPDATE eleve SET nom = '" + nom + "', prenom = '"+ prenom + "', nb_absences = "+ nbAbsences +" WHERE numero = "+ numero;
		//UPDATE `note` SET `Note`= 17 ,`Coef`= 2 WHERE `Id`= 9 AND `Type`= 'Mathématiques' AND `Numero` = 2
		try {
			result = ConnexionDB.getStm().executeUpdate(res);
			System.out.println("Requete executée");	
		} catch (SQLException ex){
			result = - ex.getErrorCode();
		}
		System.out.println(res);
		ConnexionDB.DBClose();
		return result;
	}
	

}
