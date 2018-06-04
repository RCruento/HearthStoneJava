package jeu.Capacites;

import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

/**
 * Classe Priocher represente la capacité Piocher d'une carte. Hérite de Capacité
 * @author  Rayan KOUSSA
 * @version 0.1
 * @see Capacite
 */
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

    //methodes

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
     * Permet a la carte qui possede cette capacité de piocher
     * @param cible
     * @throws HearthstoneException
     */
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

    /**
     * Affiche le nom et la description de la capacité
     * @return
     */
    @Override
    public String toString() {
        return "Piocher{" +
                "piocher :" + nbpioche +" cartes"+
                '}';
    }
}
