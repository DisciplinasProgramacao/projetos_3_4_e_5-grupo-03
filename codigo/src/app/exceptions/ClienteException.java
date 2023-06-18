package app.exceptions;
import java.security.InvalidParameterException;

public class ClienteException extends InvalidParameterException {
    public ClienteException(String nome, String caracter) {
            super("O "+ nome +" do app.app.clientes.Cliente deve possuir mais de "+ caracter +" caracteres!");
    }
}
