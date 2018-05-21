package jeu.Capacites.CapacitesRexxar;

import jeu.Capacites.Charge;
import jeu.Capacites.InvocationDeServiteur;
import jeu.Carte.Serviteur;
import jeu.Plateau.Plateau;

public final class Chiens extends InvocationDeServiteur {

    public Chiens() {
        super("Invocation des chiens", "Invoque autant de chiens qu'il y a de carte sur le plateau",
                new Serviteur(Plateau.getInstance().getJoueurCourant(),"Chiens",0 ,1,1, new Charge()),1);
    }

}
