package jeu;

import jeu.Heros.Heros;
import jeu.Joueur.IJoueur;
import jeu.Joueur.Joueur;


public class Main {

    public static void main(String[] args) {
        Heros Jaina = new Heros("Rexxar", new jeu.Capacites.Charge());
        IJoueur Ray = new Joueur("Zénon", Jaina);

        System.out.print(Ray.toString());
        System.out.print("\n je suis ici \n");

        Heros Rexxar = new Heros("Jaina", new jeu.Capacites.Provocation());
        IJoueur Demos = new Joueur("Demos", Jaina);

        System.out.print(Ray.toString());
        System.out.print("\n je suis ici \n");

    }
}
