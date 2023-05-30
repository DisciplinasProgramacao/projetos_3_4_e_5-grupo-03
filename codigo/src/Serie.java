import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.platform.console.shadow.picocli.CommandLine.ITypeConverter;

import exceptions.MidiaDataException;
import exceptions.QuantidadeMinimaEpException;
import exceptions.MidiaException;

/**
 * A classe Serie representa uma série de TV e herda da classe Midia.
 * Implementa a interface Serializable para permitir a gravação de objetos da classe em arquivos.
 */
public class Serie extends Midia {
   
    private int quantidadeEpisodios;
   
    /**
    * Construtor padrão.
    */
    public Serie() {
        super();
    }

    /**
     * Construtor da classe Serie.
     * @param id Identificador único da série.
     * @param nome Nome da série.
     * @param dataLancamento Data de lançamento da série.
     * @param quantidadeEpisodios Quantidade de episódios da série.
     * @throws MidiaDataException
     * @throws MidiaException
    */
    public Serie(int id, String nome, LocalDate dataLancamento, int quantidadeEpisodios) throws MidiaException, MidiaDataException {

        super(id, nome, dataLancamento);
        if(quantidadeEpisodios < 1) {
            throw new RuntimeException("A quantidade de episódios não pode ser 0!");
        }
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Construtor alternativo da classe Serie.
     * @param id Identificador único da série.
     * @param nome Nome da série.
     * @param string Parametro não utilizado.
     * @param string2 Parametro não utilizado.
     * @param i Parametro não utilizado.
     * @param j Parametro não utilizado.
     * @param dataLancamento Data de lançamento da série.
     * @throws MidiaDataException
     * @throws MidiaException
     */
    public Serie(int id, String nome, int genero, int idioma, int quantidadeEps,
            LocalDate dataLancamento) throws MidiaException, MidiaDataException {
                super(id, nome, dataLancamento, genero, idioma);
                this.quantidadeEpisodios = quantidadeEps;
    }

    /**
    * Construtor alternativo da classe Serie.
    * @param id Identificador único da série.
    * @param nome Nome da série.
    * @param dataLancamento Data de lançamento da série.
    * @throws MidiaDataException
    * @throws MidiaException
    */
    public Serie(int id, String nome, LocalDate dataDeLancamento) throws MidiaException, MidiaDataException {
        super(id, nome, dataDeLancamento);
        this.quantidadeEpisodios = 1;
    }

    /**
     * Retorna a quantidade de episódios da série.
     * @return A quantidade de episódios.
     */
    @Override
    public int getQuantidadeEpisodios() {
        return this.quantidadeEpisodios;
    }
    
    
    /**
     * Define a quantidade de episódios da série.
     * @param quantidadeEpisodios A quantidade de episódios.
     * @throws QuantidadeMinimaEpException se a quantidade de episódios for menor que 2.
     */
    public void setQuantidadeEpisodios(int quantidadeEpisodios) throws QuantidadeMinimaEpException {
        if(quantidadeEpisodios < 2){
            throw new QuantidadeMinimaEpException();
        }
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Retorna uma String com os dados da série.
     * @return Uma String com os dados da série.
     */
    @Override
    public String toString() {
        // 3462;Pink is the new White;20/09/2018
        return this.getId() + ";" + this.getNome() + ";" + this.getDataLancamento();
    }
}
