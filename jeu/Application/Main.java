package jeu.Application;

import jeu.Capacites.CapacitesJaina.BouleDeFeu;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;
import jeu.Player.IJoueur;
import jeu.Player.Joueur;


public class Main {
    public static Console es = new Console();

    public static void main(String[] args) throws HearthstoneException {
        Heros Jaina = new Heros("Jaina", new BouleDeFeu());
        IJoueur Ray = new Joueur("Zénon", Jaina);
        Heros Rexxar = new Heros("Rexxar", new BouleDeFeu());
        IJoueur Demos = new Joueur("Demos", Rexxar);

        Plateau plateau = new Plateau(Ray, Demos);


        plateau.getJoueurCourant().utiliserCarte(plateau.getJoueurCourant().getCarteEnJeu("L'ogre-magi"), plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu("L'ogre-magi"));
        plateau.getJoueurCourant().jouerCarte("");
        es.println(plateau);







    }
}
