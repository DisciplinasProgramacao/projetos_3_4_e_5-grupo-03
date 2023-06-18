package app.midias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    private Serie serie;

    @BeforeEach
    void setUp() throws InvalidParameterException {
        serie = new Serie(1, "Série Teste", LocalDate.of(2021, 1, 1), 10);
    }

    @Test
    void getQuantidadeEpisodiosTest() {
        int quantidadeEpisodios = serie.getQuantidadeEpisodios();
        assertEquals(10, quantidadeEpisodios);
    }

    @Test
    void setQuantidadeEpisodiosTest() {
        try {
            serie.setQuantidadeEpisodios(20);
            int novaQuantidadeEpisodios = serie.getQuantidadeEpisodios();
            assertEquals(20, novaQuantidadeEpisodios);
        } catch (InvalidParameterException e) {
            fail("Exceção QuantidadeMinimaEpException não deveria ter sido lançada.");
        }
    }

    @Test
    void setQuantidadeEpisodiosQuantidadeMinimaTest() {
        assertThrows(InvalidParameterException.class, () -> {
            serie.setQuantidadeEpisodios(1);
        });
    }

    @Test
    void toStringTest() {
        String resultadoEsperado = "1;Série Teste;2021-01-01";
        String resultadoObtido = serie.toString();
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}
