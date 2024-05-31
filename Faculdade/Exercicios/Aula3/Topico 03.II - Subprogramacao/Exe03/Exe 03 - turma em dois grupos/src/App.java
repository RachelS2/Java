import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Quantos alunos tem o grupo 1? ");
        int N = input.nextInt();

        System.out.println("Quantos alunos tem o grupo 2? ");
        int M = input.nextInt();

        System.out.print(Fatorial(N)); //Fatorial(M);
    }

    public static int Fatorial(int numero) 
    {
        int fatorial = 1;
        for(int i= 1; i <= numero; i++)
        {
            fatorial = fatorial * i;
        }
        return fatorial;
    }
}
