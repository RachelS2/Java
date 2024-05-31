import java.util.Scanner;

public class RotacoesString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite uma string: ");
        String s = scanner.nextLine();
        
        System.out.println("Rotações à esquerda de \"" + s + "\":");
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            System.out.println(s);
        }
        scanner.close();
    }
}