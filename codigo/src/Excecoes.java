public class Excecoes{

    public static class EpisodiosMinimosException extends Exception {
        public EpisodiosMinimosException(String mensagem) {
            super("Você precisa assistir pelo menos 5 séries no último mês para adicionar um comentário!");
        }
    }

    public static class MidiaNaoAssistidaException extends Exception {
        public MidiaNaoAssistidaException(String mensagem) {
            super("Não é possível adicionar um comentário a uma série que você não assistiu!");
        }
    }

}