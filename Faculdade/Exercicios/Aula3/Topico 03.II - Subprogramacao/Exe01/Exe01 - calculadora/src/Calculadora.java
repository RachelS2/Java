import java.util.Scanner;

public class Calculadora {

    private static double memoria = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nEstado da memória: " + memoria);
            System.out.println("Opções:");
            System.out.println("(1) Somar");
            System.out.println("(2) Subtrair");
            System.out.println("(3) Multiplicar");
            System.out.println("(4) Dividir");
            System.out.println("(5) Limpar memória");
            System.out.println("(6) Sair do programa");
            System.out.print("Qual opção você deseja? ");
            
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    somar(input);
                    break;
                case 2:
                    subtrair(input);
                    break;
                case 3:
                    multiplicar(input);
                    break;
                case 4:
                    dividir(input);
                    break;
                case 5:
                    limparMemoria();
                    break;
                case 6:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        input.close();
    }

    public static void somar(Scanner input) {
        System.out.print("Digite o valor a ser somado: ");
        double valor = input.nextDouble();
        memoria += valor;
    }

    public static void subtrair(Scanner input) {
        System.out.print("Digite o valor a ser subtraído: ");
        double valor = input.nextDouble();
        memoria -= valor;
    }

    public static void multiplicar(Scanner input) {
        System.out.print("Digite o valor a ser multiplicado: ");
        double valor = input.nextDouble();
        memoria *= valor;
    }

    public static void dividir(Scanner input) {
        System.out.print("Digite o valor pelo qual dividir: ");
        double divisor = input.nextDouble();
        if (divisor != 0) {
            memoria /= divisor;
        } else {
            System.out.println("Não é possível dividir por zero.");
        }
    }

    public static void limparMemoria() {
        memoria = 0;
        System.out.println("Memória limpa.");
    }
}