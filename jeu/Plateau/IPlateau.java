package jeu.Plateau;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Joueur.IJoueur;

/**
 * Interface IPlateau
 * Inteface classe qui a les methodes suivantes
 * @author Rayan KOUSSA
 * @see Plateau
 */
public interface IPlateau {

    /**
     * Ajoute un joueur a la partie
     * @param joueur
     */
    void ajouterJoueur(IJoueur joueur);


    /**
     * Permet de commencer un partie
     */
    void demarerPartie() throws HearthstoneException;


    /**
     * Verifie si une partie a commencée
     * @return true si elle a commencée, false sinon
     */
    boolean estDemaree();


    /**
     * Le joueur en parametre gagne la partie
     * @param joueur Joueur courant
     */
    void gagnerPartie(IJoueur joueur);


    /**
     * Finis le tour du joueur courant
     * @param joueur
     * @throws HearthstoneException
     * @see jeu.Joueur.Joueur
     */
    void finirTour(IJoueur joueur)throws HearthstoneException;


    /**
     * Permet de connaitre l'adversaire
     * @param joueur
     * @return
     * @throws HearthstoneException
     */
    IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException;


    /**
     * Permet de connaitre le joueur qui a le tour
     * @return
     * @throws HearthstoneException
     */
    IJoueur getJoueurCourant()throws HearthstoneException;


    /**
     * Permet de mettre a jour le joueur courant
     * @param joueur
     */
    void setJoueurCourant(IJoueur joueur);

}
