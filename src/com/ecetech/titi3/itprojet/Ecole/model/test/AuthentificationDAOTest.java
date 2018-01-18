package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.dao.AuthentificationDAO;

public class AuthentificationDAOTest {

	@Test
	public void test() {
		testModificationPassword();
	}
	
	public void testModificationPassword() {
		AuthentificationDAO.modifierPassword("John1542", "TestPassword");
	}
}
