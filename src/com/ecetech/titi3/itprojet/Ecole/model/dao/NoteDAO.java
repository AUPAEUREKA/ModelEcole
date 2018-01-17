package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Note;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class NoteDAO {
	
	/**
	 * Renvoie une liste des notes.
	 * @return : 1 liste des notes 
	 * @throws SQLException 
	 */	
	public static ArrayList<Note> visionnageDesNotes() throws SQLException{
		ArrayList<Note> listNote = new ArrayList<Note>();
		String res = "SELECT Id, Note, Coef FROM note";
		ConnexionDB.DBConnexion();
		ConnexionDB.setRes(ConnexionDB.getStm().executeQuery(res));
		while(ConnexionDB.getRes().next())
		{
			Note noteTemp = new Note();
			noteTemp.setId(ConnexionDB.getRes().getInt(1));
			noteTemp.setNote(ConnexionDB.getRes().getDouble(2));
			noteTemp.setCoef(ConnexionDB.getRes().getInt(3));
			listNote.add(noteTemp);
		}
		ConnexionDB.DBClose();
		return listNote;
	}
	
	/**
	 * Ajouter une note
	 * @param typeModule : type d'une module
	 * @param numeroEleve : numéro d'un élève
	 * @param note : note
	 * @param coef : coefficient
	 * @param typeModule : module d'une table Module
	 * @param numeroEleve : numero d'une table Eleve
	 */
	/*public static int ajouterNote(double note, int coef, String typeModule, int numeroEleve){
		int result = -1;
		int id = 1;
		int idTemp;
		ConnexionDB con = new ConnexionDB();
		//générer un id manquant en parcourant la liste des notes
		ResultSet re = con.envoiRequete("SELECT * FROM Note");
		try {
			while(re.next()){
				if(id != re.getInt(1)){
					idTemp = re.getInt(1);
					String res = "INSERT INTO note (Id, Note, Coef, Type, Numero) VALUES ("+ idTemp +" ,"+ note +" , " + coef + ", "+ typeModule +" , " + numeroEleve + ")";
					try {
						result = ConnexionDB.getStm().executeUpdate(res);
						System.out.println("Requete executée");	
					} catch (SQLException ex)
					{
						result = - ex.getErrorCode();
						System.out.println(ex.getMessage());
					}
				}else{
					id++;
				}
			}
		} catch (SQLException ex){}
		return result;
	}*/
	
	
	public static int ajouterNote(int id, double note, int coef, String module, int numeroEleve){
		int result = -1;
		ConnexionDB.DBConnexion();
		//générer un id manquant en parcourant la liste des notes
		String res = "INSERT INTO note (Id, Note, Coef, Type, Numero) VALUES ("+ id +" ,"+ note +" , " + coef + ", '"+ module +"' , " + numeroEleve + ")";
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
	
	
	/**
	 * Modifier une note
	 * @param typeModule : type d'une module
	 * @param numeroEleve : numéro d'un élève
	 * @param note : note
	 * @param coef : coefficient
	 * @param typeModule : module d'une table Module
	 * @param numeroEleve : numero d'une table Eleve
	 */
	public static int modifierNote(int id, double note, int coef, String module, int numeroEleve){
		int result = -1;
		ConnexionDB.DBConnexion();
		String res = "UPDATE note SET Note = " + note + ", Coef = " + coef + " WHERE Id = "+ id +" AND Type = '" + module + "' AND Numero = " + numeroEleve +"";
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
	
	/**
	 * Supprimer note par id
	 * @param id
	 * @return : 1 ou 0  (le nbr d'étudiants supprimés) sinon le (-) code d'erreur  
	 */
	public static int supprimerNote(int id) {
		int result = -1;
		ConnexionDB.DBConnexion();
		String req = "DELETE FROM note WHERE Id = "+ id;
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
}
