import java.util.Scanner;
import java.util.*;
import java.util.List;

public class Pessoa 
{
    private Map<Integer, List<String>> People;
    Scanner Input = new Scanner(System.in);
    
    public void Cadastro()
    {
        System.out.println("\n---------------- CADASTRO ----------------");
        System.out.println("Deseja se cadastrar [S/N]?");
        String option = Input.nextLine();
        if (option.equalsIgnoreCase("S"))
        {
            System.out.print("-> NOME: ");
            String name = Input.next();
            
            System.out.print("-> EMAIL: ");
            String email = Input.next();

            if (CheckValue(email) == false) 
            {
                System.out.print("-> TELEFONE: ");
                String telefone = Input.next();
                
                System.out.print("-> ENDEREÇO: ");
                String address = Input.next();
                
                System.out.print("-> DATA DE NASCIMENTO: ");
                String birthday = Input.next();

                int id = IDGenerator();        
                System.out.println("Seu número de matrícula é: " + id);

                System.out.println("Insira uma senha para login: ");
                String password = Input.next();

                System.out.println("Cadastro gerado com sucesso!");

                List<String> data = Arrays.asList(name, email, telefone, address, birthday, password);
                People.put(id, data);
            }
            else 
            {
                System.out.println("Esse e-mail já possui um cadastro no sistema. Tente novamente.");
                Cadastro();
            }
        }

        else if (option.equalsIgnoreCase("N"))
            Login();

        else 
        {
            System.out.println("Opção inválida. Tente novamente.");
            Cadastro();
        }
    }

    public void Login()
    {
        System.out.print("-> NÚMERO DE MATRÍCULA: ");
        int id = Input.nextInt();
        System.out.print("-> SENHA: ");
        String password = Input.next();
        if (CheckKeyAndValue(id, password) == true) 
        {
            
        }
    }

    public boolean CheckValue(Object object)
    {
        if (People != null) 
        {
            for (Map.Entry<Integer, List<String>> people : People.entrySet())
            {
                List<String> list = people.getValue();
                if (list != null & list.contains(object))
                    return true;
            }       
        }
        return false;
    }

    public boolean CheckKeyAndValue(int id, String password )
    {
        for (Map.Entry<Integer, List<String>> people : People.entrySet())
        {
            List<String> list = people.getValue();
            int integer = people.getKey();
            if (integer == id && list.contains(password))
                return true;
        }
        return false;
    }

    public boolean CheckKey(int object)
    {
        for (Map.Entry<Integer, List<String>> people : People.entrySet())
        {
            if (people.getKey() == object)
                return true;
        }
        return false;
    }

    public int IDGenerator()
    {
        int max = 999999;
        int min = 111111;
        Random random = new Random();
        int id = random.nextInt(max - min + 1) + min;
        if (CheckKey(id) == false)
            return id;
        else
            IDGenerator();
        return 0;
    }

    public void CloseInput() {
        Input.close(); 
    }
}
