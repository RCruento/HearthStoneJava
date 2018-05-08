package jeu.Capacite;

import jeu.Carte.Serviteur;
import jeu.Exception.*;
import jeu.Heros.Heros;

public class AttaqueCible extends Capacite  {
    private  int damage;

    //Constructor
    public AttaqueCible(String nom, String description, int damage) {
        super(nom, description);
        this.damage = damage;
    }

    //Getter & Setter
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    //Methods

    @Override
    public String toString() {
        return "AttaqueCible{" +
                "damage=" + damage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttaqueCible)) return false;
        if (!super.equals(o)) return false;
        AttaqueCible that = (AttaqueCible) o;
        return damage == that.damage;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new IllegalArgumentException("Aucune cible");
        }
        if(!getUsed()){
            throw new HearthstoneException("Capacité déjà Utilisé");
        }
        if(cible instanceof Heros || cible instanceof Serviteur){
            if(cible instanceof Heros){
                if()
            }

        }else{
            throw new HearthstoneException("Erreur cible");
        }

    }

    @Override
    public void executerEffetDebutTour() throws HearthstoneException{

    }

    @Override
    public void executeEffetDisparition(Object cible)throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTor()throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible)throws HearthstoneException {

    }
}
