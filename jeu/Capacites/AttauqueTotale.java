package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public abstract class AttauqueTotale extends Capacite {
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
        if(getServis()){
            throw new HearthstoneException("Capacité attaque total deja utilisée");
        }
        if(cible instanceof Serviteur){
            for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                 ) {
                ((Serviteur)carte).blesserServiteur(degat);
            }
            for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                    ) {
                if(((Serviteur)carte).disparait()){
                    Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(carte);
                }
            }
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
