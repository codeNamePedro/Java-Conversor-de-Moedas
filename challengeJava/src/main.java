import java.util.InputMismatchException;
import java.util.Scanner;

class ConversorMoeda {
    public double converter(double valor, double taxaConversao) {
        return valor * taxaConversao;
    }
}

class OpcaoConversao {
    String descricao;
    double taxa;

    public OpcaoConversao(String descricao, double taxa) {
        this.descricao = descricao;
        this.taxa = taxa;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getTaxa() {
        return taxa;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoeda conversor = new ConversorMoeda();

        OpcaoConversao[] opcoes = {
            new OpcaoConversao("Dólar para Real", 5.10),
            new OpcaoConversao("Real para Dólar", 0.20),
            new OpcaoConversao("Euro para Real", 5.45),
            new OpcaoConversao("Real para Euro", 0.18),
            new OpcaoConversao("Peso Colombiano para Dólar", 0.00025),
            new OpcaoConversao("Dólar para Peso Colombiano", 4000.0)
        };

        try {
            System.out.println("=== Conversor de Moedas ===");
            System.out.println("Escolha uma opção de conversão:");

            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + ". " + opcoes[i].getDescricao());
            }

            
            int escolha = 0;
            while (true) {
                System.out.print("Digite o número da opção desejada (1-6): ");
                try {
                    escolha = scanner.nextInt();
                    if (escolha >= 1 && escolha <= 6) {
                        break;
                    } else {
                        System.out.println(" Opção inválida. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(" Entrada inválida. Digite um número de 1 a 6.");
                    scanner.nextLine(); 
                }
            }

            
            double valor = 0;
            while (true) {
                System.out.print("Digite o valor a ser convertido: ");
                try {
                    valor = scanner.nextDouble();
                    if (valor >= 0) {
                        break;
                    } else {
                        System.out.println("Valor negativo não é permitido. Digite novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número válido.");
                    scanner.nextLine(); 
                }
            }

            OpcaoConversao opcaoEscolhida = opcoes[escolha - 1];
            double valorConvertido = conversor.converter(valor, opcaoEscolhida.getTaxa());

            System.out.printf("Você escolheu: %s\n", opcaoEscolhida.getDescricao());
            System.out.printf("Valor digitado: %.2f\n", valor);
            System.out.printf("Valor convertido: %.2f\n", valorConvertido);

        } catch (Exception e) {
            System.out.println(" Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}
