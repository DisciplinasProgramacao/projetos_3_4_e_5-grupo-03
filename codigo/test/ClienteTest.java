import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

class ClienteTest {
    Cliente cliente;
    Serie serie;
    Serie serie2;
    Avaliacao avaliacao;


    @BeforeEach
    public void setUp() {
        LocalDate dataDeLancamento1 = LocalDate.of(2021, 1, 1);
        LocalDate dataDeLancamento2 = LocalDate.of(2020, 1, 1);
        cliente = new Cliente("nome", "usuario1", "senha12345");
        serie = new Serie(1, "Serie1", "comédia", "Portugues", 15, 0, dataDeLancamento1);
        serie2 = new Serie(2, "Serie2", "drama", "inglês", 8, 0, dataDeLancamento2);
        cliente.adicionarNaLista(serie);
        cliente.adicionarNaLista(serie2);
        avaliacao = new Avaliacao(cliente, serie, 6.2);
    }

    @Test
    void testSave() throws IOException {
        serie.save();
    }

    @Test
    void testAdicionarNaLista() {
        assertEquals(2, cliente.listaParaVer.size());
    }

    @Test
    void testRetirarDaLista() {
        assertEquals(2, cliente.listaParaVer.size());
        cliente.retirarDaLista(serie);
        assertEquals(1, cliente.listaParaVer.size());
    }

    @Test
    void testFiltrarPorGenero() {
        assertEquals(1, cliente.filtrarPorGenero("Humor").size());
    }

    @Test
    void testFiltrarPorIdioma() {
        assertEquals(1, cliente.filtrarPorIdioma("Portugues").size());
    }

    @Test
    void testFiltrarPorQtdEpisodios() {
        assertEquals(1, cliente.filtrarPorQtdEpisodios(15).size());
    }
    
    @Test
    void registrarAudiencia() {
        cliente.registrarAudiencia(serie);
        assertEquals(1, cliente.listaJaVistas.size());
    }

    @Test
    void registrarAvaliacao() {
        cliente.adicionarAvaliacao(avaliacao);
        assertEquals(1, cliente.getAvaliacoes().size());
        // cliente.adicionarAvaliacao(avaliacao);
        //assertEquals(1, cliente.getAvaliacoes().size());
    }
}