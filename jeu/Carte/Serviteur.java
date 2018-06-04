package jeu.Carte;


import jeu.Capacites.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import jeu.Joueur.IJoueur;
/**
 * Classe Serviteur sert a representer un serviteur, celle-ci hérite de Carte
 * @author Rayan Koussa
 * @version  0.1
 * @see Carte
 */

public class Serviteur extends Carte {
    private int attaque;
    private int sante;
    private boolean attaquer = false;
    private boolean vivant = true;
    private boolean provocation = false;
    private ICapacite capacite;


    //Constructor
    public Serviteur(IJoueur propietaire, String nom, int cout, int attaque, int sante, ICapacite capacite) {
        super(propietaire, nom, cout);
        this.attaque = attaque;
        this.sante = sante;
        this.setCapacite(capacite);
    }

    public Serviteur(IJoueur propietaire, String nom, int attauque, int sante) {
        super(propietaire, nom);
        this.attaque = attauque;
        this.sante = sante;
    }

    //Getter & Setter
    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public boolean getAttaquer() {
        return attaquer;
    }

    public boolean getVivant(){
        return this.vivant;
    }

    public void setVivant(boolean vivant){
        this.vivant = vivant;
    }

    public void setAttaquer(boolean endormis) {
        this.attaquer = endormis;
    }

    public ICapacite getCapacite() {
        return capacite;
    }

    public void setCapacite(ICapacite capacite) {
        this.capacite = capacite;
    }

    public boolean getProvocation() {
        return provocation;
    }

    public void setProvocation(boolean provocation) {
        this.provocation = provocation;
    }



    // Methods

    /**
     * Permet a un serviteur de pouvoir attaquer apres la fin du temps d'attente
     *
     * @return void
     *
     */
    public void reveiller(){
        this.attaquer = true;
    }

    /**
     * Le serviteur subis les degats d'un serviteur adverse
     * @param degat
     *
     */
    public void blesserServiteur(int degat){
        this.sante = this.sante - degat;
    }

    /**
     * Le serviteur reçoit un bonus santé equivalent au parametre
     * @param bonus
     *
     */
    public void bonusSante(int bonus){
        this.sante += bonus;
    }

    /**
     * Le serviteur reçoit un bonus d'attaque equivalent au parametre
     * @param bonus
     */
    public void bonusAttaque(int bonus){
        this.attaque += bonus;
    }

    /**
     * Permet de savoir si un serviteur doit être enlevé du plateau ou non
     * @return true si les point de vie du serviteur = 0, false sinon
     *
     */
    @Override
    public boolean disparait() {
        if(this.sante <= 0){
            return true;
        }
        return false;
    }

    /**
     * Permet a un serviteur d'attaquer une cible
     * @param cible
     * @throws HearthstoneException en cas d'erreur sur la cible
     * @deprecated cibler doit etre different de {null, Plateau, Sort }
     */
    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if (cible == null) {
            throw new IllegalArgumentException("Aucune cible a attaquer");
        }
        if (this.attaquer) {

            if (cible instanceof Heros) {
                for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
                    if (((Serviteur) carte).getProvocation()) {
                        throw new HearthstoneException("Serviteur avec Provocation sur le plateau\n");
                    }
                }
                plateau.getAdversaire(plateau.getJoueurCourant()).getHeros().blesserHero(this.attaque);
                if ( plateau.getAdversaire(plateau.getJoueurCourant()).getHeros().mort()) {
                    plateau.gagnerPartie(plateau.getJoueurCourant());
                }
            }
            if (cible instanceof Serviteur) {
                Serviteur serviteurcible = (Serviteur) cible;
                if (serviteurcible.getProvocation()) {
                    serviteurcible.blesserServiteur(this.attaque);
                    this.blesserServiteur(serviteurcible.getAttaque());
                    this.attaquer = false;
                    if (serviteurcible.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort\n");
                        plateau.getAdversaire(plateau.getJoueurCourant()).getJeu().remove(serviteurcible);
                    }
                    if (this.disparait()) {
                        System.out.println("Votre serviteur" + this.getNomCarte() + "est mort\n");
                        plateau.getJoueurCourant().getJeu().remove(this);
                    }
                } else {
                    for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
                        if (((Serviteur) carte).getProvocation()) {
                            throw new HearthstoneException("Serviteur avec Provocation sur le plateau\n");
                        }
                    }
                    serviteurcible.blesserServiteur(this.attaque);
                    this.attaquer = false;
                    this.blesserServiteur(serviteurcible.getAttaque());
                    if (serviteurcible.disparait() ) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort\n");
                        plateau.getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                    }
                    if (this.disparait()){
                        System.out.println("Votre serviteur" + this.getNomCarte() + "est mort\n");
                        plateau.getJoueurCourant().getJeu().remove(this);
                    }
                }
            }
        }else{
            throw new HearthstoneException("Serviteur endormis attendez un tour");
        }
    }

    /**
     * Permet d'executer la capacité d'un serviteur au debut du tour
     */
    @Override
    public void executerEffetDebutTour() {

    }


    /**
     * Execute la capacité d'un serviteur dès ça mise en jeu
     * @param cible le serviteur lui meme
     * @throws HearthstoneException
     * @deprecated Eviter d'utiliser une capacité nulle
     */
    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
        this.capacite.executeEffetMiseEnjeu(this);
    }

    /**
     *Execute la capacité d'un serviteur au début du tour
     * @param cible le serviteur lui meme
     * @throws HearthstoneException
     * @deprecated Eviter d'utiliser une capacité nulle
     */
    @Override
    public void executerEffetDebutTour(Object cible) throws HearthstoneException {
        this.capacite.executerEffetDebutTour();
    }

    /**
     *Execute la capacité du serviteur à ça mort
     * @param cible
     * @throws HearthstoneException
     * @deprecated Eviter d'utiliser une capacité nulle
     */
    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {
        this.capacite.executeEffetDisparition(this);
    }

    /**
     *Execute la capacité du serviteur a la fin du tour
     * @throws HearthstoneException
     */
    @Override
    public void executerEffetFinTour() throws HearthstoneException {

    }

    /**
     * Permet d'afficher la classe Serviteur
     * @return chaine de caractère
     */
    @Override
    public String toString() {
        return "Serviteur{"+ this.getNomCarte() +", Mana : "+this.getCout()+
                ", attaque : " + attaque +
                ", sante : " + sante +
                ", "+ capacite +
                '}';
    }
}
