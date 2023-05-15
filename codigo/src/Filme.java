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

        if(nome.length() < 3) {
            throw new RuntimeException("O nome do filme deve possuir mais de 3 caracteres!")
        } else if(dataLancamento > LocalDate.now().format("dd/MM/yyyy")) {
            throw new RuntimeException("O lançamento do filme não pode ser uma data futura!")
        } else if(duracao < 10) {
            throw new RuntimeException("A duração do filme não pode ser menor que 10 minutos!")
        }
        super(id,nome, dataLancamento);
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