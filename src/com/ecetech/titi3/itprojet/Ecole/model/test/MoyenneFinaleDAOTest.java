package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.MoyenneFinale;
import com.ecetech.titi3.itprojet.Ecole.model.dao.MoyenneFinaleDAO;


public class MoyenneFinaleDAOTest {

	@Test
	public void test() throws SQLException {
		//testVisionnageDesMoyennesFinales();
		//testVisionnageDUneMoyenneFinaleDUnEleve();
		//testModificationDUneMoyenneFinale();
		//testModificationAppreciationDirecteur();
		testInsertionDUneMoyenneFinale();
		//testSuppresionDUneMoyennFinale();
	}
	
	public void testVisionnageDesMoyennesFinales() throws SQLException{
		ArrayList<MoyenneFinale> listMoyenneFinale = new ArrayList<MoyenneFinale>();
		
		MoyenneFinale mf1 = new MoyenneFinale(1, 15.7, 1);
		MoyenneFinale mf2 = new MoyenneFinale(2, 12, 2);
		
		listMoyenneFinale.add(mf1);
		listMoyenneFinale.add(mf2);
		
		for( int i = 0; i < listMoyenneFinale.size(); i++){
			assertEquals(listMoyenneFinale.get(i).getId(), MoyenneFinaleDAO.visionnageDesMoyennesFinales().get(i).getId());
			//assertEquals(listMoyenneFinale.get(i).getNote(), NoteDAO.visionnageDesMoyennesFinales().get(i).getNote());
			assertEquals(listMoyenneFinale.get(i).getNumero(), MoyenneFinaleDAO.visionnageDesMoyennesFinales().get(i).getNumero());
		}
	}
	
	public void testModificationDUneMoyenneFinale() throws SQLException{
		MoyenneFinaleDAO.modificationDUneMoyenneFinale(1);
	}
	
	public void testSuppresionDUneMoyennFinale(){
		MoyenneFinaleDAO.supprimerDUneMoyenneFinale(1);
	}
	
	public void testInsertionDUneMoyenneFinale() throws SQLException{
		MoyenneFinaleDAO.ajouterDUneMoyennFinale(1,1);
	}
	
	public void testModificationAppreciationDirecteur(){
		MoyenneFinaleDAO.modificationAppreciationDirecteur(1, "C est un élève motivé !!");
	}

}
