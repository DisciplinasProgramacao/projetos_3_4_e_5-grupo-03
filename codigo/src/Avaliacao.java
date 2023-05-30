import exceptions.AvaliacaoNotaException;

public class Avaliacao {
    private Cliente cliente;
    private Midia midia;
    private double nota;


    public Avaliacao(Cliente cliente, Midia midia, double nota) {
        this.cliente = cliente;
        this.midia = midia;
        this.nota = nota;
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
     * @throws AvaliacaoNotaException Exceção lançada quando a nota é inválida.
     */
    public void setNota(double nota) throws AvaliacaoNotaException{
        if(nota < 0 || nota > 5) {
            throw new AvaliacaoNotaException();
        }
        this.nota = nota;
    }

   

}