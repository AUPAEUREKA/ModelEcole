package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Moyenne;

import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class MoyenneDAO {
	
	
	public static ArrayList<Moyenne> visionnageDesMoyennes() throws SQLException{
		ArrayList<Moyenne> listMoyenne = new ArrayList<Moyenne>();
		String res = "SELECT Id, Calcul_moyenne, Numero FROM moyenne";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next())
		{
			Moyenne moyenneTemp = new Moyenne();
			moyenneTemp.setId(ConnexionDB.getRes().getInt(1));
			moyenneTemp.setCalculMoyenne(ConnexionDB.getRes().getDouble(2));
			moyenneTemp.setNumero(ConnexionDB.getRes().getInt(3));
			listMoyenne.add(moyenneTemp);
		}
		ConnexionDB.DBClose();
		return listMoyenne;
	}
	
	public static ArrayList<Moyenne> visionnageDesMoyennesDUnEleve() throws SQLException{
		ArrayList<Moyenne> listMoyenne = new ArrayList<Moyenne>();
		String req = "SELECT Id, Calcul_moyenne, Numero FROM moyenne WHERE Numero = 2";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(req));
		while(ConnexionDB.getRes().next())
		{
			Moyenne moyenneTemp = new Moyenne();
			moyenneTemp.setId(ConnexionDB.getRes().getInt(1));
			moyenneTemp.setCalculMoyenne(ConnexionDB.getRes().getDouble(2));
			moyenneTemp.setNumero(ConnexionDB.getRes().getInt(3));
			listMoyenne.add(moyenneTemp);
		}
		ConnexionDB.DBClose();
		return listMoyenne;
	}
	
	public static int modifierMoyenne(int numero, String type) throws SQLException{
		int result = -1;
		double moyenneTemp = 0;
		int coefMoyTemp = 0;
		String res = "SELECT Note, Coef FROM note WHERE Numero = " + numero + " AND Type = '" + type + "'";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next()){
			double noteTemp = ConnexionDB.getRes().getDouble(1);
			System.out.println(noteTemp);
			int coeftemp = ConnexionDB.getRes().getInt(2);
			System.out.println(coeftemp);
			coefMoyTemp = coefMoyTemp + coeftemp;
			moyenneTemp = moyenneTemp + (noteTemp * coeftemp);
		}
		ConnexionDB.DBClose();
		moyenneTemp = moyenneTemp / coefMoyTemp;
		System.out.println(moyenneTemp);
		double moyenne = Math.round(moyenneTemp*100);
		moyenne = moyenne/100;
		System.out.println(moyenne);
		
		String req = "UPDATE moyenne SET Calcul_moyenne = " + moyenne + " WHERE Numero = " + numero + " AND Type = '" + type + "'";
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
	
	public static int modificationAppreciation(int id, String appreciation){
		int result = -1;
		ConnexionDB.DBConnexion();
		
		String res = "UPDATE moyenne SET appreciation = '"+ appreciation +"' WHERE Id = " + id;
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
	
	public static int ajouterUneMoyenne(int id, int numero, String type) throws SQLException{
		int result = -1;
		double moyenneTemp = 0;
		int coefMoyTemp = 0;
		String res = "SELECT Note, Coef FROM note WHERE Numero = " + numero + " AND Type = '" + type + "'";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next()){
			double noteTemp = ConnexionDB.getRes().getDouble(1);
			System.out.println(noteTemp);
			int coeftemp = ConnexionDB.getRes().getInt(2);
			System.out.println(coeftemp);
			coefMoyTemp = coefMoyTemp + coeftemp;
			moyenneTemp = moyenneTemp + (noteTemp * coeftemp);
		}
		ConnexionDB.DBClose();
		moyenneTemp = moyenneTemp / coefMoyTemp;
		System.out.println(moyenneTemp);
		double moyenne = Math.round(moyenneTemp*100);
		moyenne = moyenne/100;
		System.out.println(moyenne);
		
		ConnexionDB.DBConnexion();
		String req = "INSERT INTO moyenne (Id, Calcul_moyenne, appreciation, Numero, Type) VALUES ("+id+","+moyenne+",'',"+numero+",'"+type+"')";
		//INSERT INTO `moyenne`() VALUES (3,16.63,'A REMPLIR',1,'Mathématiques')
		try {
			result = ConnexionDB.getStm().executeUpdate(req);
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
