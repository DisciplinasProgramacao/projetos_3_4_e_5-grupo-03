import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javax.management.InvalidAttributeValueException;

import exceptions.ClienteException;

public class ClienteEspecialista extends Cliente implements Especialista {
    private Map<Midia, String> comentarios;

    public ClienteEspecialista(String nome, String nomeDeUsuario, String senha) throws ClienteException {
        super(nome, nomeDeUsuario, senha);
        this.comentarios = new HashMap<>();
    }

    @Override
    public void adicionarComentario(Midia midia, String comentario) throws InvalidParameterException {
        LocalDate umMesAtras = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        // Verifica se o cliente assistiu pelo menos 5 séries no último mês
        long seriesAssistidasNoUltimoMes = super.getDatasSeriesAssistidas().stream()
            .filter(data -> data.isAfter(umMesAtras))
            .count();

        if (seriesAssistidasNoUltimoMes < 5) {
            throw new InvalidParameterException("A quantidade mínima de episódios vistos para adicionar um comentario precisa ser 5");  
        } else if (super.getListaJaVistas().contains(midia)) {
            comentarios.put(midia, comentario);
        } else {
            throw new InvalidParameterException("Não é possivel adicionar um comentário a uma série que você não assistiu");
        }
    }

    public Map<Midia, String> getComentarios() {
        return this.comentarios;
    }
}
