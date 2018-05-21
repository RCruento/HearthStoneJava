package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Plateau.Plateau;

public class Golemisation extends InvocationDeServiteur {
    public Golemisation() {
        super("Aucune", null, new Serviteur(Plateau.getInstance().getJoueurCourant(), "Golem endomagé",2,1), 1);
    }
}
