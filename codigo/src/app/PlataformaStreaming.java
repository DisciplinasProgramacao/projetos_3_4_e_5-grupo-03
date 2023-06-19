package app;
import app.clientes.Cliente;
import app.midias.Avaliacao;
import app.midias.Filme;
import app.midias.Midia;
import app.midias.Serie;
import app.midias.Trailer;
import app.exceptions.ClienteException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class PlataformaStreaming {
    private String nome;

    private HashMap<Integer, Midia> midias;

    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Avaliacao> avaliacoes;
    private Cliente clienteAtual;
    /**
     * Construtor da classe app.PlataformaStreaming.
     *
     * @param nome Nome da plataforma de streaming.
     * @throws IOException Exceção lançada em caso de falha na leitura dos arquivos.
     * @throws InvalidParameterException
     * @throws ClienteException
     */
    public PlataformaStreaming(String nome) throws IOException, InvalidParameterException, ClienteException {
        this.nome = nome;
        this.midias = new HashMap<Integer, Midia>();
        this.clientes = new HashMap<String, Cliente>();
        this.avaliacoes = new HashMap<Integer, Avaliacao>();

        this.clienteAtual = null;

        this.lerMidias("POO_Series.csv", "POO_Filmes.csv");
        this.lerClientes("POO_Espectadores.csv");
        this.lerAudiencia("POO_Audiencia.csv");

    }

    /**
     * Construtor da classe app.PlataformaStreaming para criação de uma instância com um nome e um valor booleano.
     *
     * @param nome O nome da plataforma de streaming.
     * @param dummy Um valor booleano utilizado para inicialização.
     */
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
     * @return Retorna o objeto app.app.clientes.Cliente caso o login seja bem-sucedido, caso
     *         contrário, retorna null.
     */
    public Cliente login(String nomeUsuario, String senha) {
        Cliente cl = clientes.get(nomeUsuario);
        if (cl.getNomeDeUsuario() == nomeUsuario && cl.getSenha() == senha) {
            this.clienteAtual = cl;
            return cl;
        }
        return null;
    }

    /**
     * Adiciona uma série à plataforma.
     *
     * @param serie Objeto da classe midia.Midia representando a série a ser adicionada.
     */
    public void adicionarSerie(Midia serie) {
        this.midias.put(serie.getId(), serie);
    }

    /**
     * Adiciona um cliente à plataforma.
     *
     * @param cliente Objeto da classe app.app.clientes.Cliente representando o cliente a ser
     *                adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        this.clientes.put(cliente.getNomeDeUsuario(), cliente);
    }

    /**
     * Adiciona um filme à plataforma.
     *
     * @param filme Objeto da classe midia.Midia representando o filme a ser adicionado.
     */
    public void adicionarFilme(Midia filme) {
        this.midias.put(filme.getId(), filme);
    }


    public void adicionarTrailer(Midia trailer) {
        this.midias.put(trailer.getId(), trailer);
    }
    /**
     * Filtra as mídias da plataforma por gênero.
     *
     * @param genero Gênero a ser usado como filtro.
     * @return Uma lista imutável de mídias que correspondem ao gênero informado. Se o gênero for nulo ou vazio, retorna uma lista vazia.
     */
    public List<Midia> filtrarPorGenero(String genero) {
        if (genero == null || genero.isEmpty()) {
            return Collections.emptyList(); // Retorna uma lista vazia se o gênero for nulo ou vazio
        }

        String generoLowerCase = genero.toLowerCase(); // Converter o gênero para minúsculas

        return this.midias.values().stream()
                .filter(m -> m.getGenero() != null && m.getGenero().equalsIgnoreCase(generoLowerCase))
                .collect(Collectors.toList());
    }

    /**
     * Filtra as mídias da plataforma por idioma.
     *
     * @param idioma Idioma a ser usado como filtro.
     * @return Uma lista imutável de mídias que correspondem ao idioma informado. Se o idioma for nulo ou vazio, retorna uma lista vazia.
     */
    public List<Midia> filtrarPorIdioma(String idioma) {
        if (idioma == null || idioma.isEmpty()) {
            return Collections.emptyList(); // Retorna uma lista vazia se o idioma for nulo ou vazio
        }

        String idiomaLowerCase = idioma.toLowerCase(); // Converter o idioma para minúsculas

        return this.midias.values().stream()
                .filter(m -> m.getIdioma() != null && m.getIdioma().equalsIgnoreCase(idiomaLowerCase))
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
     * Retorna um HashMap contendo os app.app.clientes cadastrados na plataforma.
     *
     * @return HashMap contendo os app.app.clientes.
     */
    public HashMap<String, Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Retorna um HashMap contendo os app.app.clientes cadastrados na plataforma.
     *
     * @return HashMap contendo os app.app.clientes.
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
     * @throws InvalidParameterException
     */
    private void lerMidias(String arquivoSeries, String arquivoFilmes) throws IOException, InvalidParameterException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Lendo séries
        try (Scanner scanner = new Scanner(new File(arquivoSeries))) {
            String linha;
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String idStr = campos[0].replaceAll("[^\\d]", ""); // Remove caracteres não numéricos
                int id = Integer.parseInt(idStr);
                String nome = campos[1];
                LocalDate dataDeLancamento = LocalDate.parse(campos[2], dateFormatter);

                // Os campos adicionais podem ser adicionados conforme necessário
                Serie serie = new Serie(id, nome, dataDeLancamento);
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
            return false; 
        }


        Cliente novoCliente = new Cliente(nomeCompleto, nomeDeUsuario, senha);
        clientes.put(nomeDeUsuario, novoCliente);
        return true;
    }


    public HashMap<Integer, Midia> getMidias() {
        return midias;
    }

    /**
     * Salva as informações das mídias em arquivos CSV.
     * 
     * @throws IOException Exceção lançada em caso de erro ao salvar os arquivos.
     */
    public void salvar() throws IOException {
        Map<String, List<Midia>> mapaDeMidias = new HashMap<>();

        midias.forEach((id, midia) -> {
            String nomeDaClasse = midia.getClass().getSimpleName();

            if (mapaDeMidias.containsKey(nomeDaClasse)) {
                mapaDeMidias.get(nomeDaClasse).add(midia);
            } else {
                List<Midia> listaDeMidias = new ArrayList<>();
                listaDeMidias.add(midia);
                mapaDeMidias.put(nomeDaClasse, listaDeMidias);
            }
        });

        mapaDeMidias.keySet().forEach(classe -> {
            Path nomeDoArquivo = Paths.get("salvar/POO_" + classe + ".csv");
            List<Midia> midiasDaClasse = mapaDeMidias.get(classe);

            try {
                if (!Files.exists(nomeDoArquivo)) {
                    Files.createFile(nomeDoArquivo);
                }

                Files.write(nomeDoArquivo, midiasDaClasse.stream()
                                            .map(Object::toString)
                                            .collect(Collectors.toList()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
