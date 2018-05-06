package jeu;

public class Capacite implements ICapacite{
    private String nom;
    private String description;

    public Capacite(String nom, String description){
        this.setNom(nom);
        this.setDescription(description);
    }

    private void setNom(String nom) {
        this.nom = nom;
    }
    private void setDescription(String description){
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public String getNom() {
        return this.nom;
    }

    //Methods
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
