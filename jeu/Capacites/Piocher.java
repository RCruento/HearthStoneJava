package jeu.Capacites;

import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;
import jeu.Plateau.Plateau;
import jeu.Player.IJoueur;
import jeu.Player.Joueur;


public abstract class Piocher extends Capacite{
    private int nbpioche;

    public Piocher(String nom, String description, int nbpioche) {
        super(nom,description);
        this.nbpioche = nbpioche;
        this.setServis(true);
    }

    public int getNbpioche() {
        return nbpioche;
    }

    public void setNbpioche(int nbpioche) {
        this.nbpioche = nbpioche;
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
    public void executerEffetFinTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if(cible instanceof Sort) {
            for (int i = 0; i < this.nbpioche; i++) {
                plateau.getJoueurCourant().piocher();
            }
            plateau.getJoueurCourant().getJeu().remove(cible);
            plateau.getJoueurCourant().getMain().remove(cible);


        }else{
            for (int i = 0; i < this.nbpioche; i++) {
                plateau.getJoueurCourant().piocher();
            }
        }

    }

    @Override
    public String toString() {
        return "Piocher{" +
                "piocher :" + nbpioche +" cartes"+
                '}';
    }
}
