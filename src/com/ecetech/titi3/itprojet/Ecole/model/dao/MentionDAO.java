package com.ecetech.titi3.itprojet.Ecole.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Mention;
import com.ecetech.titi3.itprojet.Ecole.model.common.ConnexionDB;

public class MentionDAO {

	/**
	 * Renvoie une liste des mentions.
	 * @return : 1 liste des mentions 
	 */	
	public static ArrayList<Mention> visionnageDesMention(){
		ArrayList<Mention> listMention = new ArrayList<Mention>();
		ConnexionDB con = new ConnexionDB();
		ResultSet res = con.envoiRequete("SELECT Type FROM mention");
		try {
			while(res.next())
			{
				Mention mentionTemp = new Mention();
				mentionTemp.setType(res.getString(1));
				listMention.add(mentionTemp);
			}
		}catch(Exception e) {}
		return listMention;
	}
	
}
