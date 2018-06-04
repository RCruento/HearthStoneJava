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

        if (p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible)) {
            if ( p.getJoueurCourant().getMana() > 0) {
                p.getJoueurCourant().getHeros().getPouvoir().executerAction(p.getAdversaire(p.getJoueurCourant()).getHeros());

                if (p.getAdversaire(p.getJoueurCourant()).getHeros().mort()) {
                    p.gagnerPartie(p.getJoueurCourant());
                }
            }else{
                throw new HearthstoneException("Pas assez de mana retour au menu");
            }
        }else {
            cible = p.getAdversaire(p.getJoueurCourant()).getCarteEnJeu(nomCible);
            p.getJoueurCourant().getHeros().getPouvoir().executerAction(cible);
        }
    }

    @Override
    public String getDescription() {
        return "Utiliser pouvoir du hero";
    }
}
