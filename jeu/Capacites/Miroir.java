package jeu.Capacites;

import jeu.Exception.HearthstoneException;

public final class Miroir extends Capacite {
    public Miroir() {
        super("Image mirroir", "Invoque 2 serviteurs 0/2");
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
