package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Eleve;
import com.ecetech.titi3.itprojet.Ecole.model.dao.EleveDAO;

public class EleveDAOTest {

	@Test
	public void test() throws SQLException {
		//testVisionnageDesEleve();
		//testInsertionDEleve();
		//testSuppresionEleve();
		testModificationEleve();
	}

	
	public void testVisionnageDesEleve() throws SQLException{
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		
		Eleve e1 = new Eleve("DELEPOULLE", "Julien", 1, 0);
		Eleve e2 = new Eleve("HAURET", "Philippe", 2, 1);
		
		listEleve.add(e1);
		listEleve.add(e2);
		
		for( int i = 0; i < listEleve.size(); i++){
			assertEquals(listEleve.get(i).getNumeroCarte(), EleveDAO.visionnageDesEleves().get(i).getNumeroCarte());
			assertEquals(listEleve.get(i).getNom(), EleveDAO.visionnageDesEleves().get(i).getNom());
			assertEquals(listEleve.get(i).getPrenom(), EleveDAO.visionnageDesEleves().get(i).getPrenom());
			assertEquals(listEleve.get(i).getNombreAbsence(), EleveDAO.visionnageDesEleves().get(i).getNombreAbsence());
		}
	}
	
	public void testInsertionDEleve(){
		EleveDAO.ajouterEleve(3, "RAYON", "Jonathan", "Terminale S1", "John1542");
	}
	
	public void testSuppresionEleve() throws SQLException{
		EleveDAO.supprimerEleve(3);
	}
	
	public void testModificationEleve(){
		EleveDAO.modifierEleve(3, "Rayon", "Johnny", 3);
	}
}
