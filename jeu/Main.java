package jeu;

public class Main {

    public static void main(String[] args) {
        Joueur Ray = new Joueur("Zenon", "Rexxar");
        System.out.print("je suis ici");
        Deck D1 = new Deck(Ray);
        Ray.toString();

    }
}
