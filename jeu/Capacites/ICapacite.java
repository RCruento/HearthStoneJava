package jeu.Capacites;

import jeu.Exception.HearthstoneException;

/**
 * Interface ICapacite
 * Inteface classe qui a les methodes suivantes
 * @author Rayan KOUSSA
 * @see Capacite
 */
public interface ICapacite {

    /**
     * Permet d'utiliser la Capacité d'une carte
     * @param cible serviteur ou heros
     * @throws HearthstoneException
     */
    void executerAction(Object cible) throws HearthstoneException;


    /**
     * Permet D'utiliser la capacité d'une carte au debut du tour
     * @throws HearthstoneException
     */
    void executerEffetDebutTour()throws HearthstoneException;


    /**
     * Permet d'utiliser la capacité d'une carte a sa disparition du plateau
     * @param cible
     * @throws HearthstoneException
     */
    void executeEffetDisparition(Object cible)throws HearthstoneException;


    /**
     * Permet d'utiliser la capacité d'une carte à la fin du tour
     * @throws HearthstoneException
     */
    void executerEffetFinTour()throws HearthstoneException;


    /**
     * Permert d'utiliser la capacité d'une carte dès sa mie en jeu
     * @param cible la carte elle meme
     * @throws HearthstoneException
     */
    void executeEffetMiseEnjeu(Object cible)throws HearthstoneException;


    /**
     * Permet d'avoir la decription de la capacité
     * @return description
     */
    String getDescription();


    /**
     * Permet d'avoir le nom de la capacité
     * @return nom
     */
    String getNom();
}
