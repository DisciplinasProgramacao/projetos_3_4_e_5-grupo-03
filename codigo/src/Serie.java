import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A classe Serie representa uma série de TV e herda da classe Midia.
 * Implementa a interface Serializable para permitir a gravação de objetos da classe em arquivos.
 */
public class Serie extends Midia implements Serializable {
   
    private int quantidadeEpisodios;
   
    /**
    * Construtor padrão.
    */
    public Serie() {
        super();
    }

    /**
     * Construtor da classe Serie.
     * @param id Identificador único da série.
     * @param nome Nome da série.
     * @param dataLancamento Data de lançamento da série.
     * @param quantidadeEpisodios Quantidade de episódios da série.
    */
    public Serie(int id, String nome, LocalDate dataLancamento, int quantidadeEpisodios) {

        if(nome.length() < 3) {
            throw new RuntimeException("O nome da Serie deve possuir mais de 3 caracteres!");
        } else if(dataLancamento > LocalDate.now().format("dd/MM/yyyy")) {
            throw new RuntimeException("O lançamento da Serie não pode ser uma data futura!");
        } else if(quantidadeEpisodios < 1) {
            throw new RuntimeException("A quantidade de episódios não pode ser 0!");
        }

        super(id, nome, dataLancamento);
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Construtor alternativo da classe Serie.
     * @param id Identificador único da série.
     * @param nome Nome da série.
     * @param string Parametro não utilizado.
     * @param string2 Parametro não utilizado.
     * @param i Parametro não utilizado.
     * @param j Parametro não utilizado.
     * @param dataLancamento Data de lançamento da série.
     */
    public Serie(int id, String nome, String string, String string2, int i, int j,
            LocalDate dataLancamento) {
                super(id, nome, dataLancamento);
                this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Retorna a quantidade de episódios da série.
     * @return A quantidade de episódios.
     */
    @Override
    public int getQuantidadeEpisodios() {
        return this.quantidadeEpisodios;
    }
    
    
    /**
     * Define a quantidade de episódios da série.
     * @param quantidadeEpisodios A quantidade de episódios.
     * @throws Error se a quantidade de episódios for menor que 2.
     */
    public void setQuantidadeEpisodios(int quantidadeEpisodios) {
        if(quantidadeEpisodios < 2){
            throw new Error("O número mínimo de episódios deve ser 2");
        }
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Salva a série em um arquivo chamado "serie.txt".
     * @throws IOException Se ocorrer um erro durante a gravação do arquivo.
     */
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
