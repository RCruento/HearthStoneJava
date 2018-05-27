package jeu.Player;

import jeu.Capacites.*;
import jeu.Capacites.CapacitesJaina.*;
import jeu.Capacites.CapacitesRexxar.*;
import jeu.Carte.Carte;
import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.IPlateau;
import jeu.Plateau.Plateau;

import java.util.ArrayList;
import java.util.Random;

public class Joueur implements IJoueur {
    private String pseudo;
    private Heros heros;
    private int mana = 100;
    private int stockMana = 100;
    private ArrayList<ICarte> deck = new ArrayList<>();
    private ArrayList<ICarte> cartesMain= new ArrayList<>();
    private ArrayList<ICarte> cartesEnJeu = new ArrayList<>();

    //Constructor
    public Joueur(String pseudo, Heros heros)  {
        this.pseudo = pseudo;
        this.heros=heros;
    }

    //Getter & Setter
        //Getter
    public String getPseudo(){
        return this.pseudo;
    }

    public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException {
        for (ICarte carte : this.cartesEnJeu) {
            if(cartesEnJeu.contains(carte)){
                return carte;
            }
        }
        throw new HearthstoneException("Carte n'est pas dans la main");
    }

    public ICarte getCarteEnMain(String carteMain) throws HearthstoneException {
        for (ICarte carte : this.cartesMain) {
            if(cartesMain.contains(carte)){
                return carte;
            }
        }
        throw new HearthstoneException("Carte n'est pas dans la main");
    }

    public Heros getHeros() {
        return this.heros ;
    }

    public int getMana() {
        return this.mana;
    }

    public int getStockMana() {
        return this.stockMana;
    }

    public ArrayList<ICarte> getDeck() {
        return deck;
    }

    public ArrayList<ICarte> getMain() {
        return this.cartesMain;
    }

    public ArrayList<ICarte> getJeu() {
        return this.cartesEnJeu;
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
            this.stockMana = stock;
        }else {
            throw new IllegalArgumentException("Erreur stock");
        }
    }

    public void setDeck(ArrayList<ICarte> deck) {
        this.deck = deck;
    }

    public void setCartesMain(ArrayList<ICarte> cartesMain) {
        this.cartesMain = cartesMain;
    }

    public void setCartesEnJeu(ArrayList<ICarte> cartesEnJeu) {
        this.cartesEnJeu = cartesEnJeu;
    }

        //ArrayListe Deck

    public void addCarteDeck(ICarte a)   {

        this.deck.add(a);

    }

    public void delCarteDeck(ICarte carte)  {
        this.deck.remove(carte);
    }

    public int getsizeDeck(){
        return deck.size();
    }

        //ArrayList CarteMain

    public void addCarteMain(ICarte a)   {

                this.cartesMain.add(a);

    }

    public void delCarteMain(ICarte carte)  {
        cartesMain.remove(carte);
    }

    public int getsizeCarteMain(){
        return cartesMain.size();
    }

        //ArrayList CarteJeu
    public void addCarteJeu(ICarte a)   {
            this.cartesEnJeu.add(a);

    }

    public void delCarteJeu(ICarte carte)  {
        cartesEnJeu.remove(carte);
    }

    public int getsizeCarteJeu(){
        return cartesEnJeu.size();
    }

    //Methods

    public void ajouterMana(){
        if(this.stockMana< MAX_MANA) {
            this.stockMana = this.stockMana+1;
            this.mana = stockMana;
        }else{
            this.mana = 10;
        }
    }

    public String afficherDeck(){
        String res="Deck : [ { \n";
        for(int i=0;i<this.deck.size();i++)
        {
            res+= "              "+"N°"+i+" "+this.deck.get(i)+"\n";
        }
        return res+="              "+"}]\n";
    }

    public String afficherMain(){
        String res="Main : [ { \n";
        for(int i=0;i<this.cartesMain.size();i++)
        {
            res+= "              "+"N°"+i+" "+this.cartesMain.get(i)+"\n";
        }
        return res+="              "+"}]\n";
    }

    public String afficherJeu(){
        String res="Jeu : [ { \n";
        for(int i=0;i<this.cartesEnJeu.size();i++)
        {
            res+= "              "+"N°"+i+" "+this.cartesEnJeu.get(i)+"\n";
        }
        return res+="              "+"}]\n";
    }

    public void finirTour() throws HearthstoneException {
        for (ICarte carte : this.cartesEnJeu) {
            carte.executerEffetFinTour();
        }
    }

    public void jouerCarte(ICarte carte) throws HearthstoneException {
        if (carte == null) {
            throw new IllegalArgumentException("Aucune carte");
        }
        if (!cartesMain.contains(carte)) {
            throw new IllegalArgumentException(" Carte non en main");
        }
        if (this.mana < carte.getCout()) {
            throw new HearthstoneException("Pas assez de mana");
        }
        if (cartesMain.contains(carte)) {
            System.out.println(carte.getNomCarte());
            setMana(this.mana - carte.getCout());
            this.getJeu().add(carte);
            this.getMain().remove(carte);
            carte.executerEffetDebutMiseEnJeu(carte);
        }

    }

    public void perdreCarte(ICarte carte) throws HearthstoneException {
        if(cartesEnJeu.contains(carte)){
            delCarteJeu(carte);
        }
        throw new HearthstoneException("Carte non sur le plateau");
    }

    public void piocher() {
        Random rd = new Random();
        int alea = rd.nextInt(this.deck.size());
        addCarteMain(deck.get(alea));
        delCarteDeck(deck.get(alea));
    }

    public void prendreTour() {
        this.piocher();
        Plateau.getInstance().setJoueurCourant(this);

    }

    public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
        if(cartesEnJeu.contains(carte)){
            ((Serviteur)carte).executerAction(cible);
        }
    }

    public void utiliserPouvoir(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new HearthstoneException("Aucune cible");
        }
        heros.getPouvoir().executerAction(cible);

    }

    public String toString(){
        return "Joueur : "+this.pseudo+"; mana = "+this.mana+"  "+this.getHeros()+"\n"+ /*afficherDeck()+*/"\n"+afficherMain()+"\n";
    }

}
