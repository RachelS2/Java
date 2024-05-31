import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaFisica extends Pessoa
{
    static List<List<String>> PessoaFisica;
    
    public static void IniciaLista()
    {
        PessoaFisica = new ArrayList<>();
    }

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
        List<String> pessoa = new ArrayList<>(List.of(cpf, nome, endereco, aniversario));
        PessoaFisica.add(pessoa);
        Agenda.put(1, PessoaFisica);
        Opcoes(input);
    }

    public static void Opcoes(Scanner input)
    {
        System.out.println("\nVocê deseja...");
        System.out.println("[1] Inserir mais uma pessoa física na agenda");
        System.out.println("[2] Voltar ao menu principal");
        System.out.println("[3] Verificar uma pessoa física");
        System.out.println("[4] Verificar todas as pessoas físicas cadastradas");
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
                System.out.print("\nInsira o CPF do contato: ");
                String cpf = input.next();
                List<String> contato = ChecarAgenda(cpf);
                if (contato != null)
                    ImprimirCPF(contato);
                break;

            case 4: 
                System.out.println("\n~~~~~~~~~~ PESSOAS FÍSICAS ~~~~~~~~~~");
                ImprimirPessoa(1);
                break;

            case 5:
                System.out.println("\nEncerrando o programa...");
                break;
            
            default:
                System.out.println("\nOpção inválida. Tente novamente."); break;
        }

        if (opcao !=5)             
            Opcoes(input); 

        input.close();
    }

    public static void ImprimirCPF(List<String> contato)
    {
        System.out.println("\nCPF: " + contato.get(0));
        System.out.println("Nome: " + contato.get(1));
        System.out.println("Endereço: " + contato.get(2));
        System.out.println("Data de aniversário: " + contato.get(3));
    }
}
