import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception 
    {
       int[] vetorOrdenado = InsertionSort();
        System.out.println("\nVetor ordenado por Inserction Sort:");
        for (int i = 0; i < 10; i++) {
            System.out.print(vetorOrdenado[i] + " ");
        }    
    }

    public static int[] InsertionSort()
    {
        int[] vetor = new int[10];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Insira um número: ");
            int numero = input.nextInt();

            int j = i;
            while (j > 0 && vetor[j - 1] > numero) {
                vetor[j] = vetor[j - 1];
                j--;
            }
            vetor[j] = numero;
        }
        input.close();
        return vetor;
    }


}
