package jeu.Player;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;

import java.util.ArrayList;

public interface IJoueur {
    public static final int MAX_MANA = 10;
    public static final int TAILLE_DECK = 15;

    void finirTour() throws HearthstoneException;
    ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException;
    ICarte getCarteEnMain(String nomCarteMain) throws HearthstoneException;
    Heros getHeros();
    ArrayList<ICarte> getDeck();
    ArrayList<ICarte> getJeu();
    ArrayList<ICarte> getMain();
    int getMana();
    String getPseudo();
    int getStockMana();
    void jouerCarte(ICarte carte) throws HearthstoneException;
    void perdreCarte(ICarte carte) throws HearthstoneException;
    void piocher();
    void prendreTour()throws HearthstoneException;
    void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
    void utiliserPouvoir(Object cible) throws HearthstoneException;


    String afficherJeu();
    String afficherMain();
    String afficherDeck();
}
