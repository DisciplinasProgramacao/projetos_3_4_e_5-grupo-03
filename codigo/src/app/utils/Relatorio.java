package app.utils;
import app.PlataformaStreaming;
import app.clientes.Cliente;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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

//    public List<Midia> midiasComMaisAvaliacoes() {
//
//    }
//
//    public List<Midia> midiasComMaisVisualizacoes() {
//
//    }
}
