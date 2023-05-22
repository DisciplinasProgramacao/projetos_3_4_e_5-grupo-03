import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import java.time.format.DateTimeFormatter;

public class PlataformaStreaming {
    private String nome;
    private HashMap<Integer, Midia> midias;
    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Avaliacao> avaliacoes;
    private Cliente clienteAtual;

    /**
     * Construtor da classe PlataformaStreaming.
     * 
     * @param nome Nome da plataforma de streaming.
     * @throws IOException Exceção lançada em caso de falha na leitura dos arquivos.
     */
    public PlataformaStreaming(String nome) throws IOException {
        this.nome = nome;
        this.midias = new HashMap<Integer, Midia>();
        this.clientes = new HashMap<String, Cliente>();
        this.avaliacoes = new HashMap<Integer, Avaliacao>();

        this.clienteAtual = null;

        this.lerMidias("POO_Series.csv", "POO_Filmes.csv");
        this.lerClientes("POO_Espectadores.csv");
        this.lerAudiencia("POO_Audiencia.csv");

    }

    public PlataformaStreaming(String nome, boolean dummy) {
        this.nome = nome;
        this.midias = new HashMap<Integer, Midia>();
        this.clientes = new HashMap<String, Cliente>();
        this.avaliacoes = new HashMap<Integer, Avaliacao>();

        this.clienteAtual = null;
    }

    /**
     * Método para realizar o login de um cliente na plataforma.
     * 
     * @param nomeUsuario Nome de usuário do cliente.
     * @param senha       Senha do cliente.
     * @return Retorna o objeto Cliente caso o login seja bem-sucedido, caso
     *         contrário, retorna null.
     */
    public Cliente login(String nomeUsuario, String senha) {
        Cliente cl = clientes.get(nomeUsuario);
        if (cl.getNomeUsuario() == nomeUsuario && cl.getSenha() == senha) {
            this.clienteAtual = cl;
            return cl;
        }
        return null;
    }

    /**
     * Adiciona uma série à plataforma.
     * 
     * @param serie Objeto da classe Midia representando a série a ser adicionada.
     */
    public void adicionarSerie(Midia serie) {
        this.midias.put(serie.getId(), serie);
    }

    /**
     * Adiciona um cliente à plataforma.
     * 
     * @param cliente Objeto da classe Cliente representando o cliente a ser
     *                adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        this.clientes.put(cliente.getNomeUsuario(), cliente);
    }

    /**
     * Adiciona um filme à plataforma.
     * 
     * @param filme Objeto da classe Midia representando o filme a ser adicionado.
     */
    public void adicionarFilme(Midia filme) {
        this.midias.put(filme.getId(), filme);
    }

    /**
     * Filtra as mídias da plataforma por gênero.
     * 
     * @param genero Gênero a ser usado como filtro.
     * @return Retorna uma lista de mídias que correspondem ao gênero informado.
     */
    public List<Midia> filtrarPorGenero(String genero) {
        return this.midias.values().stream()
                .filter(s -> s.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }

    /*
     * Explicando o código:
     * return this.series.values().stream()
     * .filter(s -> s.getGenero().equalsIgnoreCase(genero))
     * .collect(Collectors.toList());
     * 
     * O método stream() cria um fluxo (stream) das séries
     * e aplicamos o método filter() para filtrar as séries de acordo com o
     * critério fornecido. No final, usamos o método collect() com o coletor
     * Collectors.toList() para converter o fluxo filtrado de volta em uma lista.
     */

    /**
     * Filtra as mídias da plataforma por idioma.
     * 
     * @param idioma Idioma a ser usado como filtro.
     * @return Retorna uma lista de mídias que correspondem ao idioma informado.
     */
    public List<Midia> filtrarPorIdioma(String idioma) {
        return this.midias.values().stream()
                .filter(s -> s.getIdioma().equalsIgnoreCase(idioma))
                .collect(Collectors.toList());
    }

    /**
     * Filtra as mídias da plataforma pela quantidade de episódios.
     * 
     * @param quantEpisodios Quantidade de episódios a ser usada como filtro.
     * @return Retorna uma lista de mídias que correspondem à quantidade de
     *         episódios informada.
     */
    public List<Midia> filtrarPorQtdEpisodios(int quantEpisodios) {
        return this.midias.values().stream()
                .filter(s -> s.getQuantidadeEpisodios() == quantEpisodios)
                .collect(Collectors.toList());
    }

    /**
     * Registra a audiência de uma midia na plataforma.
     * 
     * @param midia Objeto da classe Mdiia representando a midia cuja audiência será
     *              registrada.
     */
    public void registrarAudiencia(Midia midia) {
    }

    /**
     * Retorna um HashMap contendo os clientes cadastrados na plataforma.
     * 
     * @return HashMap contendo os clientes.
     */
    public HashMap<String, Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Retorna um HashMap contendo os clientes cadastrados na plataforma.
     * 
     * @return HashMap contendo os clientes.
     * @throws ClienteException
     */
    private void lerClientes(String arquivo) throws IOException, ClienteException {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            String linha;
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String nomeCompleto = campos[0];
                String nomeDeUsuario = campos[1];
                String senha = campos[2];

                Cliente cliente = new Cliente(nomeCompleto, nomeDeUsuario, senha);
                this.adicionarCliente(cliente);
            }
        }
    }

    /**
     * Lê informações da audiência de um arquivo e registra a audiência na
     * plataforma.
     * 
     * @param arquivo Nome do arquivo contendo as informações da audiência.
     * @throws IOException Exceção lançada em caso de falha na leitura do arquivo.
     */
    private void lerAudiencia(String arquivo) throws IOException {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            String linha;
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String login = campos[0];
                String tipo = campos[1];
                String id = campos[2];

                Cliente cliente = this.getClientes().get(login);
                if (cliente != null) {
                    Midia midia = this.midias.get(Integer.parseInt(id));

                    if ("F".equalsIgnoreCase(tipo)) {
                        if (midia instanceof Serie) {
                            cliente.adicionarNaLista((Serie) midia);
                        }
                    } else if ("A".equalsIgnoreCase(tipo)) {
                        if (midia instanceof Serie) {
                            cliente.registrarAudiencia((Serie) midia);
                        }
                    }
                }

            }
        }
    }

    /**
     * Lê informações das mídias de arquivos e adiciona as mídias à plataforma.
     * 
     * @param arquivoSeries Nome do arquivo contendo as informações das séries.
     * @param arquivoFilmes Nome do arquivo contendo as informações dos filmes.
     * @throws IOException Exceção lançada em caso de falha na leitura dos arquivos.
     * @throws MidiaDataException
     * @throws MidiaException
     * @throws DuracaoFilmeException
     */
    private void lerMidias(String arquivoSeries, String arquivoFilmes) throws IOException, DuracaoFilmeException, MidiaException, MidiaDataException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Lendo séries
        try (Scanner scanner = new Scanner(new File(arquivoSeries))) {
            String linha;
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String idStr = campos[0].replaceAll("[^\\d]", ""); // Remove caracteres não numéricos
                int id = Integer.parseInt(idStr);
                String nomeSerie = campos[1];
                LocalDate dataDeLancamento = LocalDate.parse(campos[2], dateFormatter);

                // Os campos adicionais podem ser adicionados conforme necessário
                Serie serie = new Serie(id, nomeSerie, "", "", 0, 0, dataDeLancamento);
                this.adicionarSerie(serie);
            }
        }

        // Lendo filmes
        try (Scanner scanner = new Scanner(new File(arquivoFilmes))) {
            String linha;
            linha = scanner.nextLine();
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String idFilmeStr = campos[0].replaceAll("[^\\d]", ""); // Remove caracteres não numéricos
                int idFilme = Integer.parseInt(idFilmeStr);
                String nome = campos[1];
                LocalDate dataDeLancamento = LocalDate.parse(campos[2], dateFormatter);
                int duracao = Integer.parseInt(campos[3]);

                // Os campos adicionais podem ser adicionados conforme necessário
                Filme filme = new Filme(idFilme, nome, dataDeLancamento, duracao);
                this.adicionarFilme(filme);
            }
        }
    }

    /**
     * Adiciona um cliente à plataforma se o nome de usuário não existir.
     * @param nomeCompleto  Nome completo do cliente.
     * @param nomeDeUsuario Nome de usuário do cliente.
     * @param senha         Senha do cliente.
     * @return Retorna true se o cliente foi adicionado com sucesso, caso contrário,
     *         retorna false.
     * @throws ClienteException
     */
    public boolean adicionarCliente(String nomeCompleto, String nomeDeUsuario, String senha) throws ClienteException {
        // Verificar se o nome de usuário já existe
        if (clientes.containsKey(nomeDeUsuario)) {
            return false; // Nome de usuário já existe, não é possível adicionar o cliente
        }

        // Criar uma nova instância do cliente e adicioná-la ao HashMap
        Cliente novoCliente = new Cliente(nomeCompleto, nomeDeUsuario, senha);
        clientes.put(nomeDeUsuario, novoCliente);
        return true; // Cliente adicionado com sucesso
    }

    private Midia encontrarMidiaPorId(int id, List<Midia> midias) {
        for (Midia midia : midias) {
            if (midia.getId() == id) {
                return midia;
            }
        }
        return null;
    }

    public void salvar() throws IOException {
        // this.midias.forEach((id, midia) -> {
        // System.out.println(midia.getClass().getSimpleName() + " - " + midia);
        // });

        Map<String, List<Midia>> mapaDeMidias = new HashMap<>();

        // Iterando sobre a lista de mídias
        midias.forEach((id, midia) -> {
            // Obtendo o nome da classe
            String nomeDaClasse = midia.getClass().getSimpleName();

            // Verificando se a classe já existe no mapa
            if (mapaDeMidias.containsKey(nomeDaClasse)) {
                // Se a classe já existe, adiciona a mídia na lista correspondente
                mapaDeMidias.get(nomeDaClasse).add(midia);
            } else {
                // Se a classe não existe, cria uma nova lista e adiciona a mídia
                List<Midia> listaDeMidias = new ArrayList<>();
                listaDeMidias.add(midia);
                mapaDeMidias.put(nomeDaClasse, listaDeMidias);
            }
        });

        mapaDeMidias.keySet().forEach(classe -> {
            String nomeDoArquivo = "./salvar/POO_" + classe + ".csv";
            List<Midia> midiasDaClasse = mapaDeMidias.get(classe);
            //itere sobre as linhas salvando 
        });
    }
}
