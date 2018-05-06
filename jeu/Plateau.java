package jeu;

public class Plateau {
    private Joueur joueur;
    private Carte carte;
    private Deck deck;



    public Plateau(Joueur joueur, Carte carte, Deck deck) {
        this.setJoeur(joueur);
        this.setCarte(carte);
        this.setDeck(deck);
    }



    public void setJoeur(Joueur joeur) {
        this.joueur = joeur;
    }

    public Joueur getJoeur() {
        return joueur;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }


    //Getter Setter

}
