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
		User eleve =  new User(2L,"Ben Ragdel", "Nizar",classe,"eleve");
		User prof =  new User(1L,"Capuozzo", "Olivier",classe,"prof-principal",discipline);
		
		AccPersonalise accPers = new AccPersonalise(1, "Salon du libre", 0, 1l); 
		
		Date date = Date.valueOf("2012-10-07");

		dvctap = new DemandeValidationConsoTempsAccPers(1l, "2012-2013", date, 240, prof, accPers, eleve, 0);
	}

	@Test
	public void testEtatInitial() {
		try{
			assertTrue("Etat initial", dvctap.isEtatInitial());
		}
		catch(DVCTAPException e){
		}

	}
	
	@Test
	public void testModifieeEleve(){
		try{
			dvctap.isEtatInitial();
			assertTrue("Etat modifié élève",dvctap.modifieeParEleve());
		}
		catch(DVCTAPException e){
		}
	}
	
	@Test
	public void testAnnuleeEleve(){
		try{
			dvctap.isEtatInitial();
			dvctap.annuleeParEleve();
			assertFalse("Etat annulation élève",dvctap.annuleeParEleve());
		}
		catch(DVCTAPException e){
		}
	}
	
	@Test
	public void testValideeProfesseur(){
		try{
			dvctap.isEtatInitial();
			dvctap.valideeParLeProfesseur();
			assertFalse("Etat validation professeur",dvctap.valideeParLeProfesseur());
		}
		catch(DVCTAPException e){
		}
	}
	
	@Test
	public void testRefuseeProfesseur(){
		try{
			dvctap.isEtatInitial();
			dvctap.refuseeParLeProfesseur();
			assertFalse("Etat refus professeur",dvctap.refuseeParLeProfesseur());
		}
		catch(DVCTAPException e){
		}
	}
	
	@Test
	public void testModificationProfesseur(){
		try{
			dvctap.isEtatInitial();
			dvctap.modifieeDateParLeProfesseur();
			dvctap.modifieeDureeParLeProfesseur();
			dvctap.modifieeAPParLeProfesseur();
			assertFalse("Etat modification professeur",dvctap.modifieeParEleve());
		}
		catch(DVCTAPException e){
		}
	}
	
	@Test
	public void testRejetEleve(){
		try{
			dvctap.isEtatInitial();
			dvctap.valideeParLeProfesseur();
			dvctap.modifieeDateParLeProfesseur();
			dvctap.rejeteeParEleve();
			assertFalse("Etat modification professeur",dvctap.modifieeParEleve());
			System.out.println(dvctap);
		}
		catch(DVCTAPException e){
		}
	}
	

}
