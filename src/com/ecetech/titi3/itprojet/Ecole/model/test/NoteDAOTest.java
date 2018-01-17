
package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Note;
import com.ecetech.titi3.itprojet.Ecole.model.dao.NoteDAO;

public class NoteDAOTest {

	@Test
	public void test() throws SQLException {
		//testVisionnageDesNote();
		testInsertionNote();
		//testModificationNote();
		//testSuppresionNote();
	}
	
	
	public void testVisionnageDesNote() throws SQLException{
		ArrayList<Note> listNote = new ArrayList<Note>();
		
		Note n1 = new Note(1, 15, 3);
		Note n2 = new Note(2, 17, 2);
		Note n3 = new Note(3, 14, 2);
		Note n4 = new Note(4, 17, 1);
		Note n5 = new Note(5, 12, 2);
		Note n6 = new Note(6, 12, 2);
		Note n7 = new Note(7, 12, 5);
		
		listNote.add(n1);
		listNote.add(n2);
		listNote.add(n3);
		listNote.add(n4);
		listNote.add(n5);
		listNote.add(n6);
		listNote.add(n7);
		
		for( int i = 0; i < listNote.size(); i++){
			assertEquals(listNote.get(i).getId(), NoteDAO.visionnageDesNotes().get(i).getId());
			//assertEquals(listNote.get(i).getNote(), NoteDAO.visionnageDesNotes().get(i).getNote());
			assertEquals(listNote.get(i).getCoef(), NoteDAO.visionnageDesNotes().get(i).getCoef());
		}
	}
	
	public void testInsertionNote(){
		
		NoteDAO.ajouterNote(19, 20, 4, "Mathématiques", 1);
		
	}
	
	public void testModificationNote(){
		
		NoteDAO.modifierNote(8, 14, 2, "Mathématiques", 1);
		
	}
	
	public void testSuppresionNote(){
		
		NoteDAO.supprimerNote(9);
		
	}
}