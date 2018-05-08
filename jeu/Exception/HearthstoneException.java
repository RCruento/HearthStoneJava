package jeu.Exception;

public class HearthstoneException extends Exception {
    public HearthstoneException(String message){
        super(message);
    }
    public HearthstoneException(){
        super("Erreur");
    }
}
