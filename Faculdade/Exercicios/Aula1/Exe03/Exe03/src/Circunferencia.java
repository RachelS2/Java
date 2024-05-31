import java.util.Scanner;

public class Circunferencia {
    public static void main(String[] args) throws Exception {
        double pi = 3.14;
        Scanner le = new Scanner(System.in);

        System.out.print("Qual é o raio da circunferência (em metros)? ");
        double raio = le.nextDouble();

        double perimetro = 2* raio * pi;

        System.out.print("O perímetro da circunferência é " + perimetro + " metro(s).");
        le.close();
    }
}
