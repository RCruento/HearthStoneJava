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
    public void executerEffetFinTor() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {
        if(cible instanceof Sort) {
            for (int i = 0; i < this.nbpioche; i++) {
                Plateau.getInstance().getJoueurCourant().piocher();

            }

            Plateau.getInstance().getJoueurCourant().getJeu().remove(cible);

        }else{
            throw new HearthstoneException("Cette carte ne permet pas de piocher");
        }

    }

    @Override
    public String toString() {
        return "Piocher{" +
                "piocher :" + nbpioche +" cartes"+
                '}';
    }
}
