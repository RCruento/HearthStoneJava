package jeu.Carte;


import jeu.Capacites.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import jeu.Player.IJoueur;

public class Serviteur extends Carte {
    private int attaque;
    private int sante;
    private boolean endormis = true;
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

    public void setAttaque(int attauque) {
        this.attaque = attaque;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public boolean getEndormis() {
        return endormis;
    }

    public boolean getVivant(){
        return this.vivant;
    }

    public void setVivant(boolean vivant){
        this.vivant = vivant;
    }

    public void setEndormis(boolean endormis) {
        this.endormis = endormis;
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
        if (cible == null) {
            throw new IllegalArgumentException("Aucune cible a attaquer");
        }
        if (cible instanceof Heros || cible instanceof Serviteur) {
            if (cible instanceof Heros) {
                Heros herocible = (Heros) cible;
                for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                        ) {
                    if (((Serviteur) carte).getProvocation()) {
                        throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                    }

                }
                herocible.setHealt(herocible.getHealt() - this.attaque);
            }
            if (cible instanceof Serviteur) {
                Serviteur serviteurcible = (Serviteur) cible;
                if (serviteurcible.getProvocation()) {
                    serviteurcible.blesserServiteur(this.attaque);
                    this.blesserServiteur(serviteurcible.getAttaque());
                    if (serviteurcible.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort");
                        Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                    }
                    if (this.disparait()) {
                        System.out.println("Votre serviteur" + this.getNomCarte() + "est mort");
                        Plateau.getInstance().getJoueurCourant().getJeu().remove(this);
                    }
                } else {
                    for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                            ) {
                        if (((Serviteur) carte).getProvocation()) {
                            throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                        }
                    }
                    serviteurcible.blesserServiteur(this.attaque);
                    this.blesserServiteur(serviteurcible.getAttaque());
                    if (serviteurcible.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort");
                        Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                    }
                    if (this.disparait()) {
                        System.out.println("Votre serviteur" + this.getNomCarte() + "est mort");
                        Plateau.getInstance().getJoueurCourant().getJeu().remove(this);
                    }
                }
            }
        }
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
        this.capacite.executerEffetFinTor();

    }

    @Override
    public void executerEffetFinTour() throws HearthstoneException {
        this.capacite.executerEffetFinTor();

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
