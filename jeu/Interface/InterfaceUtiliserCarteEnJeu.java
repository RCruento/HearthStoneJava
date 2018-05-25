package jeu.Interface;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

import java.util.Scanner;

public class InterfaceUtiliserCarteEnJeu extends Interface {
    public InterfaceUtiliserCarteEnJeu(Interface suivant) {
        super(suivant);
    }

    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    @Override
    public void executerRequete(IPlateau p) throws HearthstoneException {
        ICarte carte;
        ICarte cible;
        System.out.println("Quel carte veux-tu utiliser ?");
        Scanner sc = new Scanner(System.in);
        String nomCarte = sc.nextLine();
        System.out.println("Quel est la cible ?");
        String nomCible = sc.nextLine();

        try {
            carte = p.getJoueurCourant().getCarteEnJeu(nomCarte);
            if(p.getAdversaire(p.getJoueurCourant()).getJeu().contains(nomCible))
                cible = p.getAdversaire(p.getJoueurCourant()).getCarteEnJeu(nomCible);
            else
                cible = p.getAdversaire(p.getJoueurCourant()).getCarteEnJeu(nomCible);
            p.getJoueurCourant().utiliserCarte(carte, cible);

        }catch (HearthstoneException e){
            System.out.println(e.getMessage());
        }
        //System.out.println();
        p.gagnerPartie(p.getJoueurCourant());



    }

    @Override
    public String getDescription() {
        return "Utiliser carte en jeux";
    }
}
