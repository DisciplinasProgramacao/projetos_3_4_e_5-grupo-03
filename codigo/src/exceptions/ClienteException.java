package exceptions;
public class ClienteException extends Exception {
    public ClienteException(String nome, String caracter) {
            super("O "+ nome +" do Cliente deve possuir mais de "+ caracter +" caracteres!");
    }
}
