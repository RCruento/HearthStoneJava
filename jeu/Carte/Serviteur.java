package jeu.Carte;

import jeu.Capacite.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Joueur.IJoueur;
import jeu.Joueur.Joueur;

public class Serviteur extends Carte {
    private int attaque;
    private int sante;
    private boolean endormis = true;
    private boolean vivant = true;
    private ICapacite capacite;


    //Constructor
    public Serviteur(IJoueur propietaire, String nom, int cout, int attauque, int sante, ICapacite capacite) {
        super(propietaire, nom, cout);
        this.attaque = attauque;
        this.sante = sante;
        this.capacite = capacite;
    }

    public Serviteur(IJoueur propietaire, String nom, int cout, int attauque, int sante) {
        super(propietaire, nom, cout);
        this.attaque = attauque;
        this.sante = sante;
    }

    //Getter & Setter
    public int getAttauque() {
        return attaque;
    }

    public void setAttauque(int attauque) {
        this.attaque = attauque;
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

    @Override
    public boolean disparait() {
        if(this.sante <= 0){
            return true;
        }
        return false;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new IllegalArgumentException("Aucune cible a attaquer");
        }
        if(cible instanceof Heros || cible instanceof Serviteur){
            if(cible instanceof  Heros){
                Heros herocible = (Heros) cible;
                if(serviteurAvecProvocationPlateau()){
                    throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                }
                herocible.setHealt(herocible.getHealt() - this.attaque);
            }
            if(cible instanceof Serviteur){
                Serviteur serviteurcible = (Serviteur) cible;
                if(serviteurAvecProvocationPlateau()){
                    if(serviteurcible.capacite.getNom().equals("Provocation")){
                        serviteurcible.setSante(serviteurcible.getSante()-this.attaque);
                        this.sante = this.sante - serviteurcible.getAttauque();
                        if(serviteurcible.disparait()){
                            serviteurcible.setVivant(false);
                        }
                        if (this.disparait()){
                            this.setVivant(false);
                        }
                    }else{
                        throw new HearthstoneException("Serviteur avec provocation sur le plateau")
                    }
                }else{
                    serviteurcible.setSante(serviteurcible.getSante()-this.attaque);
                    this.sante = this.sante - serviteurcible.getAttauque();
                    if(serviteurcible.disparait()){
                        serviteurcible.setVivant(false);
                    }
                    if (this.disparait()){
                        this.setVivant(false);
                    }
                }
            }
        }

    }

    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDebutTour(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTour(Object cible) throws HearthstoneException {

    }
}
