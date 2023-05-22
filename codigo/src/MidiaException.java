public class MidiaException extends Exception {
    
    public MidiaException(String nome, String caracteres) {
        super("O "+ nome +" da Midia deve possuir mais de "+ caracteres +" caracteres!");
    }

}
