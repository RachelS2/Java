import java.util.Scanner;
public class ConverteTemp {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        double tempCelsius, tempFahr;
        System.out.print("Informe a temperatura em celsius: ");
        tempCelsius = teclado.nextDouble();

        tempFahr = tempCelsius * 1.8 + 32;

        System.out.print("A temperatura dada, em Fahreinheit, é " + tempFahr);
        
        teclado.close();
    }
}
