package jeu.Carte;

import jeu.Joueur.IJoueur;


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
    public String toString(){
        return "Carte : " + this.nom + " Cout : " + this.cout;
    }
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
