package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public class CriDeGuerre extends InvocationDeServiteur {
    public CriDeGuerre() throws HearthstoneException {
        super("Cri de guerre", "Invoque un Murloc 1/1",new Serviteur(Plateau.getInstance().getJoueurCourant(), "Murloc",1,1),  1);
    }
}
