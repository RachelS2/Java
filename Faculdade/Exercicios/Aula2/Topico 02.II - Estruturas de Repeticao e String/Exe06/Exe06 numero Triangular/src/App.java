import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um número e descubra se ele é triangular: ");
        int numero = input.nextInt();

        int maximo = 1;
        int soma = 0;
        
        while (soma < numero) 
        {
            soma += maximo;
            maximo ++;
        }

        if (soma == numero) 
        {
        System.out.print("O número é triangular.");
        }

        input.close();
    }
}
