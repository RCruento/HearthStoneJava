package jeu.Exception;

/**
 * Classe HeathStoneException, Herite de la classe Exception
 * Permet de lancer des exceptions
 */
public class HearthstoneException extends Exception {
    public HearthstoneException(String message){
        super(message);
    }
    public HearthstoneException(){
        super("Erreur");
    }
}
