package app.utils;
import app.PlataformaStreaming;
import app.clientes.Cliente;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Relatorio {
    PlataformaStreaming plataformaStreaming;

    public Relatorio(PlataformaStreaming plataformaStreaming) {
        this.plataformaStreaming = plataformaStreaming;
    }

    public Cliente clienteAssistiuMaisMidias() {
        return this.plataformaStreaming.getClientes().entrySet().stream()
                .max(Comparator.comparingInt(p -> p.getValue().getListaJaVistas().size()))
                .orElseThrow(NoSuchElementException::new)
                .getValue();
    }

//    public Map<Cliente, Integer> clienteMaisAvaliacoes() {
//
//    }
//
//    public int porcentagemClientesComMenos15Avaliacoes() {
//
//    }
//
//    public List<Midia> midiasComMaisAvaliacoes() {
//
//    }
//
//    public List<Midia> midiasComMaisVisualizacoes() {
//
//    }
}
