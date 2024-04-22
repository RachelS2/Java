import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Insira um texto: ");
        Scanner input = new Scanner(System.in);
        String texto = input.next();
        int ponto = texto.indexOf(".", 0);

        var numeroStr = texto.substring(ponto+1);
        if (numeroStr.valueOf


        input.close();
    }
}
