import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um número: ");
        int number = input.nextInt();
        int divider = number;
        int count = 0;

        while (divider != 1) {
            if (number % divider == 0)
                count++;
            divider--;
        }

        if (count < 3)
            System.out.print(number + " é um número primo.");
        else 
            System.out.print(number + " NÃO é um número primo.");

        input.close();
    }
}
