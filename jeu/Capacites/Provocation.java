package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

/**
 * Classe Provocation represente la capacité provocation. Hérite de Capactié
 * @author Rayan KOUSSA
 * @version 0.1
 * @see  Capacite
 */
public final class Provocation extends Capacite {


    public Provocation() {
        super("Provocation", "Oblige l'adverser à cibler ce serviteur");
        this.setServis(true);
    }

    //Methodes

    /**
     * Ce cas n'arrivera jamais
     * @param cible
     * @throws HearthstoneException
     */
    @Override
    public void executerAction(Object cible) throws HearthstoneException {

    }

    /**
     * Ce cas n'arrivera jamais
     * @throws HearthstoneException
     */
    @Override
    public void executerEffetDebutTour() throws HearthstoneException {

    }

    /**
     * Ce cas n'arrivera jamais
     * @param cible
     * @throws HearthstoneException
     */
    @Override
    public void executeEffetDisparition(Object cible) throws HearthstoneException {

    }

    /**
     * Ce cas n'arrivera jamais
     * @throws HearthstoneException
     */
    @Override
    public void executerEffetFinTour() throws HearthstoneException {

    }

    /**
     * Permet a la carte qui a cette capacité de proteger les cartes sur le plateau et le heros
     * @param cible la carte qui a cette capacité
     * @throws HearthstoneException
     *
     */
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
