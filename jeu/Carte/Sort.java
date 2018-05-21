package jeu.Carte;

import jeu.Capacites.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Player.IJoueur;

public class Sort extends Carte {
    private ICapacite capacite;

    //Constructor
    public Sort(IJoueur propietaire, String nom, int cout, ICapacite capacite) {
        super(propietaire, nom, cout);
        this.setCapacite(capacite);
    }

    public ICapacite getCapacite() {
        return capacite;
    }

    public void setCapacite(ICapacite capacite) {
        this.capacite = capacite;
    }

    @Override
    public boolean disparait() {
        return false;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDebutTour(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTour(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTour() {

    }

    @Override
    public String toString() {
        return "Sort{"+ this.getNomCarte() +" , Mana : "+this.getCout()+" , "+
                capacite +
                '}';
    }
}
