package jeu.Carte;

import jeu.Exception.HearthstoneException;

import jeu.Joueur.IJoueur;
/**
 * Interface ICarte
 * Inteface classe qui a les methodes suivantes
 * @author Rayan KOUSSA
 * @see Sort
 * @see Serviteur
 */
public interface ICarte  {


    /**
     * Permet de savoir si un serviteur doit être enlevé du plateau ou non
     * Ou si une carte sort a été utilisé
     * @return true si les point de vie du serviteur = 0, false sinon
     * @return true si la carte sort a servit, false sinon
     */
    boolean disparait();





    /**
     * Permet a un Serviteur d'attaquer une cible
     * Permet a une carte d'utiliser ça capacité contre une cible
     * @param cible Heros ou Serviteur
     * @throws HearthstoneException
     */
    void    executerAction(Object cible) throws HearthstoneException;





    /**
     * Permet d'utiliser la capacité d'un serviteur a chaque début de tour
     */
    void    executerEffetDebutTour();





    /**
     * Permet a une carte sort ou serviteur d'utiliser sa capacité dès sa mise en jeu
     * @param cible
     * @throws HearthstoneException
     */
    void    executerEffetDebutMiseEnJeu(Object cible)throws HearthstoneException;





    /**
     * Permet d'utiliser la capacité d'un serviteur a sa mort
     * @param cible
     * @throws HearthstoneException
     */
    void    executerEffetDisparition(Object cible)throws HearthstoneException;





    /**
     * Permet d'utilier la capacité d'un serviteur a la fin du tour
     * @throws HearthstoneException
     */
    void    executerEffetFinTour()throws HearthstoneException;





    /**
     * Permet de connaitre le cout en mana d'une carte
     * @return cout
     */
    int     getCout();






    /**
     * Permet de connaitre le nom d'une carte
     * @return
     */
    String  getNomCarte();







    /**
     * Permet de connaitre le possesseur de la carte
     * @return IJoueur
     */
    IJoueur getProprietaire();


}
