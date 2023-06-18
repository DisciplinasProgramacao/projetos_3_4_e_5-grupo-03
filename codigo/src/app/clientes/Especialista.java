package app.clientes;
import app.midias.Midia;
import java.security.InvalidParameterException;
import java.util.Map;

public interface Especialista {
    public void adicionarComentario(Midia midia, String comentario) throws InvalidParameterException;

    public Map<Midia, String> getComentarios();
}
