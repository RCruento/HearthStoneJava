package jeu.Carte;

import jeu.Exception.HearthstoneException;
import jeu.Joueur.IJoueur;

/**
 * Classe abstraite Carte representant une carte en général
 * @author Rayan KOUSSA
 * @version 0.1
 */
public abstract class Carte implements ICarte {
    private IJoueur owner;
    private String nom;
    private int cout;


    //Constructor
        //Serviteur
    public Carte( IJoueur propietaire, String nom, int cout ) {
        this.setProprietaire(propietaire);
        this.setNom(nom);
        this.setCout(cout);
    }

    public Carte( IJoueur propietaire, String nom ) {
        this.setProprietaire(propietaire);
        this.setNom(nom);
    }

    //Getter & Setter
    public String getNomCarte(){
        return this.nom;
    }
    public IJoueur getProprietaire() {
        return this.owner;
    }
    public int getCout(){
        return this.cout;
    }
    public void setProprietaire(IJoueur owner){
        this.owner= owner;
    }
    public void setNom(String nom){
        if (this.nom == null && nom != null){
            this.nom = nom;
        }else{
            System.out.println("Erreur saisie veuillez corriger !");
            System.exit(1);
        }
    }
    public void setCout(int mana){
        this.cout = mana;
    }

    //Methods

    /**
     * @see Sort
     * @see Serviteur
     */
    public abstract void executerEffetDebutTour(Object cible) throws HearthstoneException;

    /**
     *@see Sort
     *@see Serviteur
     * @throws HearthstoneException
     */
    public abstract void executerEffetFinTour() throws HearthstoneException;

    /**
     *@return les paramettre de la classe de la Carte en chaine de caractères
     */
    public String toString(){
        return "Carte : " + this.nom + " Cout : " + this.cout;
    }

    /**
     *Voit si une carte = une autre
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Carte other = (Carte) obj;
        if (cout != other.cout) {
            return false;
        }
        if (nom != null) {
            if (!nom.equals(other.nom))
                return false;
        } else {
            if (other.nom != null)
                return false;
        }
        return true;
    }


}
