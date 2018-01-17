package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.MoyenneFinale;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class MoyenneFinaleDAO {
	
	public static ArrayList<MoyenneFinale> visionnageDesMoyennesFinales() throws SQLException{
		ArrayList<MoyenneFinale> listMoyenneFinale = new ArrayList<MoyenneFinale>();
		String res = "SELECT Id, Cal_MoyFin, Numero FROM moyenne_finale";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next())
		{
			MoyenneFinale noteTemp = new MoyenneFinale();
			noteTemp.setId(ConnexionDB.getRes().getInt(1));
			noteTemp.setCalculMoyenneFinale(ConnexionDB.getRes().getDouble(2));
			noteTemp.setNumero(ConnexionDB.getRes().getInt(3));
			listMoyenneFinale.add(noteTemp);
		}
		ConnexionDB.DBClose();
		return listMoyenneFinale;
	}
	
	public static int modificationDUneMoyenneFinale(int numero) throws SQLException{
		int result = -1;
		double moyenneFinaleTemp = 0;
		int coefMoyTemp = 0;
		String mention = "";
		String res = "SELECT Note, Coef FROM note WHERE Numero = " + numero;
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next()){
			double noteTemp = ConnexionDB.getRes().getDouble(1);
			System.out.println(noteTemp);
			int coeftemp = ConnexionDB.getRes().getInt(2);
			System.out.println(coeftemp);
			coefMoyTemp = coefMoyTemp + coeftemp;
			moyenneFinaleTemp = moyenneFinaleTemp + (noteTemp * coeftemp);
		}
		ConnexionDB.DBClose();
		moyenneFinaleTemp = moyenneFinaleTemp / coefMoyTemp;
		System.out.println(moyenneFinaleTemp);
		double moyenneFinale = Math.round(moyenneFinaleTemp*100);
		moyenneFinale = moyenneFinale/100;
		System.out.println(moyenneFinale);
		if(moyenneFinale >= 16){
			mention = "Très Bien";
		}else if (moyenneFinale >= 14 && moyenneFinale < 15.99){
			mention = "Bien";
		}else if (moyenneFinale >= 12 && moyenneFinale < 13.99){
			mention = "Assez Bien";
		}else if (moyenneFinale >= 10 && moyenneFinale < 11.99){
			mention = "Passable";
		}else{
			mention = "Redoublement";
		}
		String req = "UPDATE moyenne_finale SET Cal_MoyFin = " + moyenneFinale + ", Type = '"+ mention +"' WHERE Numero = " + numero;
		ConnexionDB.DBConnexion();
		try {
			result = ConnexionDB.getStm().executeUpdate(req);
			System.out.println("Requete executée");	
		} catch (SQLException ex){
			result = - ex.getErrorCode();
		}
		System.out.println(req);
		ConnexionDB.DBClose();
		return result;
	}
	
	public static int ajouterDUneMoyennFinale(int id, int numero) throws SQLException{
		int result = -1;
		double moyenneFinaleTemp = 0;
		int coefMoyTemp = 0;
		String mention = "";
		String res = "SELECT Note, Coef FROM note WHERE Numero = " + numero;
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next()){
			double noteTemp = ConnexionDB.getRes().getDouble(1);
			System.out.println(noteTemp);
			int coeftemp = ConnexionDB.getRes().getInt(2);
			System.out.println(coeftemp);
			coefMoyTemp = coefMoyTemp + coeftemp;
			moyenneFinaleTemp = moyenneFinaleTemp + (noteTemp * coeftemp);
		}
		ConnexionDB.DBClose();
		moyenneFinaleTemp = moyenneFinaleTemp / coefMoyTemp;
		System.out.println(moyenneFinaleTemp);
		double moyenneFinale = Math.round(moyenneFinaleTemp*100);
		moyenneFinale = moyenneFinale/100;
		System.out.println(moyenneFinale);
		if(moyenneFinale >= 16){
			mention = "Très Bien";
		}else if (moyenneFinale >= 14 && moyenneFinale < 15.99){
			mention = "Bien";
		}else if (moyenneFinale >= 12 && moyenneFinale < 13.99){
			mention = "Assez Bien";
		}else if (moyenneFinale >= 10 && moyenneFinale < 11.99){
			mention = "Passable";
		}else{
			mention = "Redoublement";
		}
		String req = "INSERT INTO moyenne_finale (Id, Cal_MoyFin, AppreciationDirecteur, Numero, Type) VALUES (" + id + ","+ moyenneFinale +", ''," + numero + ", '"+ mention +"')";
		ConnexionDB.DBConnexion();
		try {
			result = ConnexionDB.getStm().executeUpdate(req);
			System.out.println("Requete executée");	
		} catch (SQLException ex){
			result = - ex.getErrorCode();
		}
		System.out.println(req);
		ConnexionDB.DBClose();
		return result;
	}
	
	public static int supprimerDUneMoyenneFinale(int id){
		int result = -1;
		ConnexionDB.DBConnexion();
		String req = "DELETE FROM moyenne_finale WHERE Id = "+ id;
		try {
			result = ConnexionDB.getStm().executeUpdate(req);
			System.out.println("Requete executée");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
			
		}
		System.out.println(req);
		return result;
	}
	
	public static int modificationAppreciationDirecteur(int id, String appreciationDirecteur){
		int result = -1;
		ConnexionDB.DBConnexion();
		String res = "UPDATE moyenne_finale SET AppreciationDirecteur = '"+ appreciationDirecteur +"' WHERE Id = " + id;
		ConnexionDB.DBConnexion();
		try{
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
