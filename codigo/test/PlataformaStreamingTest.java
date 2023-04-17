import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlataformaStreamingTest {
    Serie serie;
    Cliente cliente;
    PlataformaStreaming net;

    @BeforeEach
    public void setUp() {
        serie = new Serie("Lost", "drama", "Portugues", 10, 0);
        cliente = new Cliente("Nome", "123");
        net = new PlataformaStreaming("TesteFlix");
    }

    @Test
    void testAdicionarCliente() {
        net.adicionarCliente(cliente);
        
        assertEquals(1, net.getClientes().size());
    }

    @Test
    void testLogin() {
        net.adicionarCliente(cliente);
        assertEquals(cliente, net.login("Nome", "123"));
    }

    @Test
    void testAdicionarSerie() {
        net.adicionarSerie(serie);
        assertEquals(1, net.getSeries().size());
    }
}
