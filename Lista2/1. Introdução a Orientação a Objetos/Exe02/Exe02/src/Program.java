import java.util.Scanner;

public class Program
{
    static Scanner Input;
    static Livro Book;

    public static void main(String[] args) throws Exception 
    {
        System.out.println("\n------------------ BIBLIOTECA VIRTUAL ------------------");
        System.out.println("Deseja alugar um livro? [S/N] ");
        Input = new Scanner(System.in);
        String answer = Input.next();
        if (answer.equalsIgnoreCase("S"))
        {
            Book = new Livro();
            Book.StockInitializer();
            Pessoa person = new Pessoa();
            person.Cadastro();
        }
        Input.close();
    }

    public static void Options()
    {
        System.out.println("\nCategorias disponíveis: ");
        System.out.println("[1] ROMANCE ");
        System.out.println("[2] FICÇÃO ");  
        System.out.println("[3] CULINÁRIA ");  
        System.out.println("[4] HISTÓRIA "); 
        System.out.println("[5] CIÊNCIA ");
        System.out.println("[6] AUTO-AJUDA ");
        System.out.println("\nSelecione uma categoria com base em seu número. ");
        int category = Input.nextInt();
        switch (category)
        {
            case 1:
                Book.Romance(); 
                break;

            case 2: 
                Book.Fiction();
                break;

            case 3: 
                Book.Culinary();
                break;

            case 4: 
                Book.History();
                break;

            case 5: 
                Book.Science();
                break;

            case 6: 
                Book.SelfHelp();
                break;
            default:
                System.out.print("Opção inválida. Reinicie o programa e tente novamente.");
        }
    }
}
