import org.junit.jupiter.api.*;

import exceptions.ClienteException;
import exceptions.MidiaDataException;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

class ClienteTest {
    Cliente cliente;
    Serie serie1;
    Serie serie2;
    Avaliacao avaliacao;

    @BeforeEach
    public void setUp() throws ClienteException, MidiaException, MidiaDataException {
        LocalDate dataDeLancamento1 = LocalDate.of(2021, 1, 1);
        LocalDate dataDeLancamento2 = LocalDate.of(2020, 1, 1);
        cliente = new Cliente("nome", "usuario1", "senha12345");
        serie1 = new Serie(3, "Serie 1", 0, 0, 20,  LocalDate.of(2020, 1, 1));
        serie2 = new Serie(4, "Serie 2", 1, 1, 10, LocalDate.of(2021, 1, 1));
        cliente.adicionarNaLista(serie1);
        cliente.adicionarNaLista(serie2);
        avaliacao = new Avaliacao(cliente, serie1, 6.2);
    }

    @Test
    void testAdicionarNaLista() throws MidiaException, MidiaDataException {
        Serie serie3 = new Serie(5, "Serie 3", LocalDate.of(2022, 1, 1), 15);
        cliente.adicionarNaLista(serie3);
        assertEquals(3, cliente.getListaParaVer().size());
        assertTrue(cliente.getListaParaVer().contains(serie3));
    }

    @Test
    void testRetirarDaLista() {
        assertEquals(2, cliente.getListaParaVer().size());
        cliente.retirarDaLista(serie1);
        assertEquals(1, cliente.getListaParaVer().size());
        assertFalse(cliente.getListaParaVer().contains(serie1));
        cliente.retirarDaLista(serie2);
        assertEquals(0, cliente.getListaParaVer().size());
        assertFalse(cliente.getListaParaVer().contains(serie2));
        cliente.retirarDaLista(serie2);
        assertEquals(0, cliente.getListaParaVer().size());
    }

    @Test
    void testFiltrarPorGeneroExistente() {
        List<Midia> filtradas = cliente.filtrarPorGenero("Comédia");
        assertEquals(1, filtradas.size());
        assertTrue(filtradas.contains(serie2));
    }

    @Test
    void testFiltrarPorGeneroInexistente() {
        List<Midia> filtradas = cliente.filtrarPorGenero("Terror");
        assertEquals(0, filtradas.size());
    }

    @Test
    void testFiltrarPorIdiomaExistente() {
        List<Midia> filtradas = cliente.filtrarPorIdioma("Português");
        assertEquals(1, filtradas.size());
        assertTrue(filtradas.contains(serie2));
    }

    @Test
    void testFiltrarPorIdiomaInexistente() {
        List<Midia> filtradas = cliente.filtrarPorIdioma("Espanhol");
        assertEquals(0, filtradas.size());
    }

    @Test
    void testFiltrarPorQtdEpisodiosExistente() {
        List<Midia> filtradas = cliente.filtrarPorQtdEpisodios(10);
        assertEquals(1, filtradas.size());
        assertTrue(filtradas.contains(serie2));
    }

    @Test
    void testFiltrarPorQtdEpisodiosInexistente() {
        List<Midia> filtradas = cliente.filtrarPorQtdEpisodios(5);
        assertEquals(0, filtradas.size());
    }

    @Test
    void testRegistrarAudiencia() {
        cliente.registrarAudiencia(serie1);
        assertEquals(1, cliente.getListaJaVistas().size());
        cliente.registrarAudiencia(serie1);
        assertEquals(1, cliente.getListaJaVistas().size());
        cliente.registrarAudiencia(serie2);
        assertEquals(2, cliente.getListaJaVistas().size());
    }

    @Test
    void registrarAvaliacao() {
        cliente.adicionarAvaliacao(avaliacao);
        assertEquals(1, cliente.getAvaliacoes().size());
        // cliente.adicionarAvaliacao(avaliacao);
        //assertEquals(1, cliente.getAvaliacoes().size());
    }
}