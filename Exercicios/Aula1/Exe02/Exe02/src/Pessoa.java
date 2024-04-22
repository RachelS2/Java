import java.util.Scanner;

public class Pessoa {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Informe a sua altura: ");
        double altura = teclado.nextDouble();

        System.out.print("Informe o seu peso: ");
        double peso = teclado.nextDouble();

        System.out.print("Informe a sua nacionalidade: ");
        String origem = teclado.next();

        System.out.print("Você se chama " + nome + ", tem " + altura + " metro de altura, " + peso + " quilos e é " + origem);
        teclado.close();
    }
}
