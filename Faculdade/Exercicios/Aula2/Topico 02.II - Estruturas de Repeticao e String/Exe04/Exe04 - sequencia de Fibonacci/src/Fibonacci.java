import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um numero: ");
        int numero = input.nextInt();

        int a = 0;
        int b = 1;

        System.out.println("Sequência de Fibonacci:");

        for (int i = 0; i < numero + 1; i++) 
        {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
    }
}

