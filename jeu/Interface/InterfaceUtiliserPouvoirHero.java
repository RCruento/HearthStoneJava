package jeu.Interface;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

import java.util.Scanner;

public class InterfaceUtiliserPouvoirHero extends Interface {
    public InterfaceUtiliserPouvoirHero(Interface suivant) {
        super(suivant);
    }

    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    @Override
    public void executerRequete(IPlateau p) throws HearthstoneException {
        ICarte cible;
        Scanner sc = new Scanner(System.in);
        System.out.println("Sur qui utiliser le pouvoir du heros ?");
        String nomCible = sc.nextLine();
        // si il veut attaquer le hero
        if (p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible))
            p.getJoueurCourant().getHeros().getPouvoir().executerAction(p.getAdversaire(p.getJoueurCourant()).getHeros());
            // sinon si il veut attaquer une des autres carte en jeu
        else {
            //try {
            cible = p.getAdversaire(p.getJoueurCourant()).getCarteEnJeu(nomCible);
            p.getJoueurCourant().getHeros().getPouvoir().executerAction(cible);
            //} catch (HearthstoneException e) {
            //	System.out.println(e.getMessage());
            //}
        }
        p.gagnerPartie(p.getJoueurCourant());
    }

    @Override
    public String getDescription() {
        return "Utiliser pouvoir du hero";
    }
}
