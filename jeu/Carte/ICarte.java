package jeu.Carte;

import jeu.Exception.HearthstoneException;

import jeu.Player.IJoueur;

public interface ICarte  {
    boolean disparait();
    void    executerAction(Object cible) throws HearthstoneException;
    void    executerEffetDebutMiseEnJeu(Object cible)throws HearthstoneException;
    void    executerEffetDebutTour(Object cible)throws HearthstoneException;
    void    executerEffetDisparition(Object cible)throws HearthstoneException;
    void    executerEffetFinTour(Object cible)throws HearthstoneException;
    int     getCout();
    String  getNomCarte();
    IJoueur getProprietaire();

    void executerEffetFinTour() throws HearthstoneException;
}
