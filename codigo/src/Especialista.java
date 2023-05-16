import java.util.Map;

public interface Especialista {
    public void adicionarComentario(Midia midia, String comentario) throws EpisodiosMinimosException, MidiaNaoAssistidaException;

    public Map<Midia, String> getComentarios();
}
