package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

public final class Charge extends Capacite  {

    public Charge(){
        super("Charge", "Cette capacité permet a un serviteur de pas attendre");
        this.setServis(true);
    }

    public void executerAction(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDebutTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetDisparition(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new  HearthstoneException("Aucune cible");
        }
        if(cible instanceof Heros){
            throw new HearthstoneException("Tu ne peux pas mettre charge sur le hero");
        }
        if (cible instanceof Serviteur){
                ((Serviteur) cible).reveiller();

        }

    }

}
