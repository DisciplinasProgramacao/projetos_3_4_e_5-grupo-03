import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.MidiaDataException;
import exceptions.MidiaException;
import exceptions.QuantidadeMinimaEpException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    private Serie serie;

    @BeforeEach
    void setUp() throws MidiaException, MidiaDataException {
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
        } catch (QuantidadeMinimaEpException e) {
            fail("Exceção QuantidadeMinimaEpException não deveria ter sido lançada.");
        }
    }

    @Test
    void setQuantidadeEpisodiosQuantidadeMinimaTest() {
        assertThrows(QuantidadeMinimaEpException.class, () -> {
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
