package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

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
        if(cible == null){
            throw  new HearthstoneException("Aucune cible");
        }
        if(cible instanceof Serviteur) {
            ((Serviteur) cible).setProvocation(true);
        }else{
            throw  new HearthstoneException("Provocation ne peut être que sur des serviteurs");
        }

    }
}
