package jeu.Interface;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;
import java.util.Scanner;


/**
 * Classe InterfaceUtiliserPouvoirHero permet au joueur d'utiliser son pouvoir en la choisissant
 * Hérite d'Interface
 * @author Rayan KOUSSA
 * @version 0.1
 * @see Interface
 */
public class InterfaceUtiliserPouvoirHero extends Interface {
    public InterfaceUtiliserPouvoirHero(Interface suivant) {
        super(suivant);
    }

    /**
     * Permet de verifier si le choix est correcte
     * @param choix pour finir le tour
     * @return true si correcte, false sinon
     */
    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    /**
     * Permet d'executer le choix utiliser le pouvoir du heros
     * @param p plateau
     * @throws HearthstoneException
     */
    @Override
    public void executerRequete(IPlateau p) throws HearthstoneException {
        ICarte cible;

        Scanner sc = new Scanner(System.in);
        System.out.println("Sur qui utiliser le pouvoir du heros ?");
        String nomCible = sc.nextLine();

        if (p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible)) {
            if ( p.getJoueurCourant().getMana() > 0) {
                p.getJoueurCourant().getHeros().getPouvoir().executerAction(p.getAdversaire(p.getJoueurCourant()).getHeros());
                p.getJoueurCourant().setMana(p.getJoueurCourant().getMana()-1);
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

    /**
     * Permet d'afficher le choix
     * @return "Utiliser pouvoir du heros"
     */
    @Override
    public String getDescription() {
        return "Utiliser pouvoir du hero";
    }
}
