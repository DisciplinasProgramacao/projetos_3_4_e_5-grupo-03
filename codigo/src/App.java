import java.io.IOException;

public class App {
    public static void main(String[] args) {
        PlataformaStreaming plataforma = new PlataformaStreaming("MinhaPlataforma");
        CsvReader csvReader = new CsvReader();

        try {
            csvReader.lerClientes("POO_Espectadores.csv");
            csvReader.lerSeries("POO_Series.csv");
            csvReader.lerAudiencia("POO_Audiencia.csv", plataforma);

            // Imprimir todos os clientes e suas listas de séries
            for (Cliente cliente : plataforma.getClientes().values()) {
                System.out.println("Cliente: " + cliente.getNomeUsuario());
                System.out.println("Séries para assistir:");
                for (Serie serie : cliente.getListaParaVer()) {
                    System.out.println("  - " + serie.getNome());
                }
                System.out.println("Séries assistidas:");
                for (Serie serie : cliente.getListaJaVistas()) {
                    System.out.println("  - " + serie.getNome());
                }
            }

            // Imprimir todas as séries e suas audiências
            for (Serie serie : plataforma.getSeries().values()) {
                System.out.println("Série: " + serie.getNome());
                System.out.println("Audiência: " + serie.getAudiencia());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}