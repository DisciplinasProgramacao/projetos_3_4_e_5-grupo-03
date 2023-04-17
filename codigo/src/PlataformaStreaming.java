import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        return null;
    }

    public List<Serie> filtrarPorIdioma(String idioma) {
        return null;
    }

    public List<Serie> filtrarPorQtdEpisodios(int quantEpisodios) {
        return null;
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