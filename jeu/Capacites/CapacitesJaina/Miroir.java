package jeu.Capacites.CapacitesJaina;

import jeu.Capacites.InvocationDeServiteur;
import jeu.Capacites.Provocation;
import jeu.Carte.Serviteur;
import jeu.Plateau.Plateau;


public final class Miroir extends InvocationDeServiteur {
    public Miroir() {
        super("Image miroir", "Invoque 2 Serviteur de Jaina 0/2 avec provocation", new Serviteur( Plateau.getInstance().getJoueurCourant(),"Serviteur de Jaina", 0, 0,2, new Provocation()), 2);
    }
}
