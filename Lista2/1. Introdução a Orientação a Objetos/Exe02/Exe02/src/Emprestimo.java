import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Emprestimo 
{
    Map<Integer, List<String>> PeoplesData;
    public void Data(String bookName, Map<Integer, List<String>> person) 
    {
        PeoplesData = person;
        System.out.print("\nVocê deseja alugar o livro '" + bookName + "' [S/N]? ");
        Scanner input = new Scanner(System.in);
        String option = input.nextLine();
        if (option.equalsIgnoreCase("S"))
        {
            LocalDate rentDay = LocalDate.now();
        
            LocalDate devolutionDay = rentDay.plusWeeks(2);
        
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("Nome do livro: " + bookName);
            System.out.println("Nome do(a) usuário(a): " + UserName());
            System.out.println("Data do aluguel: " + formatter.format(rentDay));
            System.out.println("Data da devolução: " + formatter.format(devolutionDay));
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
}
