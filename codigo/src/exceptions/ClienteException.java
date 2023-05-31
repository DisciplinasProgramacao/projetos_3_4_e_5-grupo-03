package exceptions;

import java.security.InvalidParameterException;

public class ClienteException extends InvalidParameterException {
    public ClienteException(String nome, String caracter) {
            super("O "+ nome +" do Cliente deve possuir mais de "+ caracter +" caracteres!");
    }
}
