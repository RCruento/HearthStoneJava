package jeu.Capacite;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;

public class Provocation extends Capacite {
    private boolean provocation;

    public Provocation(String nom, String description, boolean provocation) {
        super(nom, description);
        this.provocation = provocation;
    }

    public boolean getProvocation() {
        return provocation;
    }

    public void setProvocation(boolean provocation) {
        this.provocation = provocation;
    }

    @Override
    public String toString() {
        return "Provocation{" +
                "provocation=" + provocation +
                '}';
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDebutTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetDisparition(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTor() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {
        if(cible !=null){
            if(cible instanceof Serviteur){
                Serviteur serviteur = (Serviteur) cible;
                serviteur.setCapacite(Provocation);
            }
        }

    }
}
