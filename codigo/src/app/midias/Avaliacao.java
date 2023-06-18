package app.midias;
import app.clientes.Cliente;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;


public class Avaliacao {
    private Cliente cliente;
    private Midia midia;
    private double nota;
    private Map<Cliente, String> comentarios;


    public Avaliacao(Cliente cliente, Midia midia, double nota) {
        this.cliente = cliente;
        this.midia = midia;
        this.nota = nota;
        this.comentarios = new HashMap<>();
    }

    public Avaliacao(Cliente cliente, Midia midia, double nota, String comentario) {
        this(cliente, midia, nota);
        this.addComentario(cliente, comentario);
    }

    private void addComentario(Cliente cliente, String comentario) {
        this.comentarios.put(cliente, comentario);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Midia getMidia() {
        return this.midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public double getNota() {
        return this.nota;
    }

    /**
     * Atribui uma nota à avaliação.
     * 
     * @param nota A nota a ser atribuída.
     * @throws InvalidParameterException Exceção lançada quando a nota é inválida.
     */
    public void setNota(double nota) throws InvalidParameterException{
        if(nota < 0 || nota > 5) {
            throw new InvalidParameterException("A nota deve ser entre 0 e 5!");
        }
        this.nota = nota;
    }

   

}