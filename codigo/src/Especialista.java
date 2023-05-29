import java.util.Map;

import exceptions.EpisodiosMinimosException;
import exceptions.MidiaNaoAssistidaException;

public interface Especialista {
    public void adicionarComentario(Midia midia, String comentario) throws EpisodiosMinimosException, MidiaNaoAssistidaException;

    public Map<Midia, String> getComentarios();
}
