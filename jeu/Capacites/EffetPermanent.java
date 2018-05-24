package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;



public class EffetPermanent extends Capacite {
    private int bonusSante;
    private int bonusAttaque;

    public EffetPermanent(String nom, String description, int bonusSante, int bonusAttaque) {
        super(nom, description);
        this.bonusSante = bonusSante;
        this.bonusAttaque = bonusAttaque;
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
        if(Plateau.getInstance().getJoueurCourant().getJeu().size() != 0){
            for (ICarte carte: Plateau.getInstance().getJoueurCourant().getJeu()
                 ) {
                if(carte != cible) {
                    ((Serviteur) carte).bonusSante(this.bonusSante);
                    ((Serviteur) carte).bonusAttaque(this.bonusAttaque);
                }

            }
        }

    }
}
