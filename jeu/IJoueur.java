package jeu;

import java.util.ArrayList;

public interface IJoueur {
    public static final int MAX_MANA = 10;
    public static final int TAILLE_DECK = 15;

    void finirTour();
    ICarte getCarteEnJeu();
    ICarte getCarteEnMain();
    Heros getHeros();
    ArrayList<ICarte> getJeu();
    ArrayList<ICarte> getMain();
    int getMana();
    String getPseudo();
    int getStockMana();
    void jouerCarte(ICarte carte);
    void jouerCarte(ICarte carte, Carte cible);
    void perdreCarte(ICarte carte);
    void piocher();
    void prendreTour();
    void utiliserCarte(ICarte carte, Carte cible);
    void utiliserPouvoir(Carte cible);
    }
