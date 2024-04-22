import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Quantos valores serão lidos? ");
        int numValores = input.nextInt();

        int count = 0;
        for(int i = 0; i < numValores; i++) {
            
            System.out.println("Insira o " + (i+1) + "º valor: ");
            int valor = input.nextInt();

            count += Math.pow(valor, 2);
        }
        System.out.println("A soma dos quadrados dos " + numValores + " valores é " + count);
        input.close();
    }
}
