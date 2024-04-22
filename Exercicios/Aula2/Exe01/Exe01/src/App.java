import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a média do aluno: ");
        double media = input.nextDouble();
        if (media < 4)
            System.out.print("Reprovado.");
        else if (media < 6)
            System.out.print("Vai para a VS");
        else if (media >= 6)
            System.out.print("Passou direto");
        input.close();
    }
}
