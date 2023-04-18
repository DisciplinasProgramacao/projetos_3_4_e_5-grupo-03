

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeriesTest {

    Serie serie;
    @BeforeEach
    public void setUp() {
        LocalDate dataDeLancamento = LocalDate.of(2021, 1, 1);
        serie = new Serie(1,"Halt and Catch Fire", "ação", "Inglês", 10, 0, dataDeLancamento);

    }

    @Test
    public void registrarAudienciaTest() {
        for (int i = 0; i < 10000; i++) {
            serie.registrarAudiencia();
        }
        assertEquals(10000, serie.getAudiencia());
    }
    
    
}