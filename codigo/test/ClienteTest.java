import exceptions.ClienteAvaliaException;
import exceptions.ClienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.LocalDate;

class ClienteTest {

    private Cliente cliente;
    private Serie serie1;
    private Serie serie2;

    @BeforeEach
    public void setUp() throws ClienteException, InvalidParameterException, ClienteAvaliaException {
        cliente = new Cliente("Nome", "usuario1", "senha12345");
        serie1 = new Serie(3, "Serie 1", 0, 0, 20, LocalDate.of(2020, 1, 1));
        serie2 = new Serie(4, "Serie 2", 1, 1, 10, LocalDate.of(2021, 1, 1));
        cliente.adicionarNaLista(serie1);
        cliente.adicionarNaLista(serie2);
        cliente.registrarAudiencia(serie1);
    }

    @Test
    public void testAdicionarNaLista() {
        Serie serie3 = new Serie(5, "Serie 3", LocalDate.of(2022, 1, 1), 15);
        cliente.adicionarNaLista(serie3);
        Assertions.assertEquals(3, cliente.getListaParaVer().size());
        Assertions.assertTrue(cliente.getListaParaVer().contains(serie3));
    }

    @Test
    public void testRetirarDaLista() {
        Assertions.assertEquals(2, cliente.getListaParaVer().size());
        cliente.retirarDaLista(serie1);
        Assertions.assertEquals(1, cliente.getListaParaVer().size());
        Assertions.assertFalse(cliente.getListaParaVer().contains(serie1));
        cliente.retirarDaLista(serie2);
        Assertions.assertEquals(0, cliente.getListaParaVer().size());
        Assertions.assertFalse(cliente.getListaParaVer().contains(serie2));
        cliente.retirarDaLista(serie2);
        Assertions.assertEquals(0, cliente.getListaParaVer().size());
    }

    @Test
    public void testFiltrarPorGeneroExistente() {
        Assertions.assertEquals(1, cliente.filtrarPorGenero("Ação").size());
        Assertions.assertTrue(cliente.filtrarPorGenero("Ação").contains(serie1));
    }

    @Test
    public void testFiltrarPorGeneroInexistente() {
        Assertions.assertEquals(0, cliente.filtrarPorGenero("Terror").size());
    }

    @Test
    public void testFiltrarPorIdiomaExistente() {
        Assertions.assertEquals(1, cliente.filtrarPorIdioma("Inglês").size());
        Assertions.assertTrue(cliente.filtrarPorIdioma("Inglês").contains(serie1));
    }

    @Test
    public void testFiltrarPorIdiomaInexistente() {
        Assertions.assertEquals(0, cliente.filtrarPorIdioma("Espanhol").size());
    }

    @Test
    public void testFiltrarPorQtdEpisodiosExistente() {
        Assertions.assertEquals(1, cliente.filtrarPorQtdEpisodios(10).size());
        Assertions.assertTrue(cliente.filtrarPorQtdEpisodios(10).contains(serie2));
    }

    @Test
    public void testFiltrarPorQtdEpisodiosInexistente() {
        Assertions.assertEquals(0, cliente.filtrarPorQtdEpisodios(5).size());
    }

    @Test
    public void testRegistrarAudiencia() {
        cliente.registrarAudiencia(serie1);
        Assertions.assertEquals(1, cliente.getListaJaVistas().size());
        cliente.registrarAudiencia(serie1);
        Assertions.assertEquals(1, cliente.getListaJaVistas().size());
        cliente.registrarAudiencia(serie2);
        Assertions.assertEquals(2, cliente.getListaJaVistas().size());
    }

    @Test
    public void testPodeAvaliarMidia() throws ClienteAvaliaException {
        Assertions.assertTrue(cliente.podeAvaliarMidia(serie1));
        cliente.avaliarMidia(4.5, serie2); // Avalia a série 2
        Assertions.assertFalse(cliente.podeAvaliarMidia(serie2)); // Não permite avaliar uma série já avaliada
    }

    @Test
    public void testAvaliarMidia() throws InvalidParameterException, ClienteAvaliaException {
        cliente.avaliarMidia(4.5, serie1);
        Assertions.assertEquals(1, cliente.getListaNotas().size());
        Assertions.assertEquals(1, serie1.getAvaliacoes().size());
    }
}
