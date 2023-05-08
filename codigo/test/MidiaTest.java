import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste para a classe Midia.
 */
public class MidiaTest {

    private Cliente cliente;
    private Filme filme;
    private Avaliacao avaliacao;

    /**
     * Configuração inicial para os testes.
     */
    @BeforeEach
    public void setUp() {
        cliente = new Cliente("John", "john@puc.com", "senha123");
        filme = new Filme(1, "Matrix", LocalDate.of(1999, 3, 31), 160);
        avaliacao = new Avaliacao(cliente, filme, 9.0);
    }

    /**
     * Testa a adição de uma avaliação à mídia.
     */
    @Test
    public void testAdicionarAvaliacao() {
        assertTrue(filme.getAvaliacoes().isEmpty());
        filme.adicionarAvaliacao(avaliacao);
        assertEquals(1, filme.getAvaliacoes().size());
        assertEquals(avaliacao, filme.getAvaliacoes().get(0));
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
    public void testCalcularMediaDeNotasComUmaAvaliacao() {
        filme.adicionarAvaliacao(avaliacao);
        assertEquals(avaliacao.getNota(), filme.calcularMediaDeNotas());
    }

    /**
     * Testa o cálculo da média de notas com múltiplas avaliações.
     */
    @Test
    public void testCalcularMediaDeNotasComMultiplasAvaliacoes() {
        filme.adicionarAvaliacao(avaliacao);

        Avaliacao avaliacao2 = new Avaliacao(cliente, filme, 7.0);
        filme.adicionarAvaliacao(avaliacao2);

        double mediaEsperada = (avaliacao.getNota() + avaliacao2.getNota()) / 2;
        assertEquals(mediaEsperada, filme.calcularMediaDeNotas());
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