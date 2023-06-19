package app;
import app.clientes.Cliente;
import app.midias.Filme;
import app.midias.Midia;
import app.midias.Serie;
import app.exceptions.ClienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlataformaStreamingTest {
    private PlataformaStreaming plataforma;

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
    }

    @Test
    void testeLogin() {
        Cliente cliente = plataforma.login("joaosilva", "123456");
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
    }

    @Test
    void testeAdicionarCliente() throws ClienteException {
        boolean clienteAdicionado = plataforma.adicionarCliente("Jane Doe", "janedoe", "5432167");
        assertTrue(clienteAdicionado, "Deve adicionar o cliente com sucesso");
    }

    @Test
    void testeAdicionarClienteExistente() throws ClienteException {
        plataforma.adicionarCliente("Jane Doe", "janedoe", "543267");
        boolean clienteAdicionado = plataforma.adicionarCliente("Jane Doe", "janedoe", "54321");
        assertFalse(clienteAdicionado, "Não deve adicionar o cliente, pois já existe um cliente com o mesmo nome de usuário");
    }

    @Test
    void testeFiltrarPorGeneroExistente() {
        String genero = "Ação";
        List<Midia> midiasFiltradas = plataforma.filtrarPorGenero(genero);
        assertFalse(midiasFiltradas.isEmpty(), "A lista de mídias filtradas não deve estar vazia");

        for (Midia midia : midiasFiltradas) {
            assertEquals(genero, midia.getGenero(), "A mídia filtrada deve ter o gênero esperado");
        }
    }

    @Test
    void testeFiltrarPorGeneroInexistente() {
        String genero = "Comédia";
        List<Midia> midiasFiltradas = plataforma.filtrarPorGenero(genero);
        assertTrue(midiasFiltradas.isEmpty(), "A lista de mídias filtradas deve estar vazia");
    }

    @Test
    void testeFiltrarPorIdiomaExistente() {
        List<Midia> midiasIngles = plataforma.filtrarPorIdioma("inglês");
        List<Midia> midiasPortugues = plataforma.filtrarPorIdioma("português");
        List<Midia> midiasEspanhol = plataforma.filtrarPorIdioma("espanhol");

        // Verifica se a lista de mídias em inglês contém apenas mídias nesse idioma
        assertTrue(midiasIngles.stream().allMatch(m -> m.getIdioma().equalsIgnoreCase("inglês")));
        // Verifica se a lista de mídias em português contém apenas mídias nesse idioma
        assertTrue(midiasPortugues.stream().allMatch(m -> m.getIdioma().equalsIgnoreCase("português")));
        // Verifica se a lista de mídias em espanhol contém apenas mídias nesse idioma
        assertTrue(midiasEspanhol.stream().allMatch(m -> m.getIdioma().equalsIgnoreCase("espanhol")));
    }

    @Test
    void testeFiltrarPorIdiomaInexistente() {
        List<Midia> midiasFrances = plataforma.filtrarPorIdioma("francês");

        // Verifica se a lista de mídias em francês está vazia
        assertTrue(midiasFrances.isEmpty());
    }

    @Test
    void testeFiltrarPorQtdEpisodiosExistente() {
        List<Midia> midias10Episodios = plataforma.filtrarPorQtdEpisodios(10);
        List<Midia> midias20Episodios = plataforma.filtrarPorQtdEpisodios(20);

        // Verifica se a lista de mídias com 10 episódios contém apenas mídias com essa quantidade de episódios
        assertTrue(midias10Episodios.stream().allMatch(m -> m.getQuantidadeEpisodios() == 10));
        // Verifica se a lista de mídias com 20 episódios contém apenas mídias com essa quantidade de episódios
        assertTrue(midias20Episodios.stream().allMatch(m -> m.getQuantidadeEpisodios() == 20));
    }

    @Test
    void testeFiltrarPorQtdEpisodiosInexistente() {
        List<Midia> midias40Episodios = plataforma.filtrarPorQtdEpisodios(40);

        // Verifica se a lista de mídias com 40 episódios está vazia
        assertTrue(midias40Episodios.isEmpty());
    }

    
}