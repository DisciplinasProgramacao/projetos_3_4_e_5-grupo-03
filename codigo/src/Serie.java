import java.util.List;

public class Serie {
    private static final List<String> GENEROS;
    private String nome;
    private String genero;
    private String idioma;
    private int quantidadeEpisodios;

    public Serie() {
    }
    private int audiencia;

    public void registrarAudiencia(){
        audiencia++;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return this.quantidadeEpisodios;
    }

    public void setQuantidadeEpisodios(int quantidadeEpisodios) {
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    public int getAudiencia() {
        return this.audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    public Serie(String nome, String genero, String idioma, int quantidadeEpisodios, int audiencia) {
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.quantidadeEpisodios = quantidadeEpisodios;
        this.audiencia = audiencia;
    }


}
