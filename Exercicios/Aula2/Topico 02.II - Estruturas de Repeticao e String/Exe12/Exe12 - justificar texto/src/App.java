import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Insira um texto: ");
        String texto = input.nextLine(); 

        System.out.print("Em quantas colunas deseja justificar o texto? ");
        int colunas = input.nextInt();

        int inicioLinha = 0;
        while (inicioLinha < texto.length()) {
            int fimLinha = inicioLinha + colunas;
            if (fimLinha >= texto.length()) {
                fimLinha = texto.length();
            } else {
                // Verifica se a última palavra da linha ultrapassou as colunas e ajusta o fim da linha
                int indexUltimoEspaco = texto.lastIndexOf(" ", fimLinha);
                if (indexUltimoEspaco != -1 && indexUltimoEspaco > inicioLinha) {
                    fimLinha = indexUltimoEspaco;
                }
            }
            System.out.println(texto.substring(inicioLinha, fimLinha));
            inicioLinha = fimLinha + 1;
        }

        input.close();
    }
}