public class ClienteException extends Exception {
    public ClienteException(String nome, String s) {
        if(s.length() < 2) {
            super("O nome deve ser maior que 2 caracteres!");
        } else if()
    }
}
