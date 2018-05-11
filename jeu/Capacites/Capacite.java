package jeu.Capacites;

import java.util.Objects;

public abstract class Capacite implements ICapacite {
    private String nom;
    private String description;
    private boolean servis = false;

    public  Capacite(String nom, String description){
        if(nom == null || nom.equals("")|| nom.isEmpty()){
            throw  new IllegalArgumentException("Nom capacité non valide");
        }
        this.setNom(nom);
        this.setDescription(description);
    }




    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getServis() {
        return servis;
    }
    public void setServis(boolean servis){
        this.servis = servis;
    }

    //Methods
    public String toString(){
        return "capacité : "+this.nom+" description : "+this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Capacite)) return false;
        Capacite capacite = (Capacite) o;
        return Objects.equals(nom, capacite.nom) &&
                Objects.equals(description, capacite.description);
    }

}
