import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.ClienteAvaliaException;
import exceptions.ClienteException;
import exceptions.NaoPodeAvaliarException;


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
     * @throws ClienteException
    */
    public Cliente(String nome, String nomeDeUsuario, String senha) throws ClienteException {

        if(nome.length() < 2) {
            throw new ClienteException("nome", "3");
        } else if(nomeDeUsuario.length() < 3) {
            throw new ClienteException("nome de usuário", "4");
        } else if(senha.length() < 6) {
            throw new ClienteException("Senha", "7");
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
        if(!listaParaVer.contains(midia)) {
            this.listaParaVer.add(midia);
        }
    }

    /**
    Remove uma série da lista de séries para assistir do cliente.
    @param midia A série a ser removida da lista.
    */
    public void retirarDaLista(Midia midia) {
        this.listaParaVer.remove(midia);
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

///**
//Adiciona uma midia à lista de avaliacoes do cliente.
//@param avaliacao A midia a ser adicionada à lista.
// * @throws ClienteAvaliaException
//*/
//public void adicionarAvaliacao(Avaliacao avaliacao) throws ClienteAvaliaException {
//    if(this.listaJaVistas.contains(avaliacao.getMidia())) {
//        this.listaNotas.add(avaliacao);
//    } else {
//        throw new ClienteAvaliaException();
//    }
//}
//

    public boolean podeAvaliarMidia(int idMidia) throws ClienteAvaliaException {
       // Midia midia = buscarMidiaPorId(idMidia);
       // if (midia == null) {
       // }

        // Verifica se o cliente já viu a mídia
        if (this.listaJaVistas.contains(idMidia)) {
            // Verifica se o cliente já avaliou a mídia
            for (Avaliacao avaliacao : this.listaNotas) {
                if (avaliacao.getMidia().equals(idMidia)) {
                    return false; // Cliente já avaliou a mídia anteriormente
                }
            }
            return true; // Cliente viu a mídia, mas ainda não a avaliou
        }
        throw new ClienteAvaliaException();
        // return false; // Cliente ainda não viu a mídia
    }

    public void avaliarMidia(double nota, int idMidia) throws NaoPodeAvaliarException, ClienteAvaliaException{
             
        if (!podeAvaliarMidia(idMidia)) {
            throw new NaoPodeAvaliarException();
        }
        
        Avaliacao avaliacao = new Avaliacao(midia, nota);
       // Avaliacao.add(avaliacao);
        
        this.listaNotas.add(avaliacao);
        this.listaJaVistas.add(Idmidia);
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
