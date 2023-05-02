import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Serie extends Midia implements Serializable {
   
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
        if(quantidadeEpisodios < 2){
            throw new Error("O número mínimo de episódios deve ser 2");
        }
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    public void save() throws IOException {
		File file = new File("serie.txt");
		if (file.exists())
			file.delete();
        FileOutputStream arquivoGrav = new FileOutputStream(file, false); 
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

        objGravar.writeObject(this);
        objGravar.flush();
        objGravar.close();
        arquivoGrav.flush();
        arquivoGrav.close();
    }
}
