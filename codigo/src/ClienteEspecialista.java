import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ClienteEspecialista extends Cliente implements Especialista {
    private Map<Serie, String> comentarios;

    public ClienteEspecialista(String nome, String nomeDeUsuario, String senha) {
        super(nome, nomeDeUsuario, senha);
        this.comentarios = new HashMap<>();
    }

    @Override
    public void adicionarComentario(Serie serie, String comentario) throws EpisodiosMinimosException, MidiaNaoAssistidaException{
        LocalDate umMesAtras = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        // Verifica se o cliente assistiu pelo menos 5 séries no último mês
        long seriesAssistidasNoUltimoMes = super.getDatasSeriesAssistidas().stream()
            .filter(data -> data.isAfter(umMesAtras))
            .count();

        if (seriesAssistidasNoUltimoMes < 5) {
            throw new EpisodiosMinimosException();  
        } else if (super.getListaJaVistas().contains(serie)) {
            comentarios.put(serie, comentario);
        } else {
            throw new MidiaNaoAssistidaException();
        }
    }

    public Map<Serie, String> getComentarios() {
        return this.comentarios;
    }
}
