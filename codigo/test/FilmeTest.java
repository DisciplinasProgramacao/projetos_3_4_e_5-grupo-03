import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.DuracaoFilmeException;
import exceptions.MidiaDataException;
import exceptions.MidiaException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {
    private Filme filme;

    @BeforeEach
    void setUp() throws MidiaException, MidiaDataException, DuracaoFilmeException {
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
        assertThrows(DuracaoFilmeException.class, () -> {
            new Filme(2, "Filme Invalido", LocalDate.of(2021, 1, 1), 5);
        });
    }
}
