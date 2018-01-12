package com.ecetech.titi3.itprojet.Ecole.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.titi3.itprojet.Ecole.model.beans.Mention;
import com.ecetech.titi3.itprojet.Ecole.model.dao.MentionDAO;

public class MentionDAOTest {

	@Test
	public void test() {
		testVisionnageDesMention();
	}

	
	public void testVisionnageDesMention(){
		ArrayList<Mention> listMention = new ArrayList<Mention>();
		
		Mention m1 = new Mention("Assez Bien");
		Mention m2 = new Mention("Bien");
		Mention m3 = new Mention("Passable");
		Mention m4 = new Mention("Redoublement");
		Mention m5 = new Mention("Très Bien");
		
		listMention.add(m1);
		listMention.add(m2);
		listMention.add(m3);
		listMention.add(m4);
		listMention.add(m5);
		
		for( int i = 0; i < listMention.size(); i++){
			assertEquals(listMention.get(i).getType(), MentionDAO.visionnageDesMention().get(i).getType());
		}
	}
}
