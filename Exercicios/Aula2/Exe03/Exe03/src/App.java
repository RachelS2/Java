import java.util.Scanner;
import java.lang.Character;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número inteiro de 5 dígitos: ");
        String num = input.nextLine();

        if (num.length() != 5)
            System.out.println("Número inválido. Reinicie o programa e tente novamente.");
        else
        {
            int count = 0;
            int last = 4;
            for(int i = 0; i < 5; i++) 
            {
                String firstChar = Character.toString(num.charAt(i));
                String lastChar = Character.toString(num.charAt(last));

                if (firstChar.equals(lastChar)) 
                    count++;
                last--;
            }
            if (count == 5)
                System.out.print("Esse número é um palíndromo.");
            else
                System.out.print("Esse número não é um palíndromo.");
        }
        input.close();
    }
}
