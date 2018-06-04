package jeu.Carte;

import jeu.Capacites.AttaqueCiblee;
import jeu.Capacites.Capacite;
import jeu.Capacites.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import jeu.Joueur.IJoueur;

/**
 * Classe Sort represente une carte de type de Sort, celle-ci hérite de Carte
 * @author Rayan KOUSSA
 * @version 0.1
 */
public class Sort extends Carte {
    private ICapacite capacite;

    //Constructor
    public Sort(IJoueur propietaire, String nom, int cout, ICapacite capacite) {
        super(propietaire, nom, cout);
        this.capacite=capacite;
    }

    public ICapacite getCapacite() {
        return capacite;
    }

    public void setCapacite(ICapacite capacite) {
        this.capacite = capacite;
    }

    //Methdes

    /**
     * Verifie si la carte disparait
     * @return true si la carte a servis, false sinon
     */
    @Override
    public boolean disparait() {
        return ((Capacite)capacite).getServis();
    }

    /**
     * Si le sort est un sort de degat, la carte attaque une cible
     * @param cible serviteur sur le plateau ou Heros
     * @throws HearthstoneException
     *
     */
    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if (cible instanceof Heros) {
            if (cible == null) {
                throw new IllegalArgumentException("Aucune cible a attaquer");
            }
            if (cible instanceof Heros) {
                Heros herocible = (Heros) cible;
                for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                        ) {
                    if (((Serviteur) carte).getProvocation()) {
                        throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                    }
                }
                herocible.blesserHero(((AttaqueCiblee) this.getCapacite()).getDegat());
                Plateau.getInstance().getJoueurCourant().getJeu().remove(this);
            }
            if (cible instanceof Serviteur) {
                Serviteur serviteurcible = (Serviteur) cible;
                if (serviteurcible.getProvocation()) {
                    serviteurcible.blesserServiteur(((AttaqueCiblee) this.getCapacite()).getDegat());
                    if (serviteurcible.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort");
                        Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                    }
                } else {
                    for (ICarte carte : Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()
                            ) {
                        if (((Serviteur) carte).getProvocation()) {
                            throw new HearthstoneException("Serviteur avec Provocation sur le plateau");
                        }
                    }
                    serviteurcible.blesserServiteur(((AttaqueCiblee) this.getCapacite()).getDegat());
                    if (serviteurcible.disparait()) {
                        System.out.println(serviteurcible.getNomCarte() + "ciblé est mort");
                        Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                    }

                }
            }

        }
    }

    /**
     * Execute la capcité du sort au debut du tour
     */
    @Override
    public void executerEffetDebutTour() {

    }

    /**
     * Execute la capacité de sort des ça mise en jeu
     * @param cible la carte elle meme
     * @throws HearthstoneException
     *
     */
    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
            this.capacite.executeEffetMiseEnjeu(this);
    }

    /**
     * Execute la capacité du sort au début du tour
     * @param cible elle même
     * @throws HearthstoneException
     *
     */
    @Override
    public void executerEffetDebutTour(Object cible) throws HearthstoneException {
        this.capacite.executerEffetDebutTour();
    }

    /**
     * Ce cas n'arrive jamais
     */
    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {
        this.capacite.executeEffetDisparition(this);
    }

    /**
     *Ce cas n'arrive jamais
     */
    @Override
    public void executerEffetFinTour() throws HearthstoneException {
        this.capacite.executerEffetFinTour();
    }

    /**
     * Retourne les parametre de la classe Sort
     * @return String (chaine de caractères)
     */
    @Override
    public String toString() {
        return "Sort{"+ this.getNomCarte() +" , Mana : "+this.getCout()+" , "+
                capacite +
                '}';
    }
}
