import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Insira um texto: ");
        Scanner input = new Scanner(System.in);
        String texto = input.next();
        int ponto = texto.indexOf(".", 0);

        String numeroStr = texto.substring(ponto+1);        

        try {
                int numero = Integer.parseInt(numeroStr);
                System.out.println("O número após o ponto é um número real: " + numero);
            } 
        catch (NumberFormatException e) 
            {
                System.out.println("O character após o ponto não é um número real.");
            }

        input.close();
    }
}
