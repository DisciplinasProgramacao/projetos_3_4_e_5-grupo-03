import java.time.LocalDate;

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
     */
    public Filme(int id,String nome, LocalDate dataLancamento, int duracao){

        super(id,nome, dataLancamento);
        if(duracao < 10) {
            throw new RuntimeException("A duração do Filme não pode ser menor que 10 minutos!");
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

}