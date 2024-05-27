import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class PessoaFisica extends Pessoa
{

    public static void InserirPessoa()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n-> NOME: ");
        String nome = input.nextLine();
        System.out.println("\n-> ENDEREÇO: ");
        String endereco = input.nextLine();
        System.out.println("\n-> CPF: ");
        String cpf = input.nextLine();
        System.out.println("\n-> Data de aniversário (DD/MM/YYYY): ");
        String aniversario = input.nextLine();
        List<String> pessoa = new ArrayList<>(List.of(nome, endereco, aniversario));
        
        Map<String,List<String>> value = new HashMap<>();
        value.put(cpf, pessoa);
        Agenda.put(1, value);
        Opcoes(input);
    }

    public static void Opcoes(Scanner input)
    {
        System.out.println("\nVocê deseja...");
        System.out.println("[1] Inserir mais uma pessoa na agenda");
        System.out.println("[2] Voltar ao menu principal");
        System.out.println("[3] Verificar uma pessoa física");
        System.out.println("[4] Verificar todas as pessoas físicas");
        System.out.println("[5] Encerrar o programa");

        int opcao = input.nextInt();
        if (opcao == 1)
            InserirPessoa();
        else if (opcao == 2)
            Program.MenuPrincipal();
        else if (opcao == 3)
        {
            System.out.print("\nInsira o CPF do contato: ");
            String cpf = input.next();
            List<String> contato = ChecarAgenda(cpf);
            if (contato != null)
                ImprimirCPF(cpf, contato);
            
            else {
                System.out.println("CPF não encontrado. Tente novamente.");
            Opcoes(input); }
        }

        else if (opcao == 5)
            System.out.println("\nEncerrando o programa...");
        else {
            System.out.println("\nOpção inválida. Tente novamente.");
            Opcoes(input);
        }
        input.close();
    }

    public static void ImprimirCPF(String cpf, List<String> contato)
    {
        System.out.println("\nCPF: " + cpf);
        System.out.println("Nome: " + contato.get(0));
        System.out.println("Endereço: " + contato.get(1));
        System.out.println("Data de aniversário: " + contato.get(2) + "\n");
        Scanner x = new Scanner(System.in);
        Opcoes(x);
    }
}
