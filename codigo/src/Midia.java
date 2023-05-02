import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe abstrata Midia que representa uma mídia genérica.
 */
public abstract class Midia {

    private int id;
    private String nome;
    private int audiencia = 0;
    private LocalDate dataLancamento;
    private String genero;
    private String idioma;
    private static final List<String> GENEROS = new ArrayList<>(Arrays.asList(
        "ação",
        "comédia",
        "suspense",
        "terror",
        "romance",
        "drama",
        "ficção cinetífica"
    )); 
    private static final List<String> IDIOMAS = new ArrayList<>(Arrays.asList(
        "inglês", "português", "espanhol"
    ));

    /**
     * Construtor padrão da classe Midia.
     */
    public Midia(){
    }

    /**
     * Construtor da classe Midia.
     * @param id Identificador único da mídia.
     * @param nome Nome da mídia.
     * @param dataLancamento Data de lançamento da mídia.
     * @param genero Índice do gênero da mídia na lista de gêneros disponíveis.
     * @param idioma Índice do idioma da mídia na lista de idiomas disponíveis.
     */
    public Midia(int id, String nome, LocalDate dataLancamento, int genero, int idioma){
        this.id = id;
        this.nome=nome;
        this.dataLancamento = dataLancamento;
        this.genero = GENEROS.get(genero);
        this.idioma = IDIOMAS.get(idioma);
        
    }

    /**
     * Construtor da classe Midia.
     * @param id Identificador único da mídia.
     * @param nome Nome da mídia.
     * @param dataLancamento Data de lançamento da mídia.
     */
    public Midia(int id, String nome, LocalDate dataLancamento) {
        this.id = id;
        this.nome=nome;
        this.dataLancamento = dataLancamento;
    }


    public void avaliacao(int nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 1 e 5.");
        }
        notas.add(nota);
    }

    public double getMediaAvaliacao() {
        if (avaliacoes.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (int avaliacoes : notas) {
            soma += nota;
        }
        return soma / avaliacoes.size();
    }
    
    /**
     * Registra a audiência da mídia.
     */
    public void registrarAudiencia(){
        this.audiencia++;
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAudiencia() {
        return this.audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Retorna a quantidade de episódios da mídia.
     * @return -1, já que a classe Midia é abstrata e não possui episódios.
    */
    public int getQuantidadeEpisodios() {
        return -1;
    }


}