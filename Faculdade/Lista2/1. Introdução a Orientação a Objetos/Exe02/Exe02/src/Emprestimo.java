import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Emprestimo 
{
    Map<Integer, List<String>> PeoplesData;
    Map<Integer, Map<String, String>> LoanData;
    public void Data(String bookName, Map<Integer, List<String>> person) 
    {
        PeoplesData = person;
        System.out.print("\nVocê deseja alugar o livro '" + bookName + "' [S/N]? ");
        Scanner input = new Scanner(System.in);
        String option = input.nextLine();
        if (option.equalsIgnoreCase("S"))
        {
            LoanRules();
            LocalDate rentDay = LocalDate.now();
        
            LocalDate devolutionDay = rentDay.plusWeeks(2);
        
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("\nNome do livro: " + bookName);
            System.out.println("Nome do(a) usuário(a): " + UserName());
            System.out.println("Matrícula do(a) usuário(a): " + UserID());
            System.out.println("Data do aluguel: " + formatter.format(rentDay));
            System.out.println("Data da devolução: " + formatter.format(devolutionDay) + "\n");
        }

        input.close();
    }

    public String UserName() 
    {
        String name = "";
        for (Map.Entry<Integer, List<String>> people : PeoplesData.entrySet())
        {
            List<String> list = people.getValue();
            name = list.get(0);
        }
        return name;       
    }

    public Integer UserID() 
    {
        for (Map.Entry<Integer, List<String>> people : PeoplesData.entrySet())
            return people.getKey();
        return 0;
    }

    public void LoanRules()
    {
        System.out.println("\n--------------------- REGRAS DO ALUGUEL DE LIVROS ---------------------");
        System.out.println("1. SOBRE O PRAZO");
        System.out.println("1.1 Devolver o livro no prazo determinado no momento do aluguel.");
        System.out.println("1.2 Só é permitido o aluguel de um livro por vez.");
        System.out.println("1.3 Haverá uma taxa de 10 centavos para cada dia em que o prazo seja ultrapassado.");
        System.out.println("\n2. SOBRE O USO E CONSERVAÇÃO");
        System.out.println("2.1 É proibido rasurar, rabiscar, dobrar, rasgar e/ou molhar páginas do livro.");
        System.out.println("2.2 É proibido emprestar e/ou comercializar qualquer livro alugado desta biblioteca.");

    }
}
