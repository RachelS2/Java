import java.util.Scanner;
import java.util.List;

public class Program 
{
    public static void main(String[] args) 
    {
        Pessoa.IniciaAgenda();
        PessoaFisica.IniciaLista();
        PessoaJuridica.IniciaLista();
        MenuPrincipal();
    }

    public static void MenuPrincipal() 
    {
        System.out.println("\n~~~~~~~~~~ MENU PRINCIPAL ~~~~~~~~~~");
        System.out.println("Insira o número equivalente ao que deseja fazer: ");
        System.out.println("\n[1] Cadastrar pessoa física");
        System.out.println("[2] Cadastrar pessoa jurídica");
        System.out.println("[3] Acessar um contato");
        System.out.println("[4] Acessar todos os contatos");
        System.out.println("[5] Encerrar o programa");
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();

        switch (numero){
            case 1:
                PessoaFisica.InserirPessoa();
                break;
                
            case 2:
                PessoaJuridica.InserirPessoa();
                break;

            case 3:
                AcessarContato(input);
                break;
                
            case 4: 
                Pessoa.ImprimirAgenda();
                break;

            case 5:
                System.out.println("Encerrando o programa...");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                MenuPrincipal();
                break;
        }
        input.close();
    }

    public static void AcessarContato(Scanner input)
    {
        System.out.println("\nO contato é uma pessoa: ");
        System.out.println("[1] FÍSICA");
        System.out.println("[2] JURÍDICA");
        int pessoa = input.nextInt();
        System.out.println("");
        System.out.print("Insira o CPF ou o CNPJ da pessoa: ");
        String id = input.next();
        List<String> contato = Pessoa.ChecarAgenda(id);
        if (contato == null)
        {
            System.out.println("Pessoa não cadastrada no sistema.");
            MenuPrincipal();
        }
        else 
        {
            if (pessoa == 1)
                Pessoa.ImprimirPessoa(1);
            else if (pessoa == 2) 
                Pessoa.ImprimirPessoa(2);
        }
    }
}
