import java.time.LocalDate;

import exceptions.DuracaoFilmeException;
import exceptions.MidiaDataException;
import exceptions.MidiaException;

/**
 * A classe Filme representa um filme e herda da classe Midia.
 */
public class Filme extends Midia{

    private int duracao;

    /**
     * Construtor padrão da classe Filme.
     */
    public Filme(){
        super();
    }

    /**
     * Construtor da classe Filme.
     * @param id Identificador único do filme.
     * @param nome Nome do filme.
     * @param dataLancamento Data de lançamento do filme.
     * @param duracao Duração do filme em minutos.
     * @throws DuracaoFilmeException
     * @throws MidiaDataException
     * @throws MidiaException
     */
    public Filme(int id,String nome, LocalDate dataLancamento, int duracao) throws DuracaoFilmeException, MidiaException, MidiaDataException{

        super(id,nome, dataLancamento);
        if(duracao < 10) {
            throw new DuracaoFilmeException();
        }
        this.duracao = duracao;
    }

        /**
     * Construtor da classe Filme.
     * @param id Identificador único do filme.
     * @param nome Nome do filme.
     * @param dataLancamento Data de lançamento do filme.
     * @param duracao Duração do filme em minutos.
     * @param genero Genero do filme.
     * @throws DuracaoFilmeException
     * @throws MidiaDataException
     * @throws MidiaException
     */
    public Filme(int id,String nome, LocalDate dataLancamento, int duracao, int genero, int idioma) throws DuracaoFilmeException, MidiaException, MidiaDataException{

        super(id,nome, dataLancamento, genero, idioma);
        if(duracao < 10) {
            throw new DuracaoFilmeException();
        }
        this.duracao = duracao;
    }

    
    /**
     * Retorna a duração do filme.
     * @return A duração do filme em minutos.
     */
    public int getDuracao() {
        return this.duracao;
    }

    
    /**
     * Retorna uma String com os dados do filme.
     * @return Uma String com os dados do filme.
     */
    @Override
    public String toString() {
        // 9573;Complexity Of A Nuclear Winter;07/07/2022;97
        return this.getId() + ";" + this.getNome() + ";" + this.getDataLancamento() + ";" + this.getDuracao();
    }
}