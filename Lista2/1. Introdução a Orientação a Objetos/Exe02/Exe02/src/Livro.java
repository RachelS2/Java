import java.util.*;
import java.util.List;

public class Livro 
{
    private Map<String, HashMap<String, Integer>> Estoque;
    
    public void StockInitializer() 
    {
        Estoque = new HashMap<>();
        Estoque.put("Romance", RomanceStock());
        Estoque.put("Ficcao", FictionStock());
        Estoque.put("Culinaria", CulinaryStock());
        Estoque.put("Historia", HistoryStock());
        Estoque.put("Ciencia", ScienceStock());
        Estoque.put("AutoAjuda", SelfHelpStock());
    }

    public HashMap<String, Integer> RomanceStock() 
    {
        List<String> booksNames = Arrays.asList("Orgulho e Preconceito", "O Morro dos Ventos Uivantes", "A Culpa é das Estrelas", "Romeu e Julieta");
        List<Integer> booksQty = Arrays.asList(10, 15, 5, 20);
        return MapBuilder(booksNames, booksQty);
    }

    public HashMap<String, Integer> FictionStock() 
    {
        List<String> booksNames = Arrays.asList("Fahreinheit 451", "1984", "Jogos Vorazes", "O Pequeno Príncipe");
        List<Integer> booksQty = Arrays.asList(8, 6, 3, 10);
        return MapBuilder(booksNames, booksQty);
    }

    public HashMap<String, Integer> CulinaryStock() 
    {
        List<String> booksNames = Arrays.asList("Chef profissional", "Direto ao Pão", "Pitadas da Rita", "Receitas Saborosas sem Trigo");
        List<Integer> booksQty = Arrays.asList(5, 3, 1, 4);
        return MapBuilder(booksNames, booksQty);
    }

    public HashMap<String, Integer> HistoryStock() 
    {
        List<String> booksNames = Arrays.asList("Uma breve história da humanidade", "Pai Rico, Pai Pobre", "Raízes do Brasil", "O Príncipe");
        List<Integer> booksQty = Arrays.asList(9, 2, 7, 1);
        return MapBuilder(booksNames, booksQty);
    }

    public HashMap<String, Integer> ScienceStock() 
    {
        List<String> booksNames = Arrays.asList("Cosmo", "A Origem das Espécies", "Uma Breve História do Tempo", "Primavera Silenciosa");
        List<Integer> booksQty = Arrays.asList(3, 1, 5, 0);
        return MapBuilder(booksNames, booksQty);
    }

    public HashMap<String, Integer> SelfHelpStock() 
    {
        List<String> booksNames = Arrays.asList("O Poder do Hábito", "12 Regras para a Vida", "Como fazer amigos e influenciar pessoas", "A Coragem de não agradar");
        List<Integer> booksQty = Arrays.asList(0, 6, 4, 9);
        return MapBuilder(booksNames, booksQty);
    }

    public HashMap<String, Integer> MapBuilder(List<String> booksNames, List<Integer> booksQty) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        for (int count = 0; count < booksNames.size(); count++) 
            map.put(booksNames.get(count), booksQty.get(count));
        
        return map;
    }

    public void Romance() 
    {
        System.out.println("\n----------------- ROMANCE -----------------");
        RunMap("Romance");
    }

    public void RunMap (String categoryName) 
    {
        System.out.println("\n-> Livros ofertados e total em estoque: ");
        HashMap<String, Integer> totalBooks = Estoque.get(categoryName);
        int option = 1;
        for (Map.Entry<String, Integer> total : totalBooks.entrySet())
        {
            System.out.println("\n[" + option + "] " + total.getKey() + "\n- Total em estoque: " + total.getValue());
            option++;
        }
        System.out.println("\n-> Selecione o livro desejado com base em seu número: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        option = 1;
        for (Map.Entry<String, Integer> total : totalBooks.entrySet())
        {
            if (option == choice) 
            {
                if (total.getValue() > 0)
                {
                    totalBooks.replace(total.getKey(), total.getValue(), total.getValue() - 1);
                    Emprestimo e = new Emprestimo();
                }

                else 
                {
                    System.out.println("Esse livro não está disponível no momento.");
                    CallOptions();
                }
            }
            option++;
        }
        input.close();
    }

    public static void CallOptions()
    {
        Program.Options();
    }

    public void Fiction() 
    {
        System.out.println("\n----------------- FICÇÃO -----------------");
        RunMap("Ficcao");
    }
    
    public void Culinary() 
    {
        System.out.println("\n----------------- CULINÁRIA -----------------");
        RunMap("Culinaria");
    }
    
    public void History() 
    {
        System.out.println("\n----------------- HISTÓRIA -----------------");
        RunMap("Historia");
    }

    public void Science() 
    {
        System.out.println("\n----------------- CIÊNCIA -----------------");
        RunMap("Ciencia");
    }

    public void SelfHelp() 
    {
        System.out.println("\n----------------- AUTO-AJUDA -----------------");
        RunMap("AutoAjuda");
    }
}
