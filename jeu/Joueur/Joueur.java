package jeu.Joueur;

import jeu.Capacites.*;
import jeu.Capacites.CapacitesJaina.IntelligenceDesArcanes;
import jeu.Capacites.CapacitesJaina.ImageMiroir;
import jeu.Capacites.CapacitesRexxar.BrusardAffame;
import jeu.Capacites.CapacitesRexxar.LachezLesChiens;
import jeu.Capacites.CapacitesRexxar.MarqueDuChasseur;
import jeu.Carte.Carte;
import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Joueur sert a representer un joueur
 * @author Rayan Koussa
 * @version  0.1
 *
 */
public class Joueur implements IJoueur {
    private String pseudo;
    private Heros heros;
    private int mana = 10;
    private int stockMana = 10;
    private ArrayList<ICarte> deck = new ArrayList<>();
    private ArrayList<ICarte> cartesMain= new ArrayList<>();
    private ArrayList<ICarte> cartesEnJeu = new ArrayList<>();

    //Constructor
    public Joueur(String pseudo, Heros heros) throws HearthstoneException {
        this.setPseudo(pseudo);
        this.setHeros(heros);
        /* Ne meme temps que je crée un joueur
                je lui crée son deck
         */
        if(this.heros.getNomHeros().equals("Jaina")){
            //Carte propre a Jaina
            ICarte CSoJ1 = new Sort(this, "Choc de flamme", 7,
                    new AttaqueTotale("Attaque massive", "Inflige 4 points de degats à tous les adversaires", 4));
            ICarte CSoJ2 = new Sort(this, "Eclaire de givre", 2,
                    new AttaqueCiblee("Attaque du givre", "Inflige 3 points de degats au personnage ciblé", 3));
            ICarte CSoJ3 = new Sort(this, "Intelligence des Arcanes", 2,
                    new IntelligenceDesArcanes());
            ICarte CSoJ4 = new Sort(this, "Image mirroir", 1,
                    new ImageMiroir());
            ICarte CSoJ5 = new Sort(this, "Explosion pyrotechnique", 10,
                    new AttaqueCiblee("Explosion pyrotechniqye", "Inflige 10 point de degats au personnage ciblé", 10));
            this.addCarteDeck(CSoJ1);
            this.addCarteDeck(CSoJ2);
            this.addCarteDeck(CSoJ3);
            this.addCarteDeck(CSoJ4);
            this.addCarteDeck(CSoJ5);
        }
        if(this.heros.getNomHeros().equals("Rexxar")){
            //Carte Propre a Rexxar
            ICarte CSeR = new Serviteur(this, "Busard affamé", 5, 3, 2, new BrusardAffame());
            ICarte CSoR1 = new Sort(this, "Tir des Arcane", 1,
                    new AttaqueCiblee("Tir des arcanes", "Inflige 2 points de degats au personnage ciblé", 2));
            ICarte CSoR2 = new Sort(this, "Marque du chasseur", 1,
                    new MarqueDuChasseur());
            ICarte CSoR3 = new Sort(this, "Lâchez les chiens", 3,
                    new LachezLesChiens());
            ICarte CSoR5 = new Sort(this, "Ordre de tuer", 3,
                    new AttaqueCiblee("Ordre de tuer", "Inflige 3 points de degats au personnage ciblé", 3));
            this.addCarteDeck(CSeR);
            this.addCarteDeck(CSoR1);
            this.addCarteDeck(CSoR2);
            this.addCarteDeck(CSoR3);
            this.addCarteDeck(CSoR5);
        }
            /*Cartes Communes
                aux deux joueurs
             */
        Carte CSo1 = new Sort(this, "Charge", 1, new Charge());
        Carte CSo2 = new Sort(this, "Attaque mentale", 2,
                new AttaqueDuHeros("Attaque mentale", "Inflige 5 points de degats au heros", 5));
        Carte CSe1 = new Serviteur(this, "Chasse-marée murloc", 2, 2, 1,
                new CriDeGuerre());
        Carte CSe2 = new Serviteur(this, "Champion de Hurlevent", 7, 6, 6,
                new BonusDeHurlevent());
        Carte CSe3 = new Serviteur(this, "Chef de raid", 3, 2, 2,
                new BonusDuChefDeRaid());
        Carte CSe4 = new Serviteur(this, "Garde de Baie-du-butin", 5, 5, 4,
                new Provocation());
        Carte CSe5 = new Serviteur(this, "La missilière téméraire", 6, 5, 2,
                new Charge());
        Carte CSe6 = new Serviteur(this, "L'ogre-magi", 4, 4, 4,
                new Provocation());
        Carte CSe7 = new Serviteur(this, "Archimage", 6, 4, 7,
                new Provocation());
        Carte CSe8 = new Serviteur(this, "Golem des moissons", 4, 4, 4,
                new Golemisation());

        this.addCarteDeck(CSo1);
        this.addCarteDeck(CSo2);
        this.addCarteDeck(CSe1);
        this.addCarteDeck(CSe2);
        this.addCarteDeck(CSe3);
        this.addCarteDeck(CSe4);
        this.addCarteDeck(CSe5);
        this.addCarteDeck(CSe6);
        this.addCarteDeck(CSe7);
        this.addCarteDeck(CSe8);
    }

    //Getter & Setter

    public String getPseudo(){
        return this.pseudo;
    }

    public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException {
        for (ICarte carte : this.cartesEnJeu) {
            if(cartesEnJeu.contains(carte)){
                return carte;
            }
        }
        throw new HearthstoneException("Nom incorrecte. Carte introuvable sur le plateau");
    }

    public ICarte getCarteEnMain(String carteMain) throws HearthstoneException {
        for (ICarte carte : this.cartesMain) {
            if(cartesMain.contains(carte)){
                return carte;
            }
        }
        throw new HearthstoneException("Nom incorrecte. Carte n'est pas en main");
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

    //Methods

        //ArrayListe Deck

    /**
     *Ajoute des cartes au deck du joueur
     * @param carte
     */
    public void addCarteDeck(ICarte carte)   {
        if(getsizeDeck()<= TAILLE_DECK) {
            this.deck.add(carte);
        }

    }

    /**
     * Supprime une carte du deck
     * @param carte
     */
    public void delCarteDeck(ICarte carte)  {
        this.deck.remove(carte);
    }

    /**
     * Permet de connaitre le nombre de carte dans le deck
     * @return int
     */
    public int getsizeDeck(){
        return deck.size();
    }

        //ArrayList CarteMain

    /**
     * permet d'ajouter des cartes a la main
     * @param carte
     */
    public void addCarteMain(ICarte carte)   {
        this.cartesMain.add(carte);
    }

    /**
     * Supprime des cartes de la main
     * @param carte
     */
    public void delCarteMain(ICarte carte)  {
        cartesMain.remove(carte);
    }

    /**
     * Permet de connaitre combien de cartes on a en main
     * @return
     */
    public int getsizeCarteMain(){
        return cartesMain.size();
    }

        //ArrayList CarteJeu

    /**
     * Ajoute des cartes au plateau
     * @param carte
     */
    public void addCarteJeu(ICarte carte)   {
            this.cartesEnJeu.add(carte);

    }

    /**
     * Supprime des cartes du plateau
     * @param carte
     */
    public void delCarteJeu(ICarte carte)  {
        cartesEnJeu.remove(carte);
    }

    /**
     * Permet de connaitre combien de cartes il y a sur le plateau
     * @return int
     */
    public int getsizeCarteJeu(){
        return cartesEnJeu.size();
    }

    /**
     * Permet d'ajouter du manan a chaque debut de tour du joueur
     */
    public void ajouterMana(){
        if(this.stockMana< MAX_MANA) {
            this.stockMana = this.stockMana+1;
            this.mana = stockMana;
        }else{
            this.mana = 10;
            this.stockMana = 10;
        }
    }

    /**
     * Affiche le deck du jouer
     * @return String ( chaine de carractères)
     */
    public String afficherDeck(){
        String res="Deck : [ { \n";
        for(int i=0;i<this.deck.size();i++)
        {
            res+= "              "+"N°"+i+" "+this.deck.get(i)+"\n";
        }
        return res+="              "+"}]\n";
    }

    /**
     * Affiche les cartes en main du joueur
     * @return String (chaine de carractères)
     */
    public String afficherMain(){
        String res="Main : [ { \n";
        for(int i=0;i<this.cartesMain.size();i++)
        {
            res+= "              "+"N°"+i+" "+this.cartesMain.get(i)+"\n";
        }
        return res+="              "+"}]\n";
    }

    /**
     * Affiche les cartes sur le plateau
     * @return String (chaine de carractères)
     */
    public String afficherJeu(){
        String res="Jeu : [ { \n";
        for(int i=0;i<this.cartesEnJeu.size();i++)
        {
            res+= "              "+"N°"+i+" "+this.cartesEnJeu.get(i)+"\n";
        }
        return res+="              "+"}]\n";
    }

    /**
     * Permet au jouer de selectionner une carte dans ça main et de la jouer
     * @param carte
     * @throws HearthstoneException
     *
     */
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
            setMana(this.mana - carte.getCout());
            this.addCarteJeu(carte);
            this.delCarteMain(carte);
            carte.executerEffetDebutMiseEnJeu(carte);
        }
    }

    /**
     * Supprime une carte de la main si elle est jouée ou supprime une carte du plateau si elle disparait
     * @param carte
     * @throws HearthstoneException
     *
     */
    public void perdreCarte(ICarte carte) throws HearthstoneException {
        if(cartesEnJeu.contains(carte)){
            if(carte.disparait()) {
                this.delCarteJeu(carte);
            }
        }else{
            if(cartesMain.contains(carte)){
                this.delCarteMain(carte);
            }
        }
        throw new HearthstoneException("Carte non sur le plateau");
    }

    /**
     * Permet à un joueur a chaque debut de tour de piocher
     */
    public void piocher() {
        if(this.deck.size() != 0) {
            Random rd = new Random();
            int alea = rd.nextInt(this.deck.size());
            addCarteMain(deck.get(alea));
            delCarteDeck(deck.get(alea));
        }
    }

    /**
     * Permet a un joueur de prendre son tour apres que son adversaire aie choisit de finir le sien
     */
    public void prendreTour() {
        Plateau.getInstance().setJoueurCourant(this);
        this.ajouterMana();
        this.piocher();
    }

    /**
     * Permet a un joueur de passer son tour de jeu
     * @throws HearthstoneException
     *
     */
    public void finirTour() throws HearthstoneException {
        for (ICarte carte : this.cartesEnJeu) {
            if(((Serviteur)carte).getCapacite() != null) {
                carte.executerEffetFinTour();
            }
        }
        for(ICarte carteS : this.getJeu()){
            ((Serviteur)carteS).reveiller();
        }
    }

    /**
     * Permet au joueur de selectionner une carte sur le plateau et d'attaquer une cible
     * @param carte carte sur le plateau
     * @param cible cible a attaquer
     * @throws HearthstoneException
     *
     */
    public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
        if(cartesEnJeu.contains(carte)){
            ((Serviteur)carte).executerAction(cible);
        }
        if(cartesMain.contains(carte)){
            if(carte instanceof Sort){

            }
        }
    }

    /**
     * Permet au joueur d'ultiliser le pouvoir de son Heros
     * @param cible qui peut etre un serviteur ou l'adversaire
     * @throws HearthstoneException
     *
     */
    public void utiliserPouvoir(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new HearthstoneException("Aucune cible");
        }
        heros.getPouvoir().executerAction(cible);

    }

    /**
     *  Affiche la classe Joueur
     * @return String (chaine de caractère)
     */
    public String toString(){
        return "Joueur : "+this.pseudo+"; mana = "+this.mana+"  "+this.getHeros()+"\n"+ /*afficherDeck()+*/"\n"+afficherMain()+"\n";
    }

}
