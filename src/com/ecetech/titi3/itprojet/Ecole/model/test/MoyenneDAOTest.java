package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Moyenne;
import com.ecetech.titi3.itprojet.Ecole.model.dao.MoyenneDAO;

public class MoyenneDAOTest {

	@Test
	public void test() throws SQLException {
		testVisionnageDesMoyennes();
		//testVisionnageDesMoyennesDUnEleve();
		//testModificationDUneMoyenne();
		//testModificationAppreciation();
		//testInsertionDUneMoyenne();
		//testSuppresionDUneMoyenne();
	}
	
	public void testVisionnageDesMoyennes() throws SQLException{
		ArrayList<Moyenne> listMoyenne = new ArrayList<Moyenne>();
		
		Moyenne m1 = new Moyenne(1, 15.8, 1);
		Moyenne m2 = new Moyenne(2, 14, 1);
		Moyenne m3 = new Moyenne(3, 16.63, 1);
		Moyenne m4 = new Moyenne(4, 12, 2);
		Moyenne m5 = new Moyenne(5, 12, 2);
		Moyenne m6 = new Moyenne(6, 12, 2);
		
		listMoyenne.add(m1);
		listMoyenne.add(m2);
		listMoyenne.add(m3);
		listMoyenne.add(m4);
		listMoyenne.add(m5);
		listMoyenne.add(m6);
		
		for( int i = 0; i < listMoyenne.size(); i++){
			assertEquals(listMoyenne.get(i).getId(), MoyenneDAO.visionnageDesMoyennes().get(i).getId());
			//assertEquals(listNote.get(i).getNote(), NoteDAO.visionnageDesNotes().get(i).getNote());
			assertEquals(listMoyenne.get(i).getNumero(), MoyenneDAO.visionnageDesMoyennes().get(i).getNumero());
		}
		
	}
	
	public void testVisionnageDesMoyennesDUnEleve() throws SQLException{
		ArrayList<Moyenne> listMoyenne = new ArrayList<Moyenne>();
		
		Moyenne m1 = new Moyenne(4, 12, 2);
		Moyenne m2 = new Moyenne(5, 12, 2);
		Moyenne m3 = new Moyenne(6, 12, 2);
		
		listMoyenne.add(m1);
		listMoyenne.add(m2);
		listMoyenne.add(m3);
		
		for( int i = 0; i < listMoyenne.size(); i++){
			assertEquals(listMoyenne.get(i).getId(), MoyenneDAO.visionnageDesMoyennesDUnEleve().get(i).getId());
			//assertEquals(listNote.get(i).getNote(), NoteDAO.visionnageDesNotesDUneEleve().get(i).getNote());
			assertEquals(listMoyenne.get(i).getNumero(), MoyenneDAO.visionnageDesMoyennesDUnEleve().get(i).getNumero());
		}
		
		
	}
	
	public void testModificationDUneMoyenne() throws SQLException{
		MoyenneDAO.modifierMoyenne(1,"Mathématiques");
	}
	
	private void testInsertionDUneMoyenne() throws SQLException {
		MoyenneDAO.ajouterUneMoyenne(3, 1, "Mathématiques");
		
	}
	
	private void testModificationAppreciation() {
		MoyenneDAO.modificationAppreciation(3, "Il a résolu la théorème d Euler");
	}
	
	
}
