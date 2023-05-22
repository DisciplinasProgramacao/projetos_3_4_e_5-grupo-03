public class ClienteAvaliaException extends Exception {
    public ClienteAvaliaException() {
        super("Você precisa ter visto a mídia para avalia-la");
    }
}
