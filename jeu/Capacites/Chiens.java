package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Joueur.Joueur;

public final class Chiens extends Capacite {
    public Chiens() {
        super("Lachez les chiens", "Invoque autant de chiens que de serviteurs adverses");
        new Serviteur((Joueur)null, "Chien", 0, 1, 1, new jeu.Capacites.Charge());
    }

    public final void a(Object var1) {

    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetDebutTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetDisparition(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTor() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {

    }
}
