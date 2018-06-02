package jeu.Carte;


import jeu.Capacites.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import jeu.Player.IJoueur;

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


    public void reveiller(){
        this.attaquer = true;
    }
    public void blesserServiteur(int degat){
        this.sante = this.sante - degat;
    }

    public void bonusSante(int bonus){
        this.sante += bonus;
    }

    public void bonusAttaque(int bonus){
        this.attaque += bonus;
    }

    @Override
    public boolean disparait() {
        if(this.sante <= 0){
            return true;
        }
        return false;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if (cible == null) {
            throw new IllegalArgumentException("Aucune cible a attaquer");
        }
        if (this.attaquer) {
            System.out.println("je suis dans la boucle if endormis");
            if (cible instanceof Heros) {
                Heros herocible = (Heros) cible;
                for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
                    if (((Serviteur) carte).getProvocation()) {
                        throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                    }
                }
                herocible.blesserHero(this.attaque);
                if (herocible.mort()) {
                    plateau.gagnerPartie(plateau.getJoueurCourant());
                }
            }
            if (cible instanceof Serviteur) {
                Serviteur serviteurcible = (Serviteur) cible;
                if (serviteurcible.getProvocation()) {
                    serviteurcible.blesserServiteur(this.attaque);
                    this.blesserServiteur(serviteurcible.getAttaque());
                    if (serviteurcible.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort");
                        plateau.getAdversaire(plateau.getJoueurCourant()).getJeu().remove(serviteurcible);
                    }
                    if (this.disparait()) {
                        System.out.println("Votre serviteur" + this.getNomCarte() + "est mort");
                        plateau.getJoueurCourant().getJeu().remove(this);
                    }
                } else {
                    for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
                        if (((Serviteur) carte).getProvocation()) {
                            throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                        }
                    }
                    serviteurcible.blesserServiteur(this.attaque);
                    this.blesserServiteur(serviteurcible.getAttaque());
                    if (serviteurcible.disparait() || this.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort\n");
                        plateau.getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                        System.out.println("Votre serviteur" + this.getNomCarte() + "est mort\n");
                        plateau.getJoueurCourant().getJeu().remove(this);
                    }
                }
            }
        }
        throw new HearthstoneException("Serviteur endormis attendez un tour");
    }


    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
        this.capacite.executeEffetMiseEnjeu(this);
    }

    @Override
    public void executerEffetDebutTour(Object cible) throws HearthstoneException {
        this.capacite.executerEffetDebutTour();
    }

    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {
        this.capacite.executeEffetDisparition(this);
    }

    @Override
    public void executerEffetFinTour(Object cible) throws HearthstoneException {
        this.capacite.executerEffetFinTour();
    }

    @Override
    public void executerEffetFinTour() throws HearthstoneException {

    }


    @Override
    public String toString() {
        return "Serviteur{"+ this.getNomCarte() +", Mana : "+this.getCout()+
                ", attaque : " + attaque +
                ", sante : " + sante +
                ", "+ capacite +
                '}';
    }
}
