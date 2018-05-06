package jeu;

import java.util.ArrayList;

public class Joueur implements IJoueur{
    private String pseudo;
    private Deck deck;
    private boolean joue = false; // = à 1 au premier joueur à 0 au second
    private ICarte carteMain;
    private ICarte carteEnJeu;

    //Constructor
    public Joueur(String pseudo, boolean joue){
        this.setPseudo(pseudo);
        this.setDeck(deck);
        this.setTour(joue);
    }

    //Getter & Setter

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo){this.pseudo = pseudo;}

    public void finirTour() {

    }


    public ICarte getCarteEnJeu() {
        return this.carteMain;
    }



    public ICarte getCarteEnMain() {
        return null;
    }


    public Heros getHeros() {
        return null;
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
    private void setDeck(Deck deck){
        if(deck == null){
            System.out.println("Parametre Vide");
            System.exit(1);
        }

        this.deck = deck;
    }

    //Methods


}
