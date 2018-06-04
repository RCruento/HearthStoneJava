package jeu.Application;

import jeu.Capacites.*;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Interface.*;
import jeu.Plateau.IPlateau;
import jeu.Plateau.Plateau;
import jeu.Joueur.IJoueur;
import jeu.Joueur.Joueur;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Main, permet de lancer le programme
 * @author Rayan KOUSSA
 */
public class Main {
    public static Interface ihm = null;

    public static void main(String[] args) throws HearthstoneException {

        IPlateau plateau = Plateau.getInstance();

        Heros Jaina = new Heros("Jaina",
                new AttaqueCiblee("Boule de feu", "Inflige 1 de degat au personnage ciblé", 1));

        Heros Rexxar = new Heros("Rexxar",
                new AttaqueDuHeros("Tir Assuré", "Inflige 2 points de degats au heros adverse", 2));

        IJoueur Ray = new Joueur("Rayan", Jaina);
        IJoueur Demos = new Joueur("Demos", Rexxar);

        plateau.ajouterJoueur(Ray);
        plateau.ajouterJoueur(Demos);
        plateau.setJoueurCourant(Ray);

        plateau.demarerPartie();


        // Création menu
        ihm = initialiaserInterface();

        if (ihm == null) {
            System.out.println("L'application ne sais rien faire....");
            System.exit(0);
        }

        while (plateau.estDemaree()) {

            System.out.println(plateau.toString());
            String choix = menu();
            try {
                ihm.interagir(choix, plateau);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static String menu () {
        ArrayList<String> menu = new ArrayList<String>();
        Interface i = ihm;


        while (i != null) {
            menu.add(i.getDescription());
            i = i.getSuivant();
        }

        int n = 0;
        for (String s : menu) {
            System.out.println("[" + n + "] " + s);
            n++;
        }

        System.out.println("Votre choix --> ");
        Scanner sc = new Scanner(System.in);
        int choix;
        try {
            choix = sc.nextInt();
            return menu.get(choix);
        } catch (Exception e) {
            return menu();
        }
    }




    public static Interface initialiaserInterface () {
        Interface monInterface = null;
        monInterface = new InterfaceQuitterLeJeu(monInterface);
        monInterface = new InterfaceUtiliserPouvoirHero(monInterface);
        monInterface = new InterfaceUtiliserCarteEnJeu(monInterface);
        monInterface = new InterfaceJouerCarte(monInterface);
        monInterface = new InterfaceFinirTour(monInterface);

        return monInterface;
    }
}

