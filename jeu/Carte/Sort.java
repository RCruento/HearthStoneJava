package jeu.Carte;

import jeu.Capacites.AttaqueCiblee;
import jeu.Capacites.ICapacite;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import jeu.Player.IJoueur;

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

    @Override
    public boolean disparait() {
        return false;
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if(this.capacite instanceof AttaqueCiblee) {
            if (cible instanceof Heros) {
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
                        herocible.blesserHero(((AttaqueCiblee)this.getCapacite()).getDegat());
                        Plateau.getInstance().getJoueurCourant().getJeu().remove(this);
                    }
                    if (cible instanceof Serviteur) {
                        Serviteur serviteurcible = (Serviteur) cible;
                        if (serviteurcible.getProvocation()) {
                            serviteurcible.blesserServiteur(((AttaqueCiblee)this.getCapacite()).getDegat());
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
                            serviteurcible.blesserServiteur(((AttaqueCiblee)this.getCapacite()).getDegat());
                            if (serviteurcible.disparait()) {
                                System.out.println(serviteurcible.getNomCarte() + "ciblé est mort");
                                Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(serviteurcible);
                            }

                        }
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
        this.capacite.executerEffetFinTour();

    }


    @Override
    public void executerEffetFinTour() {

    }

    @Override
    public String toString() {
        return "Sort{"+ this.getNomCarte() +" , Mana : "+this.getCout()+" , "+
                capacite +
                '}';
    }
}
