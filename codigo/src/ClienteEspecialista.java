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
    public void adicionarComentario(Serie serie, String comentario) {
        LocalDate umMesAtras = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        // Verifica se o cliente assistiu pelo menos 5 séries no último mês
        long seriesAssistidasNoUltimoMes = super.getDatasSeriesAssistidas().stream()
            .filter(data -> data.isAfter(umMesAtras))
            .count();

        if (seriesAssistidasNoUltimoMes < 5) {
            System.out.println("Você precisa assistir pelo menos 5 séries no último mês para adicionar um comentário!");
        } else if (super.getListaJaVistas().contains(serie)) {
            comentarios.put(serie, comentario);
        } else {
            System.out.println("Não é possível adicionar um comentário a uma série que você não assistiu!");
        }
    }

    public Map<Serie, String> getComentarios() {
        return this.comentarios;
    }
}
