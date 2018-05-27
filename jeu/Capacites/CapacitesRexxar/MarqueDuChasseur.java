package jeu.Capacites.CapacitesRexxar;

import jeu.Capacites.Capacite;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public class MarqueDuChasseur extends Capacite {
    public MarqueDuChasseur() {
        super("Marque du chasseur", "Reduit les point de vie a 1");
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new HearthstoneException("Aucune cible");
        }
        if(cible instanceof Serviteur){
            if(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().contains(cible)){
                ((Serviteur) Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getCarteEnJeu( ((Serviteur) cible).getNomCarte() )).setSante(1);
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
