import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlataformaStreamingTest {
    private PlataformaStreaming plataforma;
    private Serie serie1;
    private Serie serie2;
    private Serie serie3;
    private Cliente cliente1;

    @BeforeEach
    public void setUp() {
        LocalDate dataDeLancamento1 = LocalDate.of(2021, 1, 1);
        LocalDate dataDeLancamento2 = LocalDate.of(2020, 1, 1);
        LocalDate dataDeLancamento3 = LocalDate.of(2019, 1, 1);
        plataforma = new PlataformaStreaming("TesteStreaming");
        serie1 = new Serie(1, "Serie1", "ação", "português", 10, 0, dataDeLancamento1);
        serie2 = new Serie(2, "Serie2", "drama", "inglês", 8, 0, dataDeLancamento2);
        serie3 = new Serie(3, "Serie3", "ação", "português", 10, 0, dataDeLancamento3);
        cliente1 = new Cliente("nome", "usuario1", "senha1");

    }

    @Test
    void testAdicionarCliente() {
        plataforma.adicionarCliente(cliente1);
        
        assertEquals(1, plataforma.getClientes().size());
    }

    @Test
    void testLogin() {
        plataforma.adicionarCliente(cliente1);
        assertEquals(cliente1, plataforma.login("usuario1", "senha1"));
    }

    @Test
    void testAdicionarSerie() {
        plataforma.adicionarSerie(serie1);
        assertEquals(1, plataforma.getSeries().size());
    }

    @Test
    public void testFiltrarPorGenero() {
        plataforma.adicionarSerie(serie1);
        plataforma.adicionarSerie(serie2);
        plataforma.adicionarSerie(serie3);
        List<Serie> seriesAcao = plataforma.filtrarPorGenero("ação");
        assertEquals(2, seriesAcao.size());
        assertTrue(seriesAcao.contains(serie1));
        assertTrue(seriesAcao.contains(serie3));
    }

    @Test
    public void testFiltrarPorIdioma() {
        plataforma.adicionarSerie(serie1);
        plataforma.adicionarSerie(serie2);
        plataforma.adicionarSerie(serie3);
        List<Serie> seriesPortugues = plataforma.filtrarPorIdioma("português");
        assertEquals(2, seriesPortugues.size());
        assertTrue(seriesPortugues.contains(serie1));
        assertTrue(seriesPortugues.contains(serie3));
    }

    @Test
    public void testFiltrarPorQtdEpisodios() {
        plataforma.adicionarSerie(serie1);
        plataforma.adicionarSerie(serie2);
        plataforma.adicionarSerie(serie3);
        List<Serie> series10Episodios = plataforma.filtrarPorQtdEpisodios(10);
        assertEquals(2, series10Episodios.size());
        assertTrue(series10Episodios.contains(serie1));
        assertTrue(series10Episodios.contains(serie3));
    }
}
