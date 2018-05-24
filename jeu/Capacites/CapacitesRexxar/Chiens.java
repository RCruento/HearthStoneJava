package jeu.Capacites.CapacitesRexxar;

import javafx.print.PageLayout;
import jeu.Capacites.Charge;
import jeu.Capacites.InvocationDeServiteur;
import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public final class Chiens extends InvocationDeServiteur {


    public Chiens() throws HearthstoneException {
        super("Invocation des chiens", "Invoque autant de chiens qu'il y a de carte sur le plateau",
                new Serviteur(Plateau.getInstance().getJoueurCourant(),"Chiens",0 ,1,1, new Charge()),
                Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().size());
    }
}
