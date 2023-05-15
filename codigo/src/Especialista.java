import java.util.HashMap;

public interface Especialista {
    HashMap<Serie, String> comentarios = new HashMap<>();

    default void adicionarComentario(Serie serie, String comentario) {
        comentarios.put(serie, comentario);
    }

    default HashMap<Serie, String> getComentarios() {
        return comentarios;
    }
}
