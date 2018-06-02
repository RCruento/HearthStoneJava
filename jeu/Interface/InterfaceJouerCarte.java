package jeu.Interface;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

import java.util.Scanner;

public class InterfaceJouerCarte extends  Interface{
    public InterfaceJouerCarte(Interface suivant) {
        super(suivant);
    }

    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    @Override
    public void executerRequete(IPlateau p) throws HearthstoneException {

        String nomCarte;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un bout du nom de la carte que vous voulez jouez \n -->");
        nomCarte = sc.nextLine();
        boolean trouve = false;


        while(!trouve){
            for (ICarte carte : p.getJoueurCourant().getMain()) {
                if (carte.getNomCarte().contains(nomCarte)) {
                    if (carte instanceof Serviteur) {
                        trouve = true;
                        p.getJoueurCourant().jouerCarte(carte);
                        break;
                    } else {
                        if (carte instanceof Sort) {
                            if (((Sort) carte).getCapacite().getDescription().contains("personnage")) {
                                System.out.println("Carte sort d'attaque ? Saisir cible !");
                                String nomCible = sc.nextLine();
                                if (p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible)) {
                                   ((Sort) carte).getCapacite().executerAction(p.getAdversaire(p.getJoueurCourant()).getHeros());
                                    trouve = true;
                                }
                                while (!trouve) {
                                    for (ICarte carteA : p.getAdversaire(p.getJoueurCourant()).getJeu()) {
                                        if (carteA.getNomCarte().contains((nomCible))) {
                                            ((Sort) carte).getCapacite().executerAction(carteA);
                                            p.getJoueurCourant().getMain().remove(carte);
                                            trouve = true;
                                            break;
                                        }
                                    }
                                    if (!trouve) {
                                        System.out.println("Saisir une cible valide!");

                                    }
                                }
                            }
                            if (((Sort) carte).getCapacite().getDescription().contains("a tous")){
                                ((Sort) carte).getCapacite().executerEffetDebutTour();
                                p.getJoueurCourant().getMain().remove(carte);
                            }
                            if(((Sort) carte).getCapacite().getDescription().contains("hero")){
                                ((Sort) carte).getCapacite().executerAction(p.getAdversaire(p.getJoueurCourant()).getHeros());
                                p.getJoueurCourant().getMain().remove(carte);
                            }
                        }
                    }
                }

            }
            if(!trouve){
                System.out.println("Carte non trouvée ! Retour au menu");
                trouve = true;
            }

        }




        /*
        while (p.getJoueurCourant().getMain().)
            p.getJoueurCourant()
        }
        try {

            p.getJoueurCourant().jouerCarte(carte);

        } catch (HearthstoneException e) {
            System.out.println(e.getMessage());
        }
        */
    }

    @Override
    public String getDescription() {
        return "Jouer une carte";
    }
}