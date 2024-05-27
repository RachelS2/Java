import java.util.Scanner;

public class Program 
{
    public static void main(String[] args) 
    {
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


        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        Pessoa.Inicio();

        if (numero == 1)
        {
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.InserirPessoa();
        }

        else if (numero == 2)
        {
            PessoaJuridica pessoaJuri = new PessoaJuridica();
            pessoaJuri.InserirPessoa();
        }

        else if (numero == 3) 
        {
            System.out.println("Insira o CPF ou CNPJ da pessoa: ");
            String id = input.nextLine();
            Pessoa.ChecarAgenda(id);
        }

        else if (numero == 4) 
            Pessoa.ImprimirAgenda();
        
        else 
        {
            System.out.println("Opção inválida. Tente novamente.");
            MenuPrincipal();
        }
        input.close();
    }
}
