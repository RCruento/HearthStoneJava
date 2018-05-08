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
    private int mana = 0;
    private int stock = 0;
    private boolean joue = false; // = à 1 au premier joueur à 0 au second
    private ArrayList<ICarte> carteMain;
    private ArrayList<ICarte> carteEnJeu;

    //Constructor
    public Joueur(String pseudo, Heros heros){
        this.setPseudo(pseudo);
        this.setHeros(heros);
        this.carteMain = new ArrayList<ICarte>();
        this.carteEnJeu = new ArrayList<ICarte>();
        this.deck = new Deck(this);

    }

    //Getter & Setter
        //Getter
    public String getPseudo(){
        return this.pseudo;
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
    public int getMana() {
        return this.mana;
    }
    public int getStockMana() {
        return this.stock;
    }
    public ArrayList<ICarte> getJeu() {
        return null;
    }
    public ArrayList<ICarte> getMain() {
        return null;
    }
        //Setter
    public void setPseudo(String pseudo){
        if (pseudo != null){
            this.pseudo = pseudo;
        }else{
            throw new IllegalArgumentException("Variable Nulle");
        }
    }
    public void setHeros(Heros heros){
        if(heros == null){
            throw new IllegalArgumentException("Variable nulle");
        }
        this.heros = heros;
    }
    public void setMana(int mana){
        if(mana <= 0){
            throw new IllegalArgumentException("Mana erreur");
        }
        this.mana = mana;
    }
    public void setStock(int stock){
        if(0<stock && stock==1){
            this.stock = stock;
        }else {
            throw new IllegalArgumentException("Erreur stock");
        }
    }
    public void setTour(boolean joue){
        this.joue = joue;
    }
    private void setDeck(Deck deck ){
        this.deck = deck;
    }

    //Methods
    public String toString(){
        return "joueur : "+this.pseudo+"  "+this.getHeros()+ "  "+deck.toString();
    }
    public void finirTour() {

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
}
