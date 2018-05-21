package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Plateau.Plateau;

public class CriDeGuerre extends InvocationDeServiteur {
    public CriDeGuerre() {
        super("Cri de guerre", "Invoque un Murloc 1/1",new Serviteur(Plateau.getInstance().getJoueurCourant(), "Murloc",1,1),  1);
    }
}
