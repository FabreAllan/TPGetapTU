package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class DemandeTest extends TestCase{
	
	private DemandeValidationConsoTempsAccPers dvctap;
	
	@Before
	public void setUp() throws Exception {
		Classe classe = new Classe(1, "SIO22");
		Discipline discipline = new Discipline(1, "SLAM4");
		User eleve =  new User(2L,"Ben Ragdel", "Nizar",classe,"eleve","nini","toto","nizar@gmail.fr");
		User prof =  new User(1L,"Capuozzo", "Olivier",classe,"prof-principal","okpu","toto","okpu@gmail.fr");
		
		AccPersonalise accPers = new AccPersonalise(1, "Salon du libre", 0, 1l);
		Date date = Date.valueOf("2012-10-07");

		dvctap = new DemandeValidationConsoTempsAccPers(1l, "2012-2013", date,
				240, prof, accPers, eleve, 0);
	}

	@Test
	public void test() {
		try{
			assertTrue("Etat initial", dvctap.isEtatInitial());
		}
		catch(DVCTAPException e){
		}

	}
	
	public void testEtatDifferents() {
		try{
			dvctap.modifieeParEleve();
			dvctap.modifieeParEleve();
			dvctap.modifieeDateParLeProfesseur();
			dvctap.modifieeDureeParLeProfesseur();
			dvctap.accepteeParEleve();
			assertFalse("Demande accepté par l'élève!", dvctap.accepteeParEleve());
		}
		catch(DVCTAPException e){
		}

	}
	
	public void testModEleveValidProf() {
		try{
			dvctap.setEtat(0);
			dvctap.modifieeParEleve();
			dvctap.valideeParLeProfesseur();
			assertFalse("Demande valider par le professeur!", dvctap.valideeParLeProfesseur());
		}
		catch(DVCTAPException e){
		}

	}
	
	public void testCreRejet(){
		try{
			dvctap.setEtat(0);
			dvctap.rejeteParEleve();
			assertFalse("Demande rejeter par l'élève", dvctap.rejeteParEleve());
		}
		catch(DVCTAPException e){
		}
	}

}
