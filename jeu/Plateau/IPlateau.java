package jeu.Plateau;

import jeu.Exception.HearthstoneException;
import jeu.Joueur.IJoueur;

public interface IPlateau {
    void ajouterJoueur(IJoueur joueur);
    void demarerPartie() throws HearthstoneException;
    boolean estDemaree();
    void gagnerPartie(IJoueur joueur);
    void finirTour(IJoueur joueur)throws HearthstoneException;
    IJoueur getAdversaire(IJoueur joueur);
    IJoueur getJoueurCourant()throws HearthstoneException;
    void setJoueurCourant(IJoueur joueur);
}
