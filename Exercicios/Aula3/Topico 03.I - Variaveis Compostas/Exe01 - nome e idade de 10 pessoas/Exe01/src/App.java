import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        String[]nome = new String[10];
        int[]idade = new int[10];

        for (int pessoa = 0; pessoa < 10; pessoa++) 
        {
            System.out.print("\nInsira o nome da " + (pessoa+1) + "ª pessoa: ");
            nome[pessoa] = input.next();

            System.out.print("Insira a idade da " + (pessoa+1) + "ª pessoa: ");
            idade[pessoa] = input.nextInt();
        }

        Arrays.sort(nome);
        Arrays.sort(idade);
        
        System.out.print("\nOrdem alfabética: ");
        for(String name : nome) 
        {
            System.out.print(name);
            System.out.print(" ");
        }

        System.out.print("\nOrdem crescente de idade: ");
        for(int age : idade) 
        {
            System.out.print(age);
            System.out.print(" ");
        }
        input.close();
    }
}
