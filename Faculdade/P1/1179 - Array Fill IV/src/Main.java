import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] par = new int[5];
        int[] impar = new int[5];

        Scanner input = new Scanner(System.in);

        int parCount = 0;
        int imparCount = 0;

        for (int max = 0; max < 15; max++) 
        {
            int numero = input.nextInt();

            if (numero % 2 == 0) 
            {
                par[parCount] = numero;
                parCount++;
            }

            else if (numero % 2 != 0) 
            {
                impar[imparCount] = numero;
                imparCount++;
            }

            if (imparCount == 5 || max == 14) 
            {
                if (imparCount == 5) 
                {
                    for (int count = 0; count < 5; count++)
                        System.out.println("impar[" + count + "] = " + impar[count]);
                    imparCount = 0;
                }

                else 
                {
                    for (int i = 0; i < imparCount; i++)
                        System.out.println("impar[" + i + "] = " + impar[i]);
                }
            }

            if (parCount == 5 || max == 14) 
            {
                if (parCount == 5) 
                {
                    for (int count = 0; count < 5; count++)
                        System.out.println("par[" + count + "] = " + par[count]);
                    parCount = 0;
                } 
                else 
                {
                    for (int i = 0; i < parCount; i++)
                        System.out.println("par[" + i + "] = " + par[i]);
                }
            }
        }
        input.close();

    }

}
