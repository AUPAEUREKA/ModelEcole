package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Module;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class ModuleDAO {

	/**
	 * Renvoie une liste des modules.
	 * @return : 1 liste des modules 
	 */	
	public static ArrayList<Module> visionnageDesModules(){
		ArrayList<Module> listModule = new ArrayList<Module>();
		ConnexionDB con = new ConnexionDB();
		ResultSet res = con.envoiRequete("SELECT Type FROM module");
		try {
			while(res.next())
			{
				Module moduleTemp = new Module();
				moduleTemp.setType(res.getString(1));
				listModule.add(moduleTemp);
			}
		}catch(Exception e) {}
		return listModule;
	}
	
}
