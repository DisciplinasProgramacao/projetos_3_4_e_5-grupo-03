package app.clientes;
import app.midias.Avaliacao;
import app.midias.Midia;
import app.exceptions.ClienteAvaliaException;
import app.exceptions.ClienteException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
Classe app.app.clientes.Cliente que representa um cliente na plataforma de streaming.
*/
public class Cliente {
    private String nome;
    private String nomeDeUsuario;
    private String senha;
    private List<Midia> listaParaVer;
    private List<Midia> listaJaVistas;

    private List<Midia> listaDesejos;

    private List<Avaliacao> listaNotas;
    private List<LocalDate> datasSeriesAssistidas;

    /**
    Construtor da classe app.app.clientes.Cliente.
    @param nome Nome completo do cliente.
    @param nomeDeUsuario Nome de usuário do cliente.
    @param senha Senha do cliente.
     * @throws ClienteException
    */
    public Cliente(String nome, String nomeDeUsuario, String senha) throws ClienteException {

        if(nome.length() < 2) {
            throw new ClienteException("nome", "3");
        } else if(nomeDeUsuario.length() < 3) {
            throw new ClienteException("nome de usuário", "4");
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
    Adiciona uma media à lista de app.app.midias para assistir do cliente.
    @param midia A midia a ser adicionada à lista.
    */
    public void adicionarNaLista(Midia midia) {
        if(!listaParaVer.contains(midia)) {
            this.listaParaVer.add(midia);
        }
    }

    /**
    Remove uma série da lista de séries para assistir do cliente.
    @param midia A série a ser removida da lista.
    */
    public void retirarDaLista(Midia midia) {
        if(listaParaVer.contains(midia)) {
            this.listaParaVer.remove(midia);
        } else {
            System.out.println("Midia não encontrada!");
        }
    }

    /**
     * Filtra a lista de séries para assistir do cliente por gênero.
     * 
     * @param genero O gênero pelo qual filtrar as séries.
     * @return Uma lista das séries filtradas por gênero.
     */
    public List<Midia> filtrarPorGenero(String genero) {
        String generoLowerCase = genero.toLowerCase();
        return listaParaVer.stream()
                .filter(s -> s.getGenero().toLowerCase().equals(generoLowerCase))
                .collect(Collectors.toList());
    }


    /**
     * Filtra a lista de séries para assistir do cliente por idioma.
     * 
     * @param idioma O idioma pelo qual filtrar as séries.
     * @return Uma lista das séries filtradas por idioma.
     */
    public List<Midia> filtrarPorIdioma(String idioma) {
        String idiomaLowerCase = idioma.toLowerCase();
        return listaParaVer.stream()
                .filter(s -> s.getIdioma().toLowerCase().equals(idiomaLowerCase))
                .collect(Collectors.toList());
    }


    
    /**
     * Filtra a lista de séries para assistir do cliente pela quantidade de episódios.
     * 
     * @param qtdEpisodios A quantidade de episódios pelo qual filtrar as séries.
     * @return Uma lista das séries filtradas pela quantidade de episódios.
     */
    public List<Midia> filtrarPorQtdEpisodios(int qtdEpisodios) {
        if (qtdEpisodios <= 0) {
            throw new IllegalArgumentException("A quantidade de episódios deve ser um valor válido e maior que zero.");
        }
        
        return listaParaVer.stream()
                .filter(s -> s.getQuantidadeEpisodios() == qtdEpisodios)
                .collect(Collectors.toList());
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
     * Verifica se o cliente pode avaliar a mídia.
     * 
     * @param midia A mídia a ser avaliada.
     * @return true se o cliente pode avaliar a mídia, false caso contrário.
     * @throws ClienteAvaliaException Exceção lançada quando o cliente não pode avaliar a mídia.
     */
    public boolean podeAvaliarMidia(Midia midia) throws ClienteAvaliaException {
        for (Avaliacao avaliacao : listaNotas) {
            if (avaliacao.getMidia().equals(midia) || !this.listaJaVistas.contains(midia)) {
                return false; // A mídia já foi avaliada pelo cliente
            }
        }
        return true;
    }

    /**
     * Avalia uma mídia atribuindo uma nota a ela.
     * 
     * @param nota A nota a ser atribuída à mídia.
     * @param midia A mídia a ser avaliada.
     * @throws ClienteAvaliaException Exceção lançada em caso de erro ao avaliar a mídia pelo cliente.
     * @throws InvalidParameterException Exceção lançada quando a mídia não foi assistida antes de ser avaliada.
     */
    public void avaliarMidia(double nota, Midia midia) throws ClienteAvaliaException, InvalidParameterException{
             
        if (podeAvaliarMidia(midia) && nota > 0 && nota < 6) {
            Avaliacao avaliacao = new Avaliacao(this, midia ,nota);
            this.listaNotas.add(avaliacao);
            midia.adicionarAvaliacao(avaliacao);
            
        }else{
            throw new InvalidParameterException("O cliente não pode avaliar esta mídia.");
        }
    }

    

    public List<Avaliacao> getAvaliacoes() {
        return this.listaNotas;
    }

    public List<LocalDate> getDatasSeriesAssistidas() {
        return this.datasSeriesAssistidas;
    }

    // Getters e setters para os atributos da classe app.app.clientes.Cliente

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

    public List<Avaliacao> getListaNotas() {
        return this.listaNotas;
    }


    /**
     * Adiciona Midia na lista de desejos
     * @param midia
     */
    public void addListaDesejos(Midia midia) {
        this.listaDesejos.add(midia);
    }

}
