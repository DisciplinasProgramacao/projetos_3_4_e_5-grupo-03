import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {
    private Filme filme;

    @BeforeEach
    void setUp() throws InvalidParameterException {
        filme = new Filme(1, "Filme Teste", LocalDate.of(2021, 1, 1), 120);
    }

    @Test
    void getDuracaoTest() {
        int duracao = filme.getDuracao();
        assertEquals(120, duracao);
    }

    @Test
    void toStringTest() {
        String resultadoEsperado = "1;Filme Teste;2021-01-01;120";
        String resultadoObtido = filme.toString();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void construtorDuracaoInvalidaTest() {
        assertThrows(InvalidParameterException.class, () -> {
            new Filme(2, "Filme Invalido", LocalDate.of(2021, 1, 1), 5);
        });
    }
}
