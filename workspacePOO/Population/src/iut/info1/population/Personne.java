/**
 * Personne.java                       23 mars 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package iut.info1.population;

import iut.info1.datation.Date;

/**
 * Définit une personne.
 * Cette personne est défini par :
 * <ul>
 *     <li>son NIR (dit aussi numéro INSEE)</li>
 *     <li>son nom</li>
 *     <li>son prénom</li>
 *     <li>sa date de naissance</li>
 * </ul>
 * @author François deSaint Palais
 *
 */
public class Personne {
    
    private static final String REGEX_PRENOM_INVALIDE 
    = "[^0-9*-/+&~\\\"#\\\\{(|`_^@)\\[\\]=},?.;:!§ù%¨$£¤²]*";

    /** L'âge maximal d'un individu. 
     * Au delà la date de naissance serais jugé invalide. */
    final static int AGE_MAX = 130;

    /** 
     * Regex pour vérifier la validiter du NIR. Construit grâce à la page
     * Wikipedia du NIR. 
     * */
    private static final String REGEX_NIR_VALIDE 
    = "^[1-478][0-9]{2}(0[1-9]|1[012]|[23][0-9]|4[012]|[5-9][0-9])"
      + "(0[1-9]|[1-8][0-9]|9[0-6]|2[AaBb])"
      + "(0[1-9][0-9]|0[0-9][1-9]|[1-9][0-9]{2}){2}(0[1-9]|[1-8][0-9]|9[0-7])$";
    
    /** Le Numéro d'Inscription au Répertoire 
     * des personnes physiques il identifie chaque individu 
     * de manière unique*/
    private String NIR;
    
    /** Le nom de la personne */
    private String nom;
    
    /** Le prénom de la personne */
    private String prenom;
    
    /** La date de naissance de la personne */
    private Date dateNaiss;

    /**
     * Constructeur d'une Personne
     * @param nIR Le numéro NIR (ou INSEE)
     * @param nom Le nom
     * @param prenom Le prénom
     * @param dateNaiss La date de naissance. La date doit être valide.
     */
    public Personne(String nIR, String nom, String prenom, Date dateNaiss) {
        super();
        if (!estValide(nIR, nom, prenom, dateNaiss)) {
            throw new IllegalArgumentException("Erreur. "
                                               + "Une des entrés est invalide");
        }
        NIR = nIR;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
    }
    
    /** Retourne la valeur de NIR */
    public String getNIR() {
        return NIR;
    }

    /** Retourne la valeur de nom */
    public String getNom() {
        return nom;
    }

    /** Retourne la valeur de prenom */
    public String getPrenom() {
        return prenom;
    }

    /** Retourne la valeur de dateNaiss */
    public Date getDateNaiss() {
        return dateNaiss;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + ", né le " + dateNaiss + ". NIR : " + NIR;
    }
    
    /**
     * Retourne l'age que la personne aura a l'anné visé.
     * @param anneeVise
     * @return
     */
    public int ageEn(int anneeVise) {
        int age;
        
        return 0;
    }

    private boolean estValide(String nir, String nom, 
                              String prenom, Date dateNaiss) {
        return    nirEstValide(nir) && nomEstValide(nom) 
               && prenomEstValide(prenom) && dateNaissEstValide(dateNaiss);
    }

    private boolean dateNaissEstValide(Date dateDeNaissance) {
        // TODO écrire corps de dateNaissEstValide
        // TODO Récupérer l'année actuelle pour vérifier qu'une date de naissance ne soit pas dans le future.
        return dateDeNaissance.getAaaa() >= 1900 &&
               dateDeNaissance.getAaaa() <= 2023;
    }

    private boolean prenomEstValide(String prenom) {
        // TODO écrire le corps de prenomEstValide
        return    !prenom.isBlank() 
               && prenom.matches(REGEX_PRENOM_INVALIDE);
    }

    private boolean nomEstValide(String nom) {
        return prenomEstValide(nom);
    }

    private boolean nirEstValide(String nir) {
        return nir.matches(REGEX_NIR_VALIDE);
    }
}
