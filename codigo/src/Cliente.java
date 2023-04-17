import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nomeDeUsuario;
    String senha;
    List<Serie> listaParaVer; 
    List<Serie> listaJaVistas; 

    public Cliente(String nomeDeUsuario, String senha) {
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.listaParaVer = new ArrayList<>();
        this.listaJaVistas = new ArrayList<>();
    }

    /**
     * Adiciona Serie na lista de filmes para ver
     * @param serie
     */
    public void adicionarNaLista(Serie serie) {
        this.listaParaVer.add(serie);
    }

    /**
     * Remover Serie na lista de filmes para ver
     * @param serie
     */
    public void retirarDaLista(Serie serie) {
        this.listaParaVer.remove(serie);
    }

    /**
     * Filtra Series para ver pelo genero
     * @param genero
     * @return
     */
    public List<Serie> filtrarPorGenero(String genero) {
        return this.listaParaVer.stream()
        .filter(s -> s.getGenero().equals(genero))
        .toList();
    }

    /**
     * Filtra Series para ver pelo idioma
     * @param idioma
     * @return
     */
    public List<Serie> filtrarPorIdioma(String idioma) {
        return this.listaParaVer.stream()
        .filter(s -> s.getIdioma().equals(idioma))
        .toList();
    }
    
    /**
     * Filtra Series para ver pela quantidade de epsódios
     * @param qtdEpisodios
     * @return
     */
    public List<Serie> filtrarPorQtdEpisodios(int qtdEpisodios) {
        return this.listaParaVer.stream()
        .filter(s -> s.getQuantidadeEpisodios() == qtdEpisodios)
        .toList();
    }

    /**
     * Registrar Serie na audiencia
     * @param serie
     */
    public void registrarAudiencia(Serie serie) {
        if (!this.listaJaVistas.contains(serie)) {
            this.listaJaVistas.add(serie);
            serie.registrarAudiencia();
        }
    }

    public String getNomeUsuario() {
        return this.nomeDeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }
}
