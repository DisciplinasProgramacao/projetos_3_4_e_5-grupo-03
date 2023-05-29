package exceptions;
public class DuracaoFilmeException extends Exception{
    public DuracaoFilmeException() {
        super("A duração do Filme não pode ser menor que 10 minutos!");
    }
}
