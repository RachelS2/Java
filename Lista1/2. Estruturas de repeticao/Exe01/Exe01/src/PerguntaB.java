import java.util.Scanner; 
public class PerguntaB { 
    public static void main(String[] args) 
    { 
        Scanner teclado = new Scanner(System.in); 
        Integer codigo; 
        do { 
            System.out.print("Informe o codigo: "); 
            codigo = teclado.nextInt(); 
            if (codigo != -1)
                System.out.println("Codigo: " + codigo); 
            } 
            while (codigo !=-1); 
        teclado.close();
    } 
}