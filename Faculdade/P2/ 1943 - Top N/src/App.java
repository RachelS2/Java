import java.util.Scanner;
import java.util.*;
public class App {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 3, 5, 10, 25, 50, 100);
        
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        VouChorar agora = new VouChorar(lista);
        
        int top = agora.AchaMaximo(k);
        System.out.println("Top " + top);
    }
}

class VouChorar
{
    List<Integer> Lista;
    VouChorar(List<Integer> lista)
    {
        Lista = lista;
    }
    
    int AchaMaximo(int k){
        int retorno = 0;
        for (int i = 0; i < Lista.size(); i++){
            int posAtual = Lista.get(i);
            if (posAtual >= k)
                return posAtual;
        }
        return retorno;
    }
    
}