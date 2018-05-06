package jeu;

public interface ICarte  {
    boolean disparait();
    void    executerActiion(Carte cible);
    void    executerEffetDebutMiseEnJeu(Carte cible);
    void    executerEffetDebutTour(Carte cible);
    void    executerEffetDisparition(Carte cible);
    void    executerEffetFinTour(Carte cible);
    int     getCout();
    String  getNom();
    IJoueur getProprietaire();
}
