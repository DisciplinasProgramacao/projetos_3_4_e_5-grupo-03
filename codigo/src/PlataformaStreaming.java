import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

public class PlataformaStreaming {
    private String nome;
    private HashMap<Integer, Midia> midias;
    private HashMap<String, Cliente> clientes;
    private Cliente clienteAtual;


    public PlataformaStreaming(String nome) throws IOException {
        this.nome = nome;
        this.midias = new HashMap<Integer, Midia>();
        this.clientes = new HashMap<String, Cliente>();

        //criar um hash de midia e não de series e filmes, usando como identificador o ID
        this.clienteAtual = null;

        this.lerMidias("POO_Series.csv", "POO_Filmes.csv");
        this.lerClientes("POO_Espectadores.csv");
        this.lerAudiencia("POO_Audiencia.csv");

    }

    public Cliente login(String nomeUsuario, String senha) {
        Cliente cl = clientes.get(nomeUsuario);
        if (cl.getNomeUsuario() == nomeUsuario && cl.getSenha() == senha) {
            this.clienteAtual = cl;
            return cl;
        }
        return null;
    }

    public void adicionarSerie(Midia serie) {
        this.midias.put(serie.getId(), serie);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.put(cliente.getNomeUsuario(), cliente);
    }

    public void adicionarFilme(Midia filme) {
        this.midias.put(filme.getId(), filme);
    }


    public List<Midia> filtrarPorGenero(String genero) {
        return this.midias.values().stream()
            .filter(s -> s.getGenero().equalsIgnoreCase(genero))
            .collect(Collectors.toList());
    }

/*     Explicando o código:
        return this.series.values().stream()
        .filter(s -> s.getGenero().equalsIgnoreCase(genero))
        .collect(Collectors.toList());

    O método stream() cria um fluxo (stream) das séries 
    e aplicamos o método filter() para filtrar as séries de acordo com o 
    critério fornecido. No final, usamos o método collect() com o coletor 
    Collectors.toList() para converter o fluxo filtrado de volta em uma lista. */
    
    public List<Midia> filtrarPorIdioma(String idioma) {
        return this.midias.values().stream()
            .filter(s -> s.getIdioma().equalsIgnoreCase(idioma))
            .collect(Collectors.toList());
    }
    
    public List<Midia> filtrarPorQtdEpisodios(int quantEpisodios) {
        return this.midias.values().stream()
            .filter(s -> s.getQuantidadeEpisodios() == quantEpisodios)
            .collect(Collectors.toList());
    }


    public void registrarAudiencia(Serie serie) {
    }

    public HashMap<String, Cliente> getClientes() {
        return this.clientes;
    }



    private void lerClientes(String arquivo) throws IOException {
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

    private void lerMidias(String arquivoSeries, String arquivoFilmes) throws IOException {
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
    
    public boolean adicionarCliente(String nomeCompleto, String nomeDeUsuario, String senha) {
        // Verificar se o nome de usuário já existe
        if (clientes.containsKey(nomeDeUsuario)) {
            return false; // Nome de usuário já existe, não é possível adicionar o cliente
        }

        // Criar uma nova instância do cliente e adicioná-la ao HashMap
        Cliente novoCliente = new Cliente(nomeCompleto, nomeDeUsuario, senha);
        clientes.put(nomeDeUsuario, novoCliente);
        return true; // Cliente adicionado com sucesso
    }
    
}