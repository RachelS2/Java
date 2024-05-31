import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira um número para ver quais números são perfeitos até ele: ");

        int numero = input.nextInt();

        for (int numeroAtual = 1; numeroAtual <= numero; numeroAtual++) {
            int somaDivisores = 0;
            for (int divisor = 1; divisor < numeroAtual; divisor++) {
                if (numeroAtual % divisor == 0) {
                    somaDivisores += divisor;
                }
            }
            if (somaDivisores == numeroAtual) {
                System.out.print(numeroAtual + " é um número perfeito: ");
                for (int divisor = 1; divisor < numeroAtual; divisor++) {
                    if (numeroAtual % divisor == 0) {
                        System.out.print(divisor + " ");
                    }
                }
                System.out.println();
            }
        }
        input.close();
    }
}