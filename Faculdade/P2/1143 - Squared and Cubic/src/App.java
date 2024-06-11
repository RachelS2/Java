import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        PadraoNumero pattern = new Questao();
        pattern.imprimePadrao(N);
        
        scanner.close();
    }
}

interface PadraoNumero {
    void imprimePadrao(int N);
}

class Questao implements PadraoNumero {
    @Override
    public void imprimePadrao(int N) {
        for (int i = 1; i <= N; i++) {
            System.out.printf("%d %d %d%n", i, i*i, i*i*i);
        }
    }
}