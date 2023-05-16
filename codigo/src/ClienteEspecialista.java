import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ClienteEspecialista extends Cliente implements Especialista {
    private Map<Midia, String> comentarios;

    public ClienteEspecialista(String nome, String nomeDeUsuario, String senha) {
        super(nome, nomeDeUsuario, senha);
        this.comentarios = new HashMap<>();
    }

    @Override
    public void adicionarComentario(Midia midia, String comentario) throws EpisodiosMinimosException, MidiaNaoAssistidaException{
        LocalDate umMesAtras = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        // Verifica se o cliente assistiu pelo menos 5 séries no último mês
        long seriesAssistidasNoUltimoMes = super.getDatasSeriesAssistidas().stream()
            .filter(data -> data.isAfter(umMesAtras))
            .count();

        if (seriesAssistidasNoUltimoMes < 5) {
            throw new EpisodiosMinimosException();  
        } else if (super.getListaJaVistas().contains(midia)) {
            comentarios.put(midia, comentario);
        } else {
            throw new MidiaNaoAssistidaException();
        }
    }

    public Map<Midia, String> getComentarios() {
        return this.comentarios;
    }
}
