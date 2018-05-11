package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

public final class BouleDeFeu extends Capacite {
    private int degat = 1;

    public BouleDeFeu() {
        super("Boule de feu","flamme" );
        super.setServis(true);
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if (cible == null){
            throw new IllegalArgumentException("Cible nulle");
        }
        if(cible instanceof Sort){
            throw new HearthstoneException("Cibler un sort est impossible");
        }
        if (cible instanceof Plateau){
            throw new HearthstoneException("Cibler le platau??????");
        }
        if(cible instanceof Heros){
            Heros heros = (Heros) cible;
            heros.setHealt(heros.getHealt()-this.degat);
        }
        if(cible instanceof Serviteur){
            Serviteur serviteur = (Serviteur) cible;
            serviteur.setSante(serviteur.getSante()- this.degat);
            if(serviteur.disparait()){

            }

        }

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

    }
}
