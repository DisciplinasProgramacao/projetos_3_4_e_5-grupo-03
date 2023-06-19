package app.utils;
import app.PlataformaStreaming;
import app.clientes.Cliente;
import app.midias.*;
import java.util.*;
import java.util.stream.Collectors;

public class Relatorio {
    PlataformaStreaming plataformaStreaming;

    public Relatorio(PlataformaStreaming plataformaStreaming) {
        this.plataformaStreaming = plataformaStreaming;
    }

    public void clienteAssistiuMaisMidias() {
        Cliente cliente = this.plataformaStreaming.getClientes().entrySet().stream()
                .max(Comparator.comparingInt(p -> p.getValue().getListaJaVistas().size()))
                .orElseThrow(NoSuchElementException::new)
                .getValue();

        System.out.println("Cliente: " + cliente.getNome() + " - Assistiu: " + cliente.getListaJaVistas().size());
    }

    public void clienteMaisAvaliacoes() {
        Cliente cliente = this.plataformaStreaming.getClientes().entrySet().stream()
                .max(Comparator.comparingInt(p -> p.getValue().getAvaliacoes().size()))
                .orElseThrow(NoSuchElementException::new)
                .getValue();

        System.out.println("Cliente: " + cliente.getNome() + " - Avaliações: " + cliente.getAvaliacoes().size());
    }

    public void porcentagemClientesComMais15Avaliacoes() {
        long total = this.plataformaStreaming.getClientes().entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(o -> o.getAvaliacoes().size() >= 15)
                .count();

        long porcentagem = total * this.plataformaStreaming.getClientes().size();

        System.out.println("Porcentagem: " + porcentagem + "%");
    }

    public void midiasComMaisAvaliacoes() {
        List<Midia> lista = this.plataformaStreaming.getMidias().values().stream()
                .filter(o -> o.getAvaliacoes().size() > 100)
                .sorted(Comparator.comparingInt(o -> o.getAvaliacoes().size()))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Lista de mais avaliados: " + lista);
    }

    public void midiasComMaisVisualizacoes() {
        List<Midia> lista =  this.plataformaStreaming.getMidias().values().stream()
                .sorted(Comparator.comparingInt(Midia::getAudiencia))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Lista de mais visualizações: " + lista);
    }
}
