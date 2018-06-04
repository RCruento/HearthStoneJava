package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

/**
 * Classe AttaqueTotale permet d'attaquer plusieurs serviteurs ennemis à la fois. Hérite de Capacité
 * @author Rayan KOUSSA
 * @version 0.1
 * @see Capacite
 */
public class AttaqueTotale extends Capacite {
    private int degat;

    public AttaqueTotale(String nom, String description, int degat) {
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


    }

    /**
     * Attaque tous les serviteurs sur le plateau
     * @throws HearthstoneException
     */
    @Override
    public void executerEffetDebutTour() throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if (getServis()) {
            throw new HearthstoneException("Capacité attaque total deja utilisée");
        }
        for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
            ((Serviteur) carte).blesserServiteur(this.degat);
        }
        super.setServis(true);
        for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()
                ) {
            if (((Serviteur) carte).disparait()) {
                plateau.getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(carte);
            }
        }
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
