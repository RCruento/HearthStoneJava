package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;

public final class Charge extends Capacite  {

    public Charge(){
        super("Charge", "Cette capacité permet a un serviteur de pas attendre");
        this.setServis(true);
    }

    public void executerAction(Object cible) throws HearthstoneException {
        if (cible == null) {
            throw new IllegalArgumentException( "La capacité 'Charge' nécessite une cible");
        } else if (!(cible instanceof Serviteur)) {
            throw new HearthstoneException("Ver de terre greloteux que tu es, tu dois désigner un serviteur !");
        } else {
            Serviteur serviteurCible = (Serviteur) cible;
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
