import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;

public class Pessoa {
    static Scanner Input;
    static Map<String, List<String>> Familia;
    public static void main(String[] args) throws Exception 
    {
        Familia = new HashMap<>();
        Input = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = Input.nextLine();
        List<String> listaNome = new ArrayList<>(Arrays.asList(nome));
        Map<String, List<String>> filiacao = PegaInfo(listaNome);
        for (int n = 0; n < listaNome.size(); n++)
            Escolha(listaNome.get(n), PegaParente(filiacao)); 
    }

    public static List<String> PegaParente(Map<String, List<String>> dicionario){
        List<String> parentes = new ArrayList<>(Arrays.asList("")) ;
        for (Entry<String, List<String>> entry : dicionario.entrySet()) 
        {
            parentes = entry.getValue();
        }
        return parentes;
    }

    public static Map<String, List<String>> PegaInfo(List<String> nome)
    {
        Map<String, List<String>> filiacao = new HashMap<>();
        String pai = "", mae = "", idade;
        for (int n = 0; n < nome.size(); n++){
            System.out.println("\nIdade de " + nome.get(n) + ": ");
            idade = Input.next();
            System.out.println("\nPai de " + nome.get(n) + ": ");
            pai = Input.next();
            System.out.println("\nMãe de " + nome.get(n) + ": ");
            mae = Input.next();
            List<String> dados = Lista(idade, mae, pai);
            List<String> filiais = new ArrayList<>(List.of(pai, mae));
            Familia.put(nome.get(n), dados);
            filiacao.put(nome.get(n), filiais);
        }
        return filiacao;
    }

    public static List<String> Lista(String idade, String mae, String pai)
    {
        List<String> dados = new ArrayList<>(List.of(idade, pai, mae));
        return dados;
    }

    public static void Escolha(String filho, List<String> filiacao)
    {
        for (int parentes = 0; parentes < filiacao.size(); parentes++){
            System.out.print("\nO QUE DESEJA FAZER: ");
            System.out.print("\n[1] Inserir a filiação dos pais de " + filho);
            System.out.print("\n[2] Encerrar o programa\n");
            int esc = Input.nextInt();

            if (esc == 1)
            {
                Map<String, List<String>> familia = PegaInfo(filiacao);
                List<String> avos = PegaParente(familia);
                Escolha(PegaNome(familia), avos);
            }
                

            else if (esc == 2) 
                System.out.print("\nEncerrando o programa...");

            else 
                {
                System.out.print("\nEntrada inválida. Tente novamente.");
                Escolha(filho, filiacao);
                }   
        }
        
    }

    // public static void Teste(String pai, String mae)
    // {
    //     System.out.println("\nDeseja inserir a filiação de " + pai + " e " + mae + " [S/N]?");
    //     String opcao = Input.next();
    //     if (opcao.equalsIgnoreCase("S"))
    //     {
    //         List<String> filiacao = new ArrayList<>(List.of(pai, mae));
    //         Map<String, List<String>> familia = PegaInfo(filiacao);
    //         String avoHomem = PegaParente(familia, 0);
    //         String avoMulher = PegaParente(familia, 1);
    //         for (int n = 0; n < filiacao.size(); n++)
    //             Escolha(PegaNome(familia), avoHomem, avoMulher);
    //     }
    // }

    public static String PegaNome( Map<String, List<String>> filiacao){
        for (Entry<String, List<String>> entry : filiacao.entrySet()) 
        {
            String parentes = entry.getKey();
            return parentes;
        }
        return null;
    }
}

