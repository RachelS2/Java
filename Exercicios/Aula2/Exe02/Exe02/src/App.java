import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o primeiro lado do triângulo: ");
        int A = input.nextInt();

        System.out.print("Insira o segundo lado do triângulo: ");
        int B = input.nextInt();

        System.out.print("Insira o terceiro lado do triângulo: ");
        int C = input.nextInt();

        if (A == B && B == C)
            System.out.println("Triângulo equilátero.");
        
        else if ((A == B && A != C) || (A == C && A !=B) || (B == C && B != A))
            System.out.println("Triângulo isósceles.");
        
        else 
        {
            if (A + B > C || A + C > B || B + C > A)
                System.out.println("Triângulo escaleno");
        }
        input.close();
    }
}
