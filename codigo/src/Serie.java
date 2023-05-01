import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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


    public Serie(int id, String nome, String string, String string2, int i, int j,
            LocalDate dataLancamento) {
                super(id, nome, dataLancamento);
                this.quantidadeEpisodios = quantidadeEpisodios;
    }

    @Override
    public int getQuantidadeEpisodios() {
        return this.quantidadeEpisodios;
    }
    
    

    public void setQuantidadeEpisodios(int quantidadeEpisodios) {
        if(quantidadeEpisodios){
            throw new Error("O número mínimo de episódios deve ser 2")
        }
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

}
