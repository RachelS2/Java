import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int[][] matriz_Um = new int[2][3];
        int[][] matriz_Dois = new int[3][2];

        int[][] matriz_Result = new int[3][3];

        //MATRIZ UM 
        System.out.print("\n~~~ MATRIZ UM ~~~ \n");
        for(int linha = 0; linha < 2; linha++) 
        {
            for(int coluna = 0; coluna < 3; coluna++)
                {
                    System.out.print("Insira o elemento [" + (linha+1) + ", " + (coluna+1) + "]: ");
                    matriz_Um[linha][coluna] = input.nextInt();
                }
        }

        //MATRIZ DOIS
        System.out.print("\n~~~ MATRIZ DOIS ~~~ \n");
        for(int linha = 0; linha < 3; linha++) 
        {
            for(int coluna = 0; coluna < 2; coluna++)
                {
                    System.out.print("Insira o elemento [" + (linha+1) + ", " + (coluna+1) + "]: ");
                    matriz_Um[linha][coluna] = input.nextInt();
                }
        }

        //MATRIZ RESULTADO
        int k = 0;
        for(int linha = 0; linha < 3; linha++) 
        {
            for(int coluna = 0; coluna < 3; coluna++)
            {    
                matriz_Result[linha][coluna] = matriz_Um[linha][k] * matriz_Dois[k][coluna];
                k++;
            }
        } 
        input.close();
    }
} 
