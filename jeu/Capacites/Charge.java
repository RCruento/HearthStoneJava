package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

/**
 * Classe Charge qui Herite de Capacité , permet au serviteur qui possede
 * cette capacité de ne pas attendre pour attaquer
 * @author  Rayan KOUSSA
 * @version 0.1
 * @see Capacite
 */
public final class Charge extends Capacite  {

    public Charge(){
        super("Charge", "Cette capacité permet a un serviteur de ne pas attendre un tour pour attaquer");
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


    /**
     * Change le paramettre attaquer du serviteur et le met a true
     * @param cible serviteur
     * @throws HearthstoneException
     */
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
