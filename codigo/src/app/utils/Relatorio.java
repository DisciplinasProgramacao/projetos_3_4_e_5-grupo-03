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

    /**
     * Qual cliente assistiu mais mídias, e quantas mídias;
     */
    public void clienteAssistiuMaisMidias() {
        Cliente cliente = this.plataformaStreaming.getClientes().entrySet().stream()
                .max(Comparator.comparingInt(p -> p.getValue().getListaJaVistas().size()))
                .orElseThrow(NoSuchElementException::new)
                .getValue();

        System.out.println("Cliente: " + cliente.getNome() + " - Assistiu: " + cliente.getListaJaVistas().size());
    }

    /**
     * Qual cliente tem mais avaliações, e quantas avaliações;
     */
    public void clienteMaisAvaliacoes() {
        Cliente cliente = this.plataformaStreaming.getClientes().entrySet().stream()
                .max(Comparator.comparingInt(p -> p.getValue().getAvaliacoes().size()))
                .orElseThrow(NoSuchElementException::new)
                .getValue();

        System.out.println("Cliente: " + cliente.getNome() + " - Avaliações: " + cliente.getAvaliacoes().size());
    }

    /**
     * Qual a porcentagem dos clientes com pelo menos 15 avaliações;
     */
    public void porcentagemClientesComMais15Avaliacoes() {
        long total = this.plataformaStreaming.getClientes().entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(o -> o.getAvaliacoes().size() >= 15)
                .count();

        long porcentagem = total * this.plataformaStreaming.getClientes().size();

        System.out.println("Porcentagem: " + porcentagem + "%");
    }

    /**
     * Quais são as 10 mídias de melhor avaliação, com pelo menos 100 avaliações, em ordem decrescente;
     */
    public void midiasComMaisAvaliacoes() {
        List<Midia> lista = this.plataformaStreaming.getMidias().values().stream()
                .filter(o -> o.getAvaliacoes().size() > 100)
                .sorted(Comparator.comparingInt(Midia::getNumAvaliacoes).reversed()) //
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Lista de mais avaliados");
        for (Midia obj : lista) this.printMidiaAvaliacoes(obj);
    }

    /**
     * Quais são as 10 mídias com mais visualizações, em ordem decrescente;
     */
    public void midiasComMaisVisualizacoes() {
        List<Midia> lista =  this.plataformaStreaming.getMidias().values().stream()
                .sorted(Comparator.comparingInt(Midia::getAudiencia).reversed())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Lista de mais visualizações");
        for (Midia obj : lista) this.printMidiaVisualizacoes(obj);
    }


    /**
     * Quais são as 10 mídias de melhor avaliação, com pelo menos 100 avaliações, em ordem decrescente por genero;
     */
    public void midiasComMaisAvaliacoesPorGenero() {
        Map<String, List<Midia>> lista = this.plataformaStreaming.getMidias().values().stream()
                .filter(o -> o.getAvaliacoes().size() > 100)
                .sorted(Comparator.comparingInt(Midia::getNumAvaliacoes).reversed())
                .limit(10)
                .collect(Collectors.groupingBy(Midia::getGenero));

        System.out.println("Lista de mais avaliados por genero: ");

        for (Map.Entry<String, List<Midia>> entry : lista.entrySet()) {
            String chave = entry.getKey();
            List<Midia> listaInterna = entry.getValue();
            System.out.println("Chave: " + chave);

            for (Midia midia : listaInterna) this.printMidiaAvaliacoes(midia);
        }
    }

    /**
     * Quais são as 10 mídias com mais visualizações, em ordem decrescente por genero;
     */
    public void midiasComMaisVisualizacoesPorGenero() {
        Map<String, List<Midia>> lista =  this.plataformaStreaming.getMidias().values().stream()
                .sorted(Comparator.comparingInt(Midia::getAudiencia).reversed())
                .limit(10)
                .collect(Collectors.groupingBy(Midia::getGenero));

        System.out.println("Lista de mais visualizações por genero: ");

        for (Map.Entry<String, List<Midia>> entry : lista.entrySet()) {
            String chave = entry.getKey();
            List<Midia> listaInterna = entry.getValue();
            System.out.println("Chave: " + chave);

            for (Midia midia : listaInterna) this.printMidiaVisualizacoes(midia);
        }
    }

    private void printMidiaVisualizacoes(Midia midia) {
        System.out.println("    Nome: " + midia.getNome() + " | Visualizações:" + midia.getAudiencia());
    }

    private void printMidiaAvaliacoes(Midia midia) {
        System.out.println("    Nome: " + midia.getNome() + " | Avaliações: " + midia.getNumAvaliacoes());
    }
}
