import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PlataformaStreamingTest {
    private PlataformaStreaming plataforma;

    @BeforeEach
    void setUp() {
        plataforma = new PlataformaStreaming("Plataforma Teste", true);
        
        // Adicionar clientes
        Cliente cliente1 = new Cliente("João Silva", "joaosilva", "123456");
        Cliente cliente2 = new Cliente("Maria Souza", "mariasouza", "789012");
        plataforma.adicionarCliente(cliente1);
        plataforma.adicionarCliente(cliente2);

        // Adicionar mídias
        Filme filme1 = new Filme(1, "Filme 1", LocalDate.of(2020, 1, 1), 120);
        Filme filme2 = new Filme(2, "Filme 2", LocalDate.of(2021, 1, 1), 150);
        Serie serie1 = new Serie(3, "Serie 1", "", "", 0, 0, LocalDate.of(2020, 1, 1));
        Serie serie2 = new Serie(4, "Serie 2", "", "", 0, 0, LocalDate.of(2021, 1, 1));

        plataforma.adicionarFilme(filme1);
        plataforma.adicionarFilme(filme2);
        plataforma.adicionarSerie(serie1);
        plataforma.adicionarSerie(serie2);
    }

    @Test
    void testeLogin() {
        Cliente cliente = plataforma.login("joaosilva", "123456");
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
    }

    @Test
    void testeAdicionarCliente() {
        boolean clienteAdicionado = plataforma.adicionarCliente("Jane Doe", "janedoe", "54321");
        assertTrue(clienteAdicionado, "Deve adicionar o cliente com sucesso");
    }

    @Test
    void testeAdicionarClienteExistente() {
        plataforma.adicionarCliente("Jane Doe", "janedoe", "54321");
        boolean clienteAdicionado = plataforma.adicionarCliente("Jane Doe", "janedoe", "54321");
        assertFalse(clienteAdicionado, "Não deve adicionar o cliente, pois já existe um cliente com o mesmo nome de usuário");
    }
}