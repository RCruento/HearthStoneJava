package jeu.Plateau;

import jeu.Carte.Carte;
import jeu.Deck.Deck;
import jeu.Joueur.Joueur;

public class Plateau implements IPlateau {
    private IJoueur joueur;
    private Deck deck;



    public Plateau(Joueur joueur, Carte carte, Deck deck) {
        this.setJoeur(joueur);
        this.setCarte(carte);
        this.setDeck(deck);
    }



    //Getter Setter

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

    @Override
    public void ajouterJoueur(IJoueur joueur) {
        this.joueur = getJoeur();
    }

    @Override
    public void demarerPartie(){

    }

    @Override
    public boolean estDemaree() {
        return false;
    }

    @Override
    public void gagnerPartie(IJoueur joueur) {

    }

    @Override
    public void finirTour(IJoueur joueur) {

    }

    @Override
    public IJoueur getAdversaire(IJoueur joueur) {
        return getJoeur();
    }

    @Override
    public IJoueur getJoueurCourant() {
        return getJoeur();
    }

    @Override
    public void setJoueurCourant(IJoueur joueur) {

    }




}
