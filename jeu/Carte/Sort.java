package jeu.Carte;

import jeu.Capacite.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Joueur.IJoueur;

public class Sort extends Carte {
    private ICapacite capacite;

    //Constructor
    public Sort(IJoueur propietaire, String nom, int cout, ICapacite capacite) {
        super(propietaire, nom, cout);
        this.capacite = capacite;
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
}
