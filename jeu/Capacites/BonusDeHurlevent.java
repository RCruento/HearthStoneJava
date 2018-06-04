package jeu.Capacites;

/**
 * Classe BonusDeHurlevent permet de donner un point bonus d'attaque et de santé au serviteur, Herite de EffetPermanent
 * @author  Rayan KOUSSA
 * @version 0.1
 * @see EffetPermanent
 */

public class BonusDeHurlevent extends EffetPermanent {
    public BonusDeHurlevent() {
        super("Bonus de Hurlevent", "Ajoute un bonus 1/1 aux serviteurs alliés", 1, 1);
    }
}
