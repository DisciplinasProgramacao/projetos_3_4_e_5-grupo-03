

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeriesTest {

    Serie serie;
    @BeforeEach
    public void setUp() {
        serie = new Serie("Halt and Catch Fire", "ação", "Inglês", 10, 0);

    }

    @Test
    public void registrarAudienciaTest() {
        for (int i = 0; i < 10000; i++) {
            serie.registrarAudiencia();
        }
        assertEquals(10000, serie.getAudiencia());
    }
    
    
}