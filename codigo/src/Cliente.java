import java.util.List;

public class Cliente {
    String nomeDeUsuario;
    String senha;
    List<Serie> listaParaVer; 
    List<Serie> listaJaVistas; 

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

    public List<Serie> filtrarPorGenero(String genero) {
        // TODO metodo
        return listaJaVistas;
    }

    public List<Serie> filtrarPorIdioma(String idioma) {
        // TODO metodo
        return listaJaVistas;
    }
    
    public List<Serie> filtrarPorQtdEpisodios(int qtdEpisodios) {
        // TODO metodo
        return listaJaVistas;
    }

    /**
     * Registrar Serie na audiencia
     * @param serie
     */
    public void registrarAudiencia(Serie serie) {
        // Chamar método de audiencia na serie
        this.listaJaVistas.add(serie);
    }
}
