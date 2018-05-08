package jeu.Carte;

import jeu.Capacite.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Joueur.IJoueur;

public class Serviteur extends Carte {
    private int attaque;
    private int sante;
    private boolean endormis = true;
    private ICapacite capacite;

    //Constructor
    public Serviteur(IJoueur propietaire, String nom, int cout, int attauque, int sante, ICapacite capacite) {
        super(propietaire, nom, cout);
        this.attaque = attauque;
        this.sante = sante;
        this.capacite = capacite;
    }

    public Serviteur(IJoueur propietaire, String nom, int cout, int attauque, int sante) {
        super(propietaire, nom, cout);
        this.attaque = attauque;
        this.sante = sante;
    }

    //Getter & Setter
    public int getAttauque() {
        return attaque;
    }

    public void setAttauque(int attauque) {
        this.attaque = attauque;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public boolean getEndormis() {
        return endormis;
    }

    public void setEndormis(boolean endormis) {
        this.endormis = endormis;
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
