package jeu.Capacites;

/**
 * Classe BonusDuChefDeRaid permet de donner un point bonus d'attaque au serviteur, Herite de EffetPermanent
 * @author  Rayan KOUSSA
 * @version 0.1
 * @see EffetPermanent
 */
public class BonusDuChefDeRaid extends  EffetPermanent {
    public BonusDuChefDeRaid() {
        super("Bonus de chef du raid", "Ajoute un bonus 1/0 aux serviteurs alliés", 0, 1);
    }
}
