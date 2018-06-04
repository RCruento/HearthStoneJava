package jeu.Carte;

import jeu.Exception.HearthstoneException;

import jeu.Joueur.IJoueur;

public interface ICarte  {
    boolean disparait();
    void    executerAction(Object cible) throws HearthstoneException;
    void executerEffetDebutTour();
    void    executerEffetDebutMiseEnJeu(Object cible)throws HearthstoneException;
    void    executerEffetDisparition(Object cible)throws HearthstoneException;
    void    executerEffetFinTour()throws HearthstoneException;
    int     getCout();
    String  getNomCarte();
    IJoueur getProprietaire();


}
