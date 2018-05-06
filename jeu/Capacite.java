package jeu;

public class Capacite implements ICapacite{
    private String nom;
    private String description;

    public Capacite(String nom, String description){
        this.setNom(nom);
        this.setDescription(description);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public String getNom() {
        return this.nom;
    }

    //Methods
    public String toString(){
        return "capacité : "+this.nom+" description : "+this.description;
    }
    public void executerAction(Object cible) {

    }


    public void executerEffetDebutTour() {

    }


    public void executeEffetDisparition(Object cible) {

    }


    public void executerEffetFinTor() {

    }


    public void executeEffetMiseEnjeu(Object cible) {

    }



}
