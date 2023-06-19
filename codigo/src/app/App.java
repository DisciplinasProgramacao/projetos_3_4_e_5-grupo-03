package app;
import app.clientes.Cliente;
import app.midias.Filme;
import app.midias.Serie;
import app.utils.Relatorio;
import app.exceptions.ClienteException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws IOException, ClienteException, InvalidParameterException {

        PlataformaStreaming plataforma = new PlataformaStreaming("teste"); 
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Adicionar mídia");
            System.out.println("3. Relatórios");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarCliente(plataforma, scanner);
                    break;
                case 2:
                    cadastrarMidia(plataforma, scanner);
                    break;
                case 3:
                    puxarRelatorio(plataforma);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente(PlataformaStreaming plataforma, Scanner scanner) throws ClienteException {
        System.out.println("Digite o nome completo do cliente:");
        String nomeCompleto = scanner.nextLine();

        System.out.println("Digite o nome de usuário do cliente:");
        String nomeUsuario = scanner.nextLine();

        System.out.println("Digite a senha do cliente:");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCompleto, nomeUsuario, senha);
        plataforma.adicionarCliente(cliente);
        System.out.println("app.app.clientes.Cliente adicionado com sucesso!");
    }

    private static void cadastrarMidia(PlataformaStreaming plataforma, Scanner scanner) throws InvalidParameterException {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Escolha o tipo de mídia:");
        System.out.println("1. Série");
        System.out.println("2. Filme");

        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o ID da série:");
                int id = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Digite o nome da série:");
                String nome = scanner.nextLine();

                System.out.println("Digite a data de lançamento no formato dd/MM/yyyy:");
                LocalDate dataLancamento = LocalDate.parse(scanner.nextLine(), dateFormatter);

                System.out.println("Digite o número de episodios:");
                int qtdEpisodios = scanner.nextInt();
                scanner.nextLine();


                System.out.println("Generos disponiveis: \n 0. Ação \n 1. Anime \n 2. Aventura \n 3. Comédia \n 4. Documentário \n 5. Drama \n 6. Policial \n 7. Romance \n 8. Suspense");
                System.out.println("Digite o número da categoria que encaixa com essa série:");
                int genero = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Idiomas disponiveis: \n 0. inglês \n 1. português \n 2. espanhol");
                System.out.println("Digite o número do idioma que encaixa com essa série:");
                int idioma = scanner.nextInt();
                scanner.nextLine();

                Serie serie = new Serie(id, nome, genero, idioma, qtdEpisodios, dataLancamento);
                plataforma.adicionarSerie(serie);
                System.out.println("Série adicionada com sucesso!");
                break;

            case 2:
                System.out.println("Digite o ID do filme:");
                int idFilme = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Digite o nome do filme:");
                String nomeFilme = scanner.nextLine();

                System.out.println("Digite a data de lançamento no formato dd/MM/yyyy:");
                LocalDate dataLancamentoFilme = LocalDate.parse(scanner.nextLine(), dateFormatter);

                System.out.println("Digite a duração do filme:");
                int duracao = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Generos disponiveis: \n 0. Ação \n 1. Anime \n 2. Aventura \n 3. Comédia \n 4. Documentário \n 5. Drama \n 6. Policial \n 7. Romance \n 8. Suspense");
                System.out.println("Digite o número da categoria que encaixa com esse filme:");
                int generoFilme = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Idiomas disponiveis: \n 0. inglês \n 1. português \n 2. espanhol");
                System.out.println("Digite o número do idioma que encaixa com esse filme:");

                int idiomaFilme = scanner.nextInt();
                scanner.nextLine();

                Filme filme = new Filme(idFilme, nomeFilme, dataLancamentoFilme, duracao, generoFilme, idiomaFilme);
                plataforma.adicionarFilme(filme);
                System.out.println("Filme adicionado com sucesso!");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void puxarRelatorio(PlataformaStreaming plataforma) {
        System.out.println("Escolha o relatório:");
        System.out.println("1. Qual cliente assistiu mais mídias, e quantas mídias");
        System.out.println("2. Qual cliente tem mais avaliações, e quantas avaliações");
        System.out.println("3. Qual a porcentagem dos clientes com pelo menos 15 avaliações");
        System.out.println("4. Quais são as 10 mídias de melhor avaliação, com pelo menos 100 avaliações, em ordem decrescente");
        System.out.println("5. Qual a mídia mais assistida pelos clientes");
        System.out.println("6. Qual são as 10 mídias com mais avaliações por genero (Avaliações > 100)");
        System.out.println("7. Qual são as 10 mídias com mais visualizações por genero");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        Relatorio relatorio = new Relatorio(plataforma);

        switch (opcao) {
            case 1:
                relatorio.clienteAssistiuMaisMidias();
                break;
            case 2:
                relatorio.clienteMaisAvaliacoes();
                break;
            case 3:
                relatorio.porcentagemClientesComMais15Avaliacoes();
                break;
            case 4:
                relatorio.midiasComMaisAvaliacoes();
                break;
            case 5:
                relatorio.midiasComMaisVisualizacoes();
                break;
            case 6:
                relatorio.midiasComMaisAvaliacoesPorGenero();
                break;
            case 7:
                relatorio.midiasComMaisVisualizacoesPorGenero();
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
