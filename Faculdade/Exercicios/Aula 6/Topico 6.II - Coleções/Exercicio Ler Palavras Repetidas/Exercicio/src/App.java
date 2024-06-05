import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira uma frase:");
        String frase = input.nextLine();
        String[] vetor = frase.split(" ");
        Set<String> palavras = new HashSet();
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i].toString());
            palavras.add(vetor[i].toLowerCase());
        }
            
        System.out.println("A frase tem " + palavras.size() + " palavra(s).");
        input.close();
    }
}
