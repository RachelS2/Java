import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Valor de x: ");
        int x = input.nextInt(); 

        System.out.print("Valor de y: ");
        int y = input.nextInt(); 

        int aux = 0;
        int resultado = 0;
        boolean stop = false;
        while (stop != true) 
        {
            resultado = aux * y; 

            if (resultado == x)
            {
                stop = true;
                System.out.print("A divisão de " + x + " por " + y + " vale " + aux + " e tem resto " + (resultado - x));
                break;
            }

            else if (resultado > x)
            {
                stop = true;
                System.out.print("A divisão de " + x + " por " + y + " vale " + (aux-1) + " e tem resto " + ( x - (y * (aux-1) )));
                break;
            }

            aux++; 
        }
        
        input.close();
    }
}
