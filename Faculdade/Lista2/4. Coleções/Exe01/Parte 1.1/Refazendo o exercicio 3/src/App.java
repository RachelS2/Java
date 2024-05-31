import java.util.*;
public class App {
    public static void main(String[] args) throws Exception 
    {
        List<Integer> lista1 = GeraLista();
        List<Integer> lista2 = GeraLista();
        List<Integer> lista3 = SomaListas(lista1, lista2);
        ImprimeLista(lista3);
    }

    public static List<Integer> GeraLista()
    {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++)
        {
            int numero = random.nextInt(100);
            lista.add(numero);
        }
        Collections.sort(lista);
        return lista;
    }

    public static List<Integer> SomaListas(List<Integer> lista1, List<Integer> lista2)
    {
        List<List<Integer>> listas = Arrays.asList(lista1, lista2);

        List<Integer> lista = new ArrayList<>();
        for (int l = 0; l < listas.size(); l ++)
        {
            List<Integer> listaAtual = listas.get(l);
            for (int i = 0; i < 50; i++)
            {
                int numero = listaAtual.get(i);
                lista.add(numero);
            }
        }
        Collections.sort(lista);
        return lista;
    }

    public static void ImprimeLista(List<Integer> lista)
    {
        for (int l = 0; l < lista.size(); l ++)
            System.out.println(lista.get(l));
        
    }
}

