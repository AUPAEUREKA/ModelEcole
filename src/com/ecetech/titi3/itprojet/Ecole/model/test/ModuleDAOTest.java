package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Module;
import com.ecetech.titi3.itprojet.Ecole.model.dao.ModuleDAO;

public class ModuleDAOTest {

	@Test
	public void test() {
		testVisionnageDesModule();
	}
	
	public void testVisionnageDesModule(){
		ArrayList<Module> listModule = new ArrayList<Module>();
		
		Module n1 = new Module("Français");
		Module n2 = new Module("Mathématiques");
		Module n3 = new Module("Physique-Chimie");
		
		listModule.add(n1);
		listModule.add(n2);
		listModule.add(n3);
		
		for( int i = 0; i < listModule.size(); i++){
			assertEquals(listModule.get(i).getType(), ModuleDAO.visionnageDesModules().get(i).getType());
		}
	}

}
