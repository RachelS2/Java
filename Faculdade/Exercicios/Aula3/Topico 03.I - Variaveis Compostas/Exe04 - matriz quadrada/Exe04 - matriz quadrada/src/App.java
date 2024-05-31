import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Insira a ordem da matriz quadrada: ");
        Scanner input = new Scanner(System.in);
        int ordem = input.nextInt();

        if(ordem < 100) 
        {
            int[][] matriz = new int[ordem][ordem];
            for (int linha = 0; linha < ordem; linha++)
            {
                for (int coluna = 0; coluna < ordem; coluna++) 
                {
                    System.out.print("Insira o elemento [" + (linha+1) + ", " + (coluna+1) + "] da matriz: " );
                    matriz[linha][coluna] = input.nextInt();
                }
            }

            System.out.print("\nIMPRIMINDO A MATRIZ:\n");
            for (int linha = 0; linha < ordem; linha++)
            {
                for (int coluna = 0; coluna < ordem; coluna++) 
                {
                    System.out.print(matriz[linha][coluna] + " ");
                }
                System.out.print("\n");
            }

            System.out.print("\nMATRIZ TRANSPOSTA:\n");
            for (int linha = 0; linha < ordem; linha++)
            {
                for (int coluna = 0; coluna < ordem; coluna++) 
                {
                    System.out.print(matriz[coluna][linha] + " ");
                }
                System.out.print("\n");
            }
        }

        else 
            System.out.print("Não são aceitas ordens maiores do que 99. Reinicie o programa e tente novamente.");

        input.close();
    }
}
