import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            int numero = random.nextInt(100);
            lista.add(numero);
        }
        Collections.sort(lista);
        System.out.println("\nLISTA ORDENADA: ");
        for (int i = 0; i < 100; i++)
            System.out.println(lista.get(i));
    }
}
