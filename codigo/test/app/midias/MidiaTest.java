package app.midias;
import app.clientes.Cliente;
import app.exceptions.ClienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de teste para a classe midia.Midia.
 */
public class MidiaTest {

    private Cliente cliente;
    private Filme filme;
    private Serie serie;
    private Avaliacao avaliacao;

    /**
     * Configuração inicial para os testes.
     * @throws ClienteException
     */
    @BeforeEach
    public void setUp() throws ClienteException, InvalidParameterException {
        LocalDate dataDeLancamento1 = LocalDate.of(2021, 1, 1);
        cliente = new Cliente("John", "john@puc.com", "senha123");
        filme = new Filme(1, "Matrix", LocalDate.of(1999, 3, 31), 160);
        serie = new Serie(1, "Serie1", 4, 2, 10, dataDeLancamento1);

        cliente.adicionarNaLista(filme);
        cliente.adicionarNaLista(serie);

        avaliacao = new Avaliacao(cliente, filme, 9.0);
    }


    /**
     * Testa o cálculo da média de notas sem avaliações.
     */
    @Test
    public void testCalcularMediaDeNotasSemAvaliacoes() {
        assertEquals(0, filme.calcularMediaDeNotas());
    }

    /**
     * Testa o cálculo da média de notas com uma avaliação.
     */
    @Test
    public void testCalcularMediaDeNotasComUmaAvaliacao() throws InvalidParameterException {
        filme.adicionarAvaliacao(avaliacao);
        assertEquals(avaliacao.getNota(), filme.calcularMediaDeNotas());
    }

    /**
     * Testa o registro de audiência.
     */
    @Test
    public void testRegistrarAudiencia() {
        assertEquals(0, filme.getAudiencia());

        filme.registrarAudiencia();
        assertEquals(1, filme.getAudiencia());
    }
}