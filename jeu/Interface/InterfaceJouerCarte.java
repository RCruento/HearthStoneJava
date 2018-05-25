package jeu.Interface;

import jeu.Carte.ICarte;
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

        ICarte carte;
        String nomCarte;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un bout du nom de la carte que vous voulez jouez \n -->");
        nomCarte = sc.nextLine();
        try {
            carte = p.getJoueurCourant().getCarteEnMain(nomCarte);
            p.getJoueurCourant().jouerCarte(carte);

        } catch (HearthstoneException e) {
            System.out.println(e.getMessage());
        }
        p.gagnerPartie(p.getJoueurCourant());
    }

    @Override
    public String getDescription() {
        return "Jouer une carte";
    }
}
