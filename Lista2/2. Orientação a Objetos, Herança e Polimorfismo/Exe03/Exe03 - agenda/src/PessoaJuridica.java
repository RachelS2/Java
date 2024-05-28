import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaJuridica extends Pessoa
{
    static List<List<String>> PessoaJuridica;
    
    public static void IniciaLista()
    {
        PessoaJuridica = new ArrayList<>();
    }

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
        List<String> pessoa = new ArrayList<>(List.of(cnpj, nome, endereco, faturamento));
        PessoaJuridica.add(pessoa);
        Agenda.put(2, PessoaJuridica);
        Opcoes(input);
    }

    public static void Opcoes(Scanner input)
    {
        System.out.println("\nVocê deseja...");
        System.out.println("[1] Inserir mais uma pessoa na agenda");
        System.out.println("[2] Voltar ao menu principal");
        System.out.println("[3] Verificar uma pessoa jurídica");
        System.out.println("[4] Verificar todas as pessoas jurídicas");
        System.out.println("[5] Encerrar o programa");

        int opcao = input.nextInt();

        switch (opcao){
            case 1: 
                InserirPessoa(); 
                break;

            case 2: 
                Program.MenuPrincipal(); 
                break;

            case 3:
                System.out.print("\nInsira o CNPJ do contato: ");
                String cnpj = input.next();
                List<String> contato = ChecarAgenda(cnpj);
                if (contato != null)
                    ImprimirCNPJ(contato);
                else 
                    System.out.println("CNPJ não encontrado. Tente novamente.");
                break;
            
            case 4: 
                System.out.println("\n~~~~~~~~~~ PESSOAS JURÍDICAS ~~~~~~~~~~");
                ImprimirPessoa(2);
                break;

            case 5:
                System.out.println("\nEncerrando o programa...");
            
            default:
                System.out.println("\nOpção inválida. Tente novamente."); break;
        }
            
    }

    public static void ImprimirCNPJ(List<String> contato)
    {
        System.out.println("\nCNPJ: " + contato.get(0));
        System.out.println("Razão Social: " + contato.get(1));
        System.out.println("Endereço: " + contato.get(2));
        System.out.println("Faturamento: " + contato.get(3));
    }
}

