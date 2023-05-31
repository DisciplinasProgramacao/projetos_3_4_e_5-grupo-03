import java.util.Map;

import exceptions.EpisodiosMinimosException;
import exceptions.MidiaNaoAssistidaException;

public interface Especialista {
    public void adicionarComentario(Midia midia, String comentario) throws InvalidParameterException;

    public Map<Midia, String> getComentarios();
}
