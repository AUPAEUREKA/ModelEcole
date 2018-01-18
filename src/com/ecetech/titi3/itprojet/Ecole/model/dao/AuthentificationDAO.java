package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.SQLException;

import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class AuthentificationDAO {
	
	public static int modifierPassword(String login, String password) {
		int result = -1;
		ConnexionDB.DBConnexion();
		String res = "UPDATE authentification SET PasswordEleve = '" + password + "' WHERE LoginEleve = '"+ login +"'";
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
