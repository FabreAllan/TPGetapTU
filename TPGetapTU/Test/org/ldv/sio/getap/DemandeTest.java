package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class DemandeTest {
	DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers(
			1L, 
			"2012-2013", 
			Date.valueOf("07-10-2012"), 
			20, 
			new User(1L,"Capuozzo", "livier",new Classe(1,"SIO22"),"prof-principal","okpu","toto","okpu@gmail.fr"),
			new AccPersonalise(),
			new User(2L,"Ben Ragdel", "Nizar",new Classe(1,"SIO22"),"eleve","nini","toto","nizar@gmail.fr"), 
			0);

	@Before
	public void setUpBefore() throws Exception {
	}

	@Test
	public void test() {

		try{
			assertTrue("Etat initial", dvctap.isEtatInitial());
		}

		catch(DVCTAPException e){
		}
	}

}
