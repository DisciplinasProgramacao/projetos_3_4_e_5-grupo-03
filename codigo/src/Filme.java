import java.time.LocalDate;

public class Filme extends Midia{

    private int duracao;

    public Filme(){
        super();
    }

    public Filme(int id,String nome, LocalDate dataLancamento, int duracao){
        super(id,nome, dataLancamento);
        this.duracao = duracao;
    }


    public int getDuracao() {
        return this.duracao;
    }

}