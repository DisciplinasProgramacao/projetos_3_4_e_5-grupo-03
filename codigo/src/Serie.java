import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serie extends Midia{
   
    private int quantidadeEpisodios;
   
    public Serie() {
        super();
    }

    public Serie(int id, String nome, LocalDate dataLancamento, int quantidadeEpisodios) {
        super(id, nome, dataLancamento);
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    public Serie(int idSerie, String nomeSerie, String string, String string2, int i, int j,
            LocalDate dataDeLancamento) {
    }

    public int getQuantidadeEpisodios() {
        return this.quantidadeEpisodios;
    }

    public void setQuantidadeEpisodios(int quantidadeEpisodios) {
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

}
