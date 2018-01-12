package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Classe;
import com.ecetech.titi3.itprojet.Ecole.model.dao.ClasseDAO;

public class ClasseDAOTest {

	@Test
	public void test() {
		testVisionnageDesClasses();
	}
	
	public void testVisionnageDesClasses(){
		ArrayList<Classe> listClasse = new ArrayList<Classe>();
		
		Classe c1 = new Classe("Terminale S1");
		
		listClasse.add(c1);
		
		for( int i = 0; i < listClasse.size(); i++){
			assertEquals(listClasse.get(i).getNom(), ClasseDAO.visionnageDesClasses().get(i).getNom());
		}
	}

}
