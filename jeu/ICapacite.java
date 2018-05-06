package jeu;

public interface ICapacite {
    void executerAction(Object cible);
    void executerEffetDebutTour();
    void executeEffetDisparition(Object cible);
    void executerEffetFinTor();
    void executeEffetMiseEnjeu(Object cible);
    String getDescription();
    String getNom();
}
