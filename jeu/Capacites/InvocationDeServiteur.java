package jeu.Capacites;

import javafx.print.PageLayout;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

public abstract class InvocationDeServiteur extends Capacite {
    private Serviteur invocation;
    private int nombreInvocation;

    public InvocationDeServiteur(String nom, String description, Serviteur invocation, int nombreInvocation) {
        super(nom, description);
        this.invocation = invocation;
        this.nombreInvocation = nombreInvocation;
    }

    public Serviteur getInvocation() {
        return invocation;
    }

    public void setInvocation(Serviteur invocation) {
        this.invocation = invocation;
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
    public void executerEffetFinTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {
        for(int i=0; i<this.nombreInvocation; i++){
            Plateau.getInstance().getJoueurCourant().getJeu().add(this.invocation);
        }
        if(cible instanceof Sort){
            Plateau.getInstance().getJoueurCourant().getJeu().remove(cible);
        }

    }
}
