package app.utils;
import app.PlataformaStreaming;
import app.clientes.Cliente;
import app.exceptions.ClienteException;
import app.midias.Filme;
import app.midias.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;

public class RelatorioTest {
    private PlataformaStreaming plataforma;
    private Relatorio relatorio;

    @BeforeEach
    void setUp() throws InvalidParameterException, ClienteException {
        plataforma = new PlataformaStreaming("Plataforma Teste", true);

        // Adicionar app.app.clientes
        Cliente cliente1 = new Cliente("João Silva", "joaosilva", "123456");
        Cliente cliente2 = new Cliente("Maria Souza", "mariasouza", "789012");
        plataforma.adicionarCliente(cliente1);
        plataforma.adicionarCliente(cliente2);

        // Adicionar mídias
        Filme filme1 = new Filme(1, "Filme 1", LocalDate.of(2020, 1, 1), 120);
        Filme filme2 = new Filme(2, "Filme 2", LocalDate.of(2021, 1, 1), 150);
        Filme filme3 = new Filme(2, "Filme 2", LocalDate.of(2021, 1, 1), 150, 0 , 1);
        Serie serie1 = new Serie(3, "Serie 1", LocalDate.of(2020, 1, 1), 10);
        Serie serie2 = new Serie(4, "Serie 2", LocalDate.of(2021, 1, 1), 20);

        plataforma.adicionarFilme(filme1);
        plataforma.adicionarFilme(filme2);
        plataforma.adicionarFilme(filme3);
        plataforma.adicionarSerie(serie1);
        plataforma.adicionarSerie(serie2);

        relatorio = new Relatorio(this.plataforma);
    }

    @Test
    void testRelatorios() {
        this.relatorio.clienteAssistiuMaisMidias();

        System.out.println("--------------------------------------------------------");

        this.relatorio.clienteMaisAvaliacoes();

        System.out.println("--------------------------------------------------------");

        this.relatorio.porcentagemClientesComMais15Avaliacoes();

        System.out.println("--------------------------------------------------------");

        this.relatorio.midiasComMaisAvaliacoes();

        System.out.println("--------------------------------------------------------");

        this.relatorio.midiasComMaisVisualizacoes();

        System.out.println("--------------------------------------------------------");

        this.relatorio.midiasComMaisAvaliacoesPorGenero();

        System.out.println("--------------------------------------------------------");

        this.relatorio.midiasComMaisVisualizacoesPorGenero();
        
        System.out.println("--------------------------------------------------------");
    }
}
