package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

/**
 * Classe abstraite Invocation de Serviteur representant la capacité d'invocation, Hérite de Capacité
 * @author Rayan KOUSSA
 * @version 0.1
 * @see Capacite
 */
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

    /**
     * Permet d'exctuer l'effet d'invocation
     * @param cible carte ayant la capacité d'invocation
     * @throws HearthstoneException
     */
    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        for(int i=0; i<this.nombreInvocation; i++){
            plateau.getJoueurCourant().getMain().add(this.invocation);
            plateau.getJoueurCourant().jouerCarte(this.invocation);
        }
        if(cible instanceof Sort){
            plateau.getJoueurCourant().getJeu().remove(cible);
            plateau.getJoueurCourant().getMain().remove(cible);
        }
    }
}
