package jeu.Capacites;

import jeu.Exception.HearthstoneException;

public final class Piocher extends Capacite{
    private int nbpioche;

    public Piocher(int nbpioche) {
        super("Piocher","Permet de piocher une ou plusieurs cartes" );
        this.nbpioche = nbpioche;
        this.setServis(true);
    }

    public int getNbpioche() {
        return nbpioche;
    }

    public void setNbpioche(int nbpioche) {
        this.nbpioche = nbpioche;
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
        if(cible == null){

        }
    }

    @Override
    public String toString() {
        return "Piocher{" +
                "piocher :" + nbpioche +" cartes"+
                '}';
    }
}
