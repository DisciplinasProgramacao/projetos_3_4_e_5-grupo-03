import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Midia(){
    }

    public Midia(int id, String nome, LocalDate dataLancamento, int genero, int idioma){
        this.id = id;
        this.nome=nome;
        this.dataLancamento = dataLancamento;
        this.genero = GENEROS.get(genero);
        this.idioma = IDIOMAS.get(idioma);
        
    }

    public Midia(int id, String nome, LocalDate dataLancamento) {
        this.id = id;
        this.nome=nome;
        this.dataLancamento = dataLancamento;
    }

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

    public int getQuantidadeEpisodios() {
        return -1;
    }


}