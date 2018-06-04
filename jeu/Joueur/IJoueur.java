package jeu.Joueur;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;

import java.util.ArrayList;

/**
 * Interface IJoueur
 * Inteface classe qui a les methodes suivantes
 * @author Rayan KOUSSA
 *
 */
public interface IJoueur {
    public static final int MAX_MANA = 10;
    public static final int TAILLE_DECK = 15;


    /**
     * Permet de selectionner une carte en main en utilisant un bout de son nom
     * @param nomCarteJeu bout du nom de la carte
     * @return ICarte
     * @throws HearthstoneException
     *
     */
    ICarte getCarteEnJeu(String nomCarteJeu) throws HearthstoneException;



    /**
     * Permet de selectionner une carte en main en utilisant un bout de son nom
     * @param nomCarteMain bout du nom de la carte
     * @return ICarte
     * @throws HearthstoneException
     *
     */
    ICarte getCarteEnMain(String nomCarteMain) throws HearthstoneException;




    /**
     * Permet de connaitre le Heros avec  lequel le joueur joue
     * @return Heros
     */
    Heros getHeros();




    /**
     * Permet de connaitre les cartes dans le deck
     * @return ArrayListe<ICarte>
     */
    ArrayList<ICarte> getDeck();



    /**
     * Permet de connaitre les cartes sur le plateau
     * @return ArrayListe<ICarte>
     */
    ArrayList<ICarte> getJeu();



    /**
     * Permet de connaitre les cartes en main
     * @return ArrayListe<ICarte>
     */
    ArrayList<ICarte> getMain();




    /**
     * Permet de connaitre le mana du joueur
     * @return mana
     */
    int getMana();


    /**
     * Permet de modifier le mana d'un joueur
     */
    void setMana(int mana);

    /**
     * Permet de connaitre le pseudo du joueur
     * @return pseudo
     */
    String getPseudo();



    /**
     * Permet de connaitre le mana en stock qu'a un joeur
     * @return StockMana
     */
    int getStockMana();



    /**
     * Permet a un joueur de passer son tour de jeu
     * @throws HearthstoneException
     *
     */
    void finirTour() throws HearthstoneException;



    /**
     * Permet au jouer de selectionner une carte dans ça main et de la jouer
     * @param carte
     * @throws HearthstoneException
     *
     */
    void jouerCarte(ICarte carte) throws HearthstoneException;



    /**
     * Supprime une carte de la main si elle est jouée ou supprime une carte du plateau si elle disparait
     * @param carte
     * @throws HearthstoneException
     *
     */
    void perdreCarte(ICarte carte) throws HearthstoneException;



    /**
     * Permet à un joueur a chaque debut de tour de piocher
     */
    void piocher();



    /**
     * Permet a un joueur de prendre son tour apres que son adversaire aie choisit de finir le sien
     */
    void prendreTour()throws HearthstoneException;



    /**
     * Permet au joueur de selectionner une carte sur le plateau et d'attaquer une cible
     * @param carte carte sur le plateau
     * @param cible cible a attaquer
     * @throws HearthstoneException
     *
     */
    void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;



    /**
     * Permet au joueur d'ultiliser le pouvoir de son Heros
     * @param cible qui peut etre un serviteur ou l'adversaire
     * @throws HearthstoneException
     */
    void utiliserPouvoir(Object cible) throws HearthstoneException;




    /**
     * Affiche les cartes sur le plateau
     * @return String (chaine de carractères)
     */
    String afficherJeu();




    /**
     * Affiche les cartes en main du joueur
     * @return String (chaine de carractères)
     */
    String afficherMain();




    /**
     * Affiche le deck du jouer
     * @return String ( chaine de carractères)
     */
    String afficherDeck();
}
