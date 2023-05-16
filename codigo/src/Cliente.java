import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
Classe Cliente que representa um cliente na plataforma de streaming.
*/
public class Cliente {
    private String nome;
    private String nomeDeUsuario;
    private String senha;
    private List<Midia> listaParaVer; 
    private List<Midia> listaJaVistas; 
    private List<Avaliacao> listaNotas;
    private List<LocalDate> datasSeriesAssistidas;

    /**
    Construtor da classe Cliente.
    @param nome Nome completo do cliente.
    @param nomeDeUsuario Nome de usuário do cliente.
    @param senha Senha do cliente.
    */
    public Cliente(String nome, String nomeDeUsuario, String senha) {

        if(nome.length() < 2) {
            throw new RuntimeException("O nome do Cliente deve possuir mais de 2 caracteres!");
        } else if(nomeDeUsuario.length() < 3) {
            throw new RuntimeException("O nome do Cliente deve possuir mais de 5 caracteres!");
        } else if(senha.length() < 6) {
            throw new RuntimeException("A senha deve possuir no minimo 10 caracteres!");
        }

        this.nome = nome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.listaParaVer = new ArrayList<>();
        this.listaJaVistas = new ArrayList<>();
        this.listaNotas = new ArrayList<>();
        this.datasSeriesAssistidas = new ArrayList<>();
    }

    /**
    Adiciona uma media à lista de midias para assistir do cliente.
    @param midia A midia a ser adicionada à lista.
    */
    public void adicionarNaLista(Midia midia) {
        this.listaParaVer.add(midia);
    }

    /**
    Remove uma série da lista de séries para assistir do cliente.
    @param midia A série a ser removida da lista.
    */
    public void retirarDaLista(Midia midia) {
        this.listaParaVer.remove(midia);
    }

    /**
    Filtra a lista de séries para assistir do cliente por gênero.
    @param genero O gênero pelo qual filtrar as séries.
    @return Uma lista das séries filtradas por gênero.
    */
    public List<Midia> filtrarPorGenero(String genero) {
        return this.listaParaVer.stream()
        .filter(s -> s.getGenero().toLowerCase().equals(genero))
        .toList();
    }

    /**
    Filtra a lista de séries para assistir do cliente por idioma.
    @param idioma O idioma pelo qual filtrar as séries.
    @return Uma lista das séries filtradas por idioma.
    */
    public List<Midia> filtrarPorIdioma(String idioma) {
        return this.listaParaVer.stream()
        .filter(s -> s.getIdioma().equals(idioma))
        .toList();
    }
    
    /**
    Filtra a lista de séries para assistir do cliente pela quantidade de episódios.
    @param qtdEpisodios A quantidade de episódios pelo qual filtrar as séries.
    @return Uma lista das séries filtradas pela quantidade de episódios.
    */
    public List<Midia> filtrarPorQtdEpisodios(int qtdEpisodios) {
        return this.listaParaVer.stream()
        .filter(s -> s.getQuantidadeEpisodios() == qtdEpisodios)
        .toList();
    }

    /**
    Registra a audiência de uma série na lista de séries já vistas do cliente.
    @param midia A série cuja audiência será registrada.
    */
    public void registrarAudiencia(Midia midia) {
        if (!this.listaJaVistas.contains(midia)) {
            this.listaJaVistas.add(midia);
            midia.registrarAudiencia();
            this.datasSeriesAssistidas.add(LocalDate.now());
        }
    }

    /**
    Adiciona uma midia à lista de avaliacoes do cliente.
    @param avaliacao A midia a ser adicionada à lista.
    */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        try {
            this.listaNotas.add(avaliacao);
        } catch(RuntimeException addAvaliacaoCException) {
            System.out.println(addAvaliacaoCException.getMessage());
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return this.listaNotas;
    }

    public List<LocalDate> getDatasSeriesAssistidas() {
        return this.datasSeriesAssistidas;
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

    public List<Midia> getListaParaVer() {
        return this.listaParaVer;
    }

    public void setListaParaVer(List<Midia> listaParaVer) {
        this.listaParaVer = listaParaVer;
    }

    public List<Midia> getListaJaVistas() {
        return this.listaJaVistas;
    }

    public void setListaJaVistas(List<Midia> listaJaVistas) {
        this.listaJaVistas = listaJaVistas;
    }


}
