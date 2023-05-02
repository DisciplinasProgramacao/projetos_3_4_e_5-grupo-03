

public class Avaliacao {
    private String nomeDeUsuario;
    private int id;
    private int nota;

    public Avaliacao(String nomeDeUsuario, int id, int nota) {
        this.nomeDeUsuario = nomeDeUsuario;
        this.id = getid(id);
        this.nota = nota;
    }

    public int getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public int getid() {
        return id;
    }

    public int getNota() {
        return nota;
    }
}