import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlataformaStreaming {
    private String nome;
    private HashMap<String, Serie> series;
    private HashMap<String, Cliente> clientes;
    private Cliente clienteAtual;


    public PlataformaStreaming(String nome) {
        this.nome = nome;
        this.series = new HashMap<String, Serie>();
        this.clientes = new HashMap<String, Cliente>();
        this.clienteAtual = null;
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
}