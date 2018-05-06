package jeu;

public interface IPlateau {
    void ajouterJoueur(IJoueur joueur);
    void demarerPartie();
    boolean estDemaree();
    void gagnerPartie(IJoueur joueur);
    void finirTour(IJoueur joueur);
    IJoueur getAdversaire(IJoueur joueur);
    IJoueur getJoueurCourant();
    void setJoueurCourant(IJoueur joueur);
}
