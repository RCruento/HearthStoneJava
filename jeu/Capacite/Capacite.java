package jeu.Capacite;

import java.util.Objects;

public abstract class Capacite implements ICapacite {
    private String nom;
    private String description;
    private boolean used = false;

    public Capacite(String nom, String description){
        this.setNom(nom);
        this.setDescription(description);
    }


    public boolean getUsed() {
        return used;
    }
    public String getDescription() {
        return this.description;
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setUsed(boolean used) {
        this.used = used;
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
