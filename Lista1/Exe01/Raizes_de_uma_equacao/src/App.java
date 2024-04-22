import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Valor de a: ");
        int a = input.nextInt();

        System.out.print("Valor de b: ");
        int b = input.nextInt();

        System.out.print("Valor de c: ");
        int c = input.nextInt();

        int delta = (int) (b*b) - 4 * a * c;

        float raizPos = (float) ( -b + Math.sqrt(delta) ) / 2 * a;
        float raizNeg = (float) ( -b - Math.sqrt(delta) ) / 2 * a;

        System.out.println("x' = " + raizPos);
        System.out.print("x'' = " + raizNeg);

        input.close();
    }
}
