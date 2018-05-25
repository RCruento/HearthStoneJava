package jeu.Application;

import jeu.Capacites.*;
import jeu.Capacites.CapacitesJaina.IntelligenceDesArcanes;
import jeu.Capacites.CapacitesJaina.Miroir;
import jeu.Capacites.CapacitesRexxar.BrusardAffame;
import jeu.Capacites.CapacitesRexxar.Chiens;
import jeu.Capacites.CapacitesRexxar.MarqueDuChasseur;
import jeu.Capacites.CapacitesRexxar.OrdreDeTuer;
import jeu.Carte.Carte;
import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Interface.*;
import jeu.Plateau.IPlateau;
import jeu.Plateau.Plateau;
import jeu.Player.IJoueur;
import jeu.Player.Joueur;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static Console es = new Console();
    public static Interface ihm = null;

    public static void main(String[] args) throws HearthstoneException {

        IPlateau plateau = Plateau.getInstance();

        Heros Jaina = new Heros("Jaina",
                new AttaqueCiblee("Boule de feu", "Inflige 1 de degat au personnage ciblé", 1));

        Heros Rexxar = new Heros("Rexxar",
                new AttauqueDuHeros("Tir Assuré", "Inflige 2 points de degats au heros adverse", 2));

        IJoueur Ray = new Joueur("Rayan", Jaina);
        IJoueur Demos = new Joueur("Demos", Rexxar);


        plateau.ajouterJoueur(Ray);
        plateau.ajouterJoueur(Demos);
        plateau.setJoueurCourant(Ray);


        //Carte propre a Jaina
        ICarte CSoJ1 = new Sort(Ray, "Choc de flamme", 7,
                new AttauqueTotale("Attaque massive", "Inflige 4 points de degats à tous les adversaires", 4));
        ICarte CSoJ2 = new Sort(Ray, "Eclaire de givre", 2,
                new AttaqueCiblee("Attaque du givre", "Inflige 3 points de degats au personnage ciblé", 3));
        ICarte CSoJ3 = new Sort(Ray, "Intelligence des Arcanes", 2,
                new IntelligenceDesArcanes());
        ICarte CSoJ4 = new Sort(Ray, "Image mirroir", 1,
                new Miroir());
        ICarte CSoJ5 = new Sort(Ray, "Explosion pyrotechnique", 10,
                new AttaqueCiblee("Explosion pyrotechniqye", "Inflige 10 point de degats au personnage ciblé", 10));
        Ray.getDeck().add(CSoJ1);
        Ray.getDeck().add(CSoJ2);
        Ray.getDeck().add(CSoJ3);
        Ray.getDeck().add(CSoJ4);
        Ray.getDeck().add(CSoJ5);

        //Carte Propre a Rexxar
        ICarte CSeR = new Serviteur(Demos, "Busard affamé", 5, 3, 2, new BrusardAffame());
        ICarte CSoR1 = new Sort(Demos, "Tir des Arcane", 1,
                new AttaqueCiblee("Tir des arcanes", "Inflige 2 points de degats au personnage ciblé", 2));
        ICarte CSoR2 = new Sort(Demos, "Marque du chasseur", 1,
                new MarqueDuChasseur());
        ICarte CSoR3 = new Sort(Demos, "Lâchez les chiens", 3,
                new Chiens());
        ICarte CSoR5 = new Sort(Demos, "Ordre de tuer", 3,
                new OrdreDeTuer());
        Demos.getDeck().add(CSeR);
        Demos.getDeck().add(CSoR1);
        Demos.getDeck().add(CSoR2);
        Demos.getDeck().add(CSoR3);
        Demos.getDeck().add(CSoR5);

        //Carte Communes
        Carte CSo1 = new Sort(Demos, "Charge", 1, new Charge());
        Carte CSo2 = new Sort(Demos, "Attaque mentale", 2,
                new AttauqueDuHeros("Attaque mentale", "Inflige 5 points de degats au heros", 5));
        Carte CSe1 = new Serviteur(Demos, "Chasse-marée murloc", 2, 2, 1,
                new CriDeGuerre());
        Carte CSe2 = new Serviteur(Demos, "Champion de Hurlevent", 7, 6, 6,
                new BonusDeHurlevent());
        Carte CSe3 = new Serviteur(Demos, "Chef de raid", 3, 2, 2,
                new BonusDuChefDeRaid());
        Carte CSe4 = new Serviteur(Demos, "Garde de Baie-du-butin", 5, 5, 4,
                new Provocation());
        Carte CSe5 = new Serviteur(Demos, "La missilière téméraire", 6, 5, 2,
                new Charge());
        Carte CSe6 = new Serviteur(Demos, "L'ogre-magi", 4, 4, 4,
                new Provocation());
        Carte CSe7 = new Serviteur(Demos, "Archimage", 6, 4, 7,
                new Provocation());
        Carte CSe8 = new Serviteur(Demos, "L'ogre-magi", 4, 4, 4,
                new Provocation());
        //Ajouter au joueur 1
        Ray.getDeck().add(CSo1);
        Ray.getDeck().add(CSo2);
        Ray.getDeck().add(CSe1);
        Ray.getDeck().add(CSe2);
        Ray.getDeck().add(CSe3);
        Ray.getDeck().add(CSe4);
        Ray.getDeck().add(CSe5);
        Ray.getDeck().add(CSe6);
        Ray.getDeck().add(CSe7);
        Ray.getDeck().add(CSe8);
        //Ajouter au joueur 2
        Demos.getDeck().add(CSe1);
        Demos.getDeck().add(CSe2);
        Demos.getDeck().add(CSe1);
        Demos.getDeck().add(CSe2);
        Demos.getDeck().add(CSe3);
        Demos.getDeck().add(CSe4);
        Demos.getDeck().add(CSe5);
        Demos.getDeck().add(CSe6);
        Demos.getDeck().add(CSe7);
        Demos.getDeck().add(CSe8);


        plateau.demarerPartie();

        // Création menu
        ihm = initialiaserInterface();

        if (ihm == null) {
            System.out.println("L'application ne sais rien faire....");
            System.exit(0);
        }

        while (true) {


            for (ICarte carte : Ray.getMain()) {
                System.out.println("main1");
                System.out.println(carte.toString());
            }
            for (ICarte carte : Demos.getMain()) {
                System.out.println("main2");
                System.out.println(carte.toString());
            }


            System.out.println(plateau.toString());
            String choix = menu();
            try {
                ihm.interagir(choix, plateau);
            } catch (Exception e) {
                e.printStackTrace();
            }


            for (ICarte carte : Ray.getJeu()) {
                System.out.println("jeu");
                System.out.println(carte.toString());
            }
            for (ICarte carte : Demos.getJeu()) {
                System.out.println("jeu2");
                System.out.println(carte.toString());
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
            monInterface = new InterfaceUtiliserPouvoirHero(monInterface);
            monInterface = new InterfaceUtiliserCarteEnJeu(monInterface);
            monInterface = new InterfaceJouerCarte(monInterface);
            monInterface = new InterfaceFinirTour(monInterface);
            return monInterface;
        }
}
