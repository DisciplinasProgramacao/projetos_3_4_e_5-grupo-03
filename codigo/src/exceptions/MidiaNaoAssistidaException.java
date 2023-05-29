package exceptions;

public class MidiaNaoAssistidaException extends Exception {

    public MidiaNaoAssistidaException() {
        super("Não é possivel adicionar um comentário a uma série que você não assistiu");
    }
}
