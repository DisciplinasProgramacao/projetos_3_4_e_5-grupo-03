import java.util.HashMap;

public interface Especialista {
    HashMap<Midia, String> comentarios = new HashMap<>();

    default void adicionarComentario(Midia midia, String comentario) throws EpisodiosMinimosException, MidiaNaoAssistidaException {
        comentarios.put(midia, comentario);
    }

    default HashMap<Midia, String> getComentarios() {
        return comentarios;
    }
}
