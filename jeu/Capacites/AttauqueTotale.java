package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public class AttauqueTotale extends Capacite {
    private int degat;

    public AttauqueTotale(String nom, String description, int degat) {
        super(nom, description);
        this.degat = degat;
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if (getServis()) {
            throw new HearthstoneException("Capacité attaque total deja utilisée");
        }
        for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                ) {
            ((Serviteur) carte).blesserServiteur(this.degat);
        }
        super.setServis(true);
        for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                ) {
            if (((Serviteur) carte).disparait()) {
                Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(carte);
            }
        }

    }

    @Override
    public void executerEffetDebutTour(){

    }

    @Override
    public void executeEffetDisparition(Object cible)  {

    }

    @Override
    public void executerEffetFinTour(){

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) {

    }

}
