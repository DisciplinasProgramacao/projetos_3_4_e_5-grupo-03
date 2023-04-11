import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class ClienteTest {
    Cliente cliente;
    Serie serie, serie2;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Nome", "123");
        serie = new Serie("Teste", "Terror", "Portugues", 12, 100);
        serie2 = new Serie("Teste2", "Humor", "Ingles", 15, 200);
        
        cliente.adicionarNaLista(serie);
        cliente.adicionarNaLista(serie2);
    }

    @Test
    void testAdicionarNaLista() {
        assertEquals(cliente.listaParaVer.size(), 1);
    }

    @Test
    void testRetirarDaLista() {
        assertEquals(cliente.listaParaVer.size(), 1);
        cliente.retirarDaLista(serie);
        assertEquals(cliente.listaParaVer.size(), 0);
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
}