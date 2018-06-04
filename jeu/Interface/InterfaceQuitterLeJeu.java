package jeu.Interface;

import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

public class InterfaceQuitterLeJeu extends Interface{

    public InterfaceQuitterLeJeu(Interface suivant) {
        super(suivant);
    }

    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    public void executerRequete(IPlateau p)throws HearthstoneException{
        System.out.println(p.getJoueurCourant().getPseudo()+ " a décidé de quitter la partie");
        System.out.println(p.getAdversaire(p.getJoueurCourant()).getPseudo()+ " a gagné la partie");
        System.exit(0);

    }

    @Override
    public String getDescription() {
        return "Quitter la partie";
    }
}
