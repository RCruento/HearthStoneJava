package jeu.Capacites;

import jeu.Exception.HearthstoneException;

public final class Provocation extends Capacite {


    public Provocation() {
        super("Provocation", "Oblige l'adverser à cibler ce serviteur");
        this.setServis(true);
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

    }
}
