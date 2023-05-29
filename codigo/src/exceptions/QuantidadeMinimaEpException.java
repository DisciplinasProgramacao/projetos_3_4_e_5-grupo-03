package exceptions;
public class QuantidadeMinimaEpException extends Exception{
    public QuantidadeMinimaEpException() {
        super("O número mínimo de episódios deve ser 2");
    }
}
