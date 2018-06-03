package jeu.Capacites.CapacitesRexxar;

import jeu.Capacites.Charge;
import jeu.Capacites.InvocationDeServiteur;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public final class Chiens extends InvocationDeServiteur {


    public Chiens() throws HearthstoneException {
        super("Invocation de Chiens", "Invoque autant de chien qu'il n'y a de serviteurs adversaires",
                new Serviteur(Plateau.getInstance().getJoueurCourant(),"Chien",0 ,1,1, new Charge())
                , Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().size());
    }

}
