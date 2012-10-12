package org.ldv.sio.getap;

import java.sql.Date;

class Exemple {

	private DemandeValidationConsoTempsAccPers dvctap;

	static public void main(String[] args) {
		Classe classe  = new Classe(1,"SIO22");
		User prof =  new User(1L,"Capuozzo", "Olivier",classe,"prof-principal","okpu","toto","okpu@gmail.fr");
		User eleve =  new User(2L,"Ben Ragdel", "Nizar",classe,"eleve","nini","toto","nizar@gmail.fr");
		AccPersonalise accPerso = new AccPersonalise(1,"Salon du libre",1,1L);
		Date date = Date.valueOf("07-10-2012");
		DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers(1L, "2012-2013", date, 20, prof,accPerso,eleve, 0);
		System.out.println(dvctap);
		dvctap.setEtat(4);
		System.out.println(dvctap);
		dvctap.setEtat(32);
		System.out.println(dvctap);
		dvctap.setEtat(4);
		System.out.println(dvctap);
		dvctap.setEtat(2048);
		System.out.println(dvctap);
		dvctap.setEtat(2);
		System.out.println(dvctap);
		dvctap.setEtat(32);
		System.out.println(dvctap);
	}
}