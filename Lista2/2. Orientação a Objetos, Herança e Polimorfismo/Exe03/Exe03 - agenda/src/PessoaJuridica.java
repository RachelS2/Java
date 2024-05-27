import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PessoaJuridica extends Pessoa
{
    public static void InserirPessoa()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n-> RAZÃO SOCIAL: ");
        String nome = input.nextLine();
        System.out.println("\n-> ENDEREÇO: ");
        String endereco = input.nextLine();
        System.out.println("\n-> CNPJ: ");
        String cnpj = input.nextLine();
        System.out.println("\n-> FATURAMENTO: ");
        String faturamento = input.nextLine();

        List<String> pessoa = new ArrayList<>(List.of(nome, endereco, faturamento));
        Map<String,List<String>> value = new HashMap<>();
        value.put(cnpj, pessoa);
        Agenda.put(2, value);
        Opcoes(input);
    }

    public static void Opcoes(Scanner input)
    {
        System.out.println("\nVocê deseja...");
        System.out.println("[1] Inserir mais uma pessoa na agenda");
        System.out.println("[2] Voltar ao menu principal");
        System.out.println("[3] Verificar uma pessoa jurídica");
        System.out.println("[4] Encerrar o programa");

        int opcao = input.nextInt();

        if (opcao == 1)
            InserirPessoa();

        else if (opcao == 2)
            Program.MenuPrincipal();

        else if (opcao == 3)
        {
            System.out.print("\nInsira o CNPJ do contato: ");
            String cnpj = input.next();
            List<String> contato = ChecarAgenda(cnpj);
            if (contato != null)
                ImprimirCNPJ(cnpj, contato);
            
            else {System.out.println("CNPJ não encontrado. Tente novamente.");
            Opcoes(input);}
        }
            
        else if (opcao == 4)
            System.out.println("\nEncerrando o programa...");
        else 
        {
            System.out.println("\nOpção inválida. Tente novamente.");
            Opcoes(input);
        }

    }

    public static void ImprimirCNPJ(String cnpj, List<String> contato)
    {
        System.out.println("\nCNPJ: " + cnpj);
        System.out.println("Razão Social: " + contato.get(0));
        System.out.println("Endereço: " + contato.get(1));
        System.out.println("Faturamento: " + contato.get(2));
    }
}

