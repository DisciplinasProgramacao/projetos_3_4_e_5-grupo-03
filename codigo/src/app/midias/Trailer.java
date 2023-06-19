package app.midias;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class Trailer extends Midia {
    
    public Trailer(int id,String nome, LocalDate dataLancamento, int genero, int idioma) throws InvalidParameterException {

        super(id,nome, dataLancamento, genero, idioma);
    }

    @Override
    public int getAudiencia() {
        return 0;
    }

    public void registrarAudiencia(){
    }

    public double calcularMediaDeNotas() {
        return 0.0F;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
    }

    public String toString() {
        // 9573;Complexity Of A Nuclear Winter;07/07/2022;97
        return this.getId() + ";" + this.getNome() + ";" + this.getDataLancamento() + ";" + this.getGenero();
    }
}