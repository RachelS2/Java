import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("\nVetor ordenado por Insertion Sort:");
        PercorreVetor(InsertionSort());
        
        System.out.println("\nVetor ordenado por Selection Sort:");
        PercorreVetor(SelectionSort());  
        
    }

    public static void PercorreVetor(int[] vetor)
    {
        for (int i = 0; i < 10; i++) {
            System.out.print(vetor[i] + " ");
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

    public static int[] SelectionSort()
    {
        int[] vetor = new int[10];
        Scanner input = new Scanner(System.in);

        //LISTA DESORDENADA
        for (int i = 0; i < 10; i++) {
            System.out.print("Insira um número: ");
            vetor[i] = input.nextInt();
        }
        //LISTA ORDENADA
        int min = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 0) 
                min = vetor[i];
            else
            {
                if (vetor[i] < min){
                    min = vetor[i];
                    vetor[0] = min;
                }
                    
                else if (vetor[i] < vetor[i-1]) {
                    vetor[i-1] = vetor[i];
                    vetor[i] = vetor[i-1];
                }
            }
        }
        input.close();
        return vetor;
    }
}
