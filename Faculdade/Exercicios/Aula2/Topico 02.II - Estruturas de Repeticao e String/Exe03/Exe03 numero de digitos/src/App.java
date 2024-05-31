import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Insira um número: ");
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        if (numero < 10) 
            System.out.print("Esse número tem 1 dígito. ");

        else if (numero < 100) 
            System.out.print("Esse número tem 2 dígitos. ");

        else if (numero < 1000) 
            System.out.print("Esse número tem 3 dígitos. ");

        else if (numero < 10000) 
            System.out.print("Esse número tem 4 dígitos. ");

        else 
        {
            int potencia = 5; 
            while (true) 
            {
                int baseExponte = (int)Math.pow(10, potencia);
                if (numero < baseExponte) 
                {
                    System.out.print("Esse número tem " + potencia + " dígitos.");
                    break;
                }
                potencia++;
            }
        }
        input.close();
    }
}
