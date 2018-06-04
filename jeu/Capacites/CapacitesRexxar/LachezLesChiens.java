package jeu.Capacites.CapacitesRexxar;

import jeu.Capacites.Charge;
import jeu.Capacites.InvocationDeServiteur;
import jeu.Carte.Serviteur;
import jeu.Plateau.Plateau;

/**
 * Classe LachezLesChiens qui represente un capactié d'invocation
 * Hérite de InvocationDeServiteur
 * @author Rayan KOUSSA
 * @version 0.1
 * @see InvocationDeServiteur
 */
public final class LachezLesChiens extends InvocationDeServiteur {


    public LachezLesChiens() {
        super("Invocation de Chiens", "Invoque autant de chien qu'il n'y a de serviteurs adversaires",
                new Serviteur(Plateau.getInstance().getJoueurCourant(),"Chien",0 ,1,1, new Charge())
                ,// Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().size()
                3 );
    }

}
