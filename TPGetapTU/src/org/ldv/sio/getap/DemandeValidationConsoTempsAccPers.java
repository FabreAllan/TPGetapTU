package org.ldv.sio.getap;

import java.sql.Date;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	private static final int demande_creer_eleve=0;
	private static final int demande_accepter_eleve=1;
	private static final int demande_rejet_eleve=2;
	private static final int demande_modif_eleve=4;
	private static final int demande_annul_eleve=8;
	private static final int demande_valid_prof=32;
	private static final int demande_refus_prof = 64;
	private static final int DATE_MODIFIEE = 1024;
	private static final int DUREE_MODIFIEE = 2048;
	private static final int AP_MODIFIEE = 4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	public boolean isEtatInitial(){
		return this.etat == 0;
	}

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id peut être null (moment de la creation)
	 *            
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve 
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire, Date date,
			Integer minutes, User prof, AccPersonalise accPers, User eleve,
			int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}

	/**
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande créée par l'élève</li>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}
    public boolean isdemande_creer_eleve() {   
	    return ((this.etat & demande_creer_eleve) == 0);  
    }
    public boolean isdemande_accepter_eleve() {  
	    return ((this.etat & demande_accepter_eleve) != 0);
	}
   
	public boolean isdemande_rejet_eleve() {
		return ((this.etat & demande_rejet_eleve) != 0);
	}

	public boolean isdemande_modif_eleve() {
		return ((this.etat & demande_modif_eleve) != 0);
	}

	public boolean isdemande_annul_eleve() {
		return ((this.etat & demande_annul_eleve) != 0);
	}

	public boolean isdemande_valid_prof() {
		return ((this.etat & demande_valid_prof) != 0);
	}

	public boolean isdemande_refus_prof() {
		return ((this.etat & demande_refus_prof) != 0);
	}

	public boolean isDATE_MODIFIEE() {
		return ((this.etat & DATE_MODIFIEE) != 0);
	}

	public boolean isDUREE_MODIFIEE() {
		return ((this.etat & DUREE_MODIFIEE) != 0);
	}

	public boolean isEtatAccPersModifierProf() {
		return ((this.etat & AP_MODIFIEE) != 0);
	}

	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}

}
