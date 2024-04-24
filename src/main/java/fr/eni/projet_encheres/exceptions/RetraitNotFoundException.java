package fr.eni.projet_encheres.exceptions;

public class RetraitNotFoundException extends Exception {
    private int noRetrait;

    public RetraitNotFoundException(int noRetrait) {
        this.noRetrait = noRetrait;
    }

    @Override
    public String getMessage() {

        return "Le retrait " + noRetrait + " n'a pas été trouvé.";
    }
}
