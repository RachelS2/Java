import java.util.Scanner;

public class LePontos {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Insira o ponto xA: ");
        int xA = teclado.nextInt();

        System.out.print("Insira o ponto yA: ");
        int yA = teclado.nextInt();

        System.out.print("\nInsira o ponto xB: ");
        int xB = teclado.nextInt();

        System.out.print("Insira o ponto yB: ");
        int yB = teclado.nextInt();

        int distancia = (Math.pow(2, (xB - xA)) + (Math.pow(2, yB - yA)));

        System.out.print("A distância entre os pontos (" + xA + ", " + yA + ") e (" + xB + ", " + yB + ") é de " + distancia + " .");
        teclado.close();
    }
}
