package exceptions;
public class MidiaDataException extends Exception {
    
    public MidiaDataException(String nome) {
        super("O lançamento da "+ nome +" não pode ser uma data futura!");
    }

}