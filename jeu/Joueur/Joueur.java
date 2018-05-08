package jeu.Joueur;

import jeu.Carte.Carte;
import jeu.Carte.ICarte;
import jeu.Deck.Deck;
import jeu.Heros.Heros;

import java.util.ArrayList;

public class Joueur implements IJoueur {
    private String pseudo;
    private Heros heros;
    private Deck deck;
    private int mana;
    private boolean joue = false; // = à 1 au premier joueur à 0 au second
    private ArrayList<ICarte> carteMain;
    private ArrayList<ICarte> carteEnJeu;

    //Constructor
    public Joueur(String pseudo, String hero){
        this.setPseudo(pseudo);
        this.heros = new Heros(hero);
        this.deck = new Deck(heros);
    }

    //Getter & Setter

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo){this.pseudo = pseudo;}

    public void finirTour() {

    }


    public ICarte getCarteEnJeu() {
        return null;
    }



    public ICarte getCarteEnMain() {
        return null;
    }


    public Heros getHeros() {
        return this.heros ;
    }

    public Deck getDeck(){
        return this.deck;
    }


    public ArrayList<ICarte> getJeu() {
        return null;
    }

    public ArrayList<ICarte> getMain() {
        return null;
    }


    public int getMana() {
        return 0;
    }


    public int getStockMana() {
        return 0;
    }


    public void jouerCarte(ICarte carte) {

    }

    public void jouerCarte(ICarte carte, Carte cible) {

    }


    public void perdreCarte(ICarte carte) {

    }

    public void piocher() {

    }


    public void prendreTour() {

    }


    public void utiliserCarte(ICarte carte, Carte cible) {

    }

    public void utiliserPouvoir(Carte cible) {

    }

    public boolean getNtour(){return this.joue;}

    public void setNomJ(String nomJ){
        if (this.pseudo == null && nomJ != null){
            this.pseudo = nomJ;
        }else{
            System.out.println("Erreur saisie veuillez corriger !");
            System.exit(1);
        }
    }
    public void setTour(boolean joue){
        this.joue = joue;
    }
    private void setDeck(Heros J ){
        this.deck = new Deck(J);
    }

    //Methods
    public String toString(){
        return "joueur : "+this.pseudo+"  "+this.getHeros()+ "  "+getDeck();
    }

}
