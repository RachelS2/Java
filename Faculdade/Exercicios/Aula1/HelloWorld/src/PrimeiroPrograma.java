import java.util.Scanner;

public class PrimeiroPrograma {


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);
        int altura, base; //Dados de entrada
        float area; //Dados de saida

        System.out.print("Informe a altura do triângulo: ");
        altura = scanner.nextInt();
        System.out.print("Informe a base  do triângulo: ");
        base = scanner.nextInt();
        area = 0.5f * altura * base;
        System.out.print("Área: " + area);
        scanner.close();
    }

}
