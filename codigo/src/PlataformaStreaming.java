import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlataformaStreaming {
    private String nome;
    private HashMap<String, Serie> series;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, Filme> filmes;
    private Cliente clienteAtual;


    public PlataformaStreaming(String nome) throws IOException {
        this.nome = nome;
        this.series = new HashMap<String, Serie>();
        this.clientes = new HashMap<String, Cliente>();
        this.filmes = new HashMap<String, Filme>();

        //criar um hash de midia e não de series e filmes, usando como identificador o ID
        this.clienteAtual = null;

        this.lerClientes("POO_Espectadores.csv");
        this.lerSeries("POO_Series.csv");
        this.lerFilmes("./POO_Filmes.csv");
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

    public void adicionarSerie(Serie serie) {
        this.series.put(serie.getNome(), serie);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.put(cliente.getNomeUsuario(), cliente);
    }

    public void adicionarFilme(Filme filme) {
        this.filmes.put(filme.getNome(), filme);
    }


    public List<Serie> filtrarPorGenero(String genero) {
        return this.series.values().stream()
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
    
    public List<Serie> filtrarPorIdioma(String idioma) {
        return this.series.values().stream()
            .filter(s -> s.getIdioma().equalsIgnoreCase(idioma))
            .collect(Collectors.toList());
    }
    
    public List<Serie> filtrarPorQtdEpisodios(int quantEpisodios) {
        return this.series.values().stream()
            .filter(s -> s.getQuantidadeEpisodios() == quantEpisodios)
            .collect(Collectors.toList());
    }

    public void registrarAudiencia(Serie serie) {
    }

    public HashMap<String, Cliente> getClientes() {
        return this.clientes;
    }

    public HashMap<String, Serie> getSeries() {
        return this.series;
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

    private void lerSeries(String arquivo) throws IOException {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            String linha;
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                int idSerie = Integer.parseInt(campos[0]);
                String nomeSerie = campos[1];
                LocalDate dataDeLancamento = LocalDate.parse(campos[2]);

                // Os campos adicionais podem ser adicionados conforme necessário
                Serie serie = new Serie(idSerie, nomeSerie, "", "", 0, 0, dataDeLancamento);
                this.adicionarSerie(serie);
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
                String idSerie = campos[2];

                Cliente cliente = this.getClientes().get(login);
                Serie serie = this.getSeries().get(idSerie);

                if (cliente != null && serie != null) {
                    if ("F".equalsIgnoreCase(tipo)) {
                        cliente.adicionarNaLista(serie);
                    } else if ("A".equalsIgnoreCase(tipo)) {
                        cliente.registrarAudiencia(serie);
                    }
                }
            }
        }
    }

    private void lerFilmes(String arquivo) throws IOException {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            String linha;
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String[] campos = linha.split(";");
                int idFilme = Integer.parseInt(campos[0]);
                String nome = campos[1];
                LocalDate dataDeLancamento = LocalDate.parse(campos[2]);
                int duracao = Integer.parseInt(campos[3]);

                // Os campos adicionais podem ser adicionados conforme necessário
                Filme filme = new Filme(idFilme, nome, dataDeLancamento, duracao);
                this.adicionarFilme(filme);
            }
        } 
    }

}