import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] forca1 = new int[1][3];
        int[][] forca2 = new int[1][3];

        Scanner input = new Scanner(System.in);
        
        for(int i = 0; i < 3; i++) 
        {
            System.out.print("\nInsira a coordenada " + (i+1) + " do vetor 1: ");
            forca1[0][i] = input.nextInt();

            System.out.print("Insira a coordenada " + (i+1) + " do vetor 2: ");
            forca2[0][i] = input.nextInt();

            int forcaResultante = forca1[0][i] + forca2[0][i];

            System.out.println("\nA força resultante é " + forcaResultante);
        }
        input.close();
    }
}
