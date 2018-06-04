package jeu.Capacites.CapacitesRexxar;

import jeu.Capacites.Capacite;
import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

/**
 * Classe MarqueDuChasser representant une capacité. Herite de Capacité
 * @author Rayan KOUSSA
 * @version 0.1
 * @see  Capacite
 */
public class MarqueDuChasseur extends Capacite {
    public MarqueDuChasseur() {
        super("Marque du chasseur", "Reduit les point de vie a 1");
    }

    /**
     * Reduit les points de vie d'un serviteur a 1
     * @param cible serviteur
     * @throws HearthstoneException
     */
    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if(cible == null){
            throw new HearthstoneException("Aucune cible");
        }
        if(cible instanceof Serviteur){
            if(plateau.getAdversaire(plateau.getJoueurCourant()).getJeu().contains(cible)){
                for(ICarte carteCible : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()){
                    if(carteCible.getNomCarte().equals(((Serviteur) cible).getNomCarte())) {
                        ((Serviteur) plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu((carteCible).getNomCarte())).setSante(1);
                    }
                }
            }
        }else{
            throw new HearthstoneException("Tu ne peux cibler qu'un serviteur et rien d'autre");
        }

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

    }
}
