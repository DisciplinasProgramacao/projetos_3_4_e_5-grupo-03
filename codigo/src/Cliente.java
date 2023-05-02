import java.util.ArrayList;
import java.util.List;


/**
Classe Cliente que representa um cliente na plataforma de streaming.
*/
public class Cliente {
    String nome;
    String nomeDeUsuario;
    String senha;
    List<Serie> listaParaVer; 
    List<Serie> listaJaVistas; 

    /**
    Construtor da classe Cliente.
    @param nome Nome completo do cliente.
    @param nomeDeUsuario Nome de usuário do cliente.
    @param senha Senha do cliente.
    */
    public Cliente(String nome, String nomeDeUsuario, String senha) {
        this.nome = nome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.listaParaVer = new ArrayList<>();
        this.listaJaVistas = new ArrayList<>();
    }

    /**
    Adiciona uma série à lista de séries para assistir do cliente.
    @param serie A série a ser adicionada à lista.
    */
    public void adicionarNaLista(Serie serie) {
        this.listaParaVer.add(serie);
    }

    /**
    Remove uma série da lista de séries para assistir do cliente.
    @param serie A série a ser removida da lista.
    */
    public void retirarDaLista(Serie serie) {
        this.listaParaVer.remove(serie);
    }

    /**
    Filtra a lista de séries para assistir do cliente por gênero.
    @param genero O gênero pelo qual filtrar as séries.
    @return Uma lista das séries filtradas por gênero.
    */
    public List<Serie> filtrarPorGenero(String genero) {
        return this.listaParaVer.stream()
        .filter(s -> s.getGenero().toLowerCase().equals(genero))
        .toList();
    }

    /**
    Filtra a lista de séries para assistir do cliente por idioma.
    @param idioma O idioma pelo qual filtrar as séries.
    @return Uma lista das séries filtradas por idioma.
    */
    public List<Serie> filtrarPorIdioma(String idioma) {
        return this.listaParaVer.stream()
        .filter(s -> s.getIdioma().equals(idioma))
        .toList();
    }
    
    /**
    Filtra a lista de séries para assistir do cliente pela quantidade de episódios.
    @param qtdEpisodios A quantidade de episódios pelo qual filtrar as séries.
    @return Uma lista das séries filtradas pela quantidade de episódios.
    */
    public List<Serie> filtrarPorQtdEpisodios(int qtdEpisodios) {
        return this.listaParaVer.stream()
        .filter(s -> s.getQuantidadeEpisodios() == qtdEpisodios)
        .toList();
    }

    /**
    Registra a audiência de uma série na lista de séries já vistas do cliente.
    @param serie A série cuja audiência será registrada.
    */
    public void registrarAudiencia(Serie serie) {
        if (!this.listaJaVistas.contains(serie)) {
            this.listaJaVistas.add(serie);
            serie.registrarAudiencia();
        }
    }

    // Getters e setters para os atributos da classe Cliente
    public String getNomeUsuario() {
        return this.nomeDeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDeUsuario() {
        return this.nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Serie> getListaParaVer() {
        return this.listaParaVer;
    }

    public void setListaParaVer(List<Serie> listaParaVer) {
        this.listaParaVer = listaParaVer;
    }

    public List<Serie> getListaJaVistas() {
        return this.listaJaVistas;
    }

    public void setListaJaVistas(List<Serie> listaJaVistas) {
        this.listaJaVistas = listaJaVistas;
    }


}
