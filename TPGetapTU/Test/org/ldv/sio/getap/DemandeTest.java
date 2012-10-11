package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class DemandeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers(
				1L, 
				"2012-2013", 
				Date.valueOf("07-10-2012"), 
				20, 
				new User(1L,"Capuozzo", "Olivier",new Classe(1,"SIO22"),"prof-principal","okpu","toto","okpu@gmail.fr"),
				new AccPersonalise(),
				new User(2L,"FABRE", "ALLAN",new Classe(1,"SIO22"),"eleve","nini","toto","nizar@gmail.fr"), 
				0);
		
		assertTrue("Etat initial", dvctap.isEtatInitial());
	}

}
