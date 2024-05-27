import java.util.Scanner;

public class Program 
{
    public static void main(String[] args) 
    {
        MenuPrincipal();
    }

    public static void MenuPrincipal()
    {
        System.out.println("~~~~~~~~~~ MENU PRINCIPAL ~~~~~~~~~~");
        System.out.println("Insira o número equivalente ao tipo de pessoa que deseja cadastrar: ");
        System.out.println("[1] Pessoa Física");
        System.out.println("[2] Pessoa Jurídica");

        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();

        if (numero == 1)
        {
            Pessoa pessoaFisica = new Pessoa();
            pessoaFisica.InserirPessoa();
        }

        else if (numero == 2)
        {
            Pessoa pessoaFisica = new Pessoa();
            pessoaFisica.InserirPessoa();
        }

        else 
        {
            System.out.println("Opção inválida. Tente novamente.");
            MenuPrincipal();
        }
        input.close();
    }
}
