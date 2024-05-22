import java.util.*;

public class Pessoa 
{
    Map<Integer, List<String>> People;
    Scanner Input = new Scanner(System.in);
    
    public void PeopleInitializer()
    {
        People = new HashMap<>();
    }

    public void Log()
    {
        System.out.println("\n----------------------- HALL -----------------------");
        System.out.println("Deseja se cadastrar [S/N]? ");
        String option = Input.nextLine();
        if (option.equalsIgnoreCase("S"))
            Cadastro();

        else if (option.equalsIgnoreCase("N"))
            Login();

        else 
        {
            System.out.println("Opção inválida. Tente novamente.");
            Log();
        }
    }

    public void Cadastro() 
    {
            System.out.println("\n----------------------- CADASTRO -----------------------");
            System.out.println("\n-> NOME: ");
            String name = Input.next();
            
            System.out.println("\n-> EMAIL: ");
            String email = Input.next();

            if (CheckValue(email) == false) 
            {
                System.out.println("\n-> TELEFONE (SEM ESPAÇOS E DDD): ");
                String telefone = Input.next();

                System.out.println("\n-> ENDEREÇO: ");
                String address = TreatAddress(" ");
                
                System.out.println("\n-> DATA DE NASCIMENTO: ");
                String birthday = Input.nextLine();

                int id = IDGenerator();        
                System.out.println("\nSeu número de matrícula é: " + id);

                System.out.println("\n-> SENHA PARA LOGIN: ");
                String password = Input.next();

                System.out.println("\nCadastro gerado com sucesso!");

                List<String> data = Arrays.asList(name, email, telefone, address, birthday, password);
                People.put(id, data);
                Login();
            }
            else 
            {
                System.out.println("Esse e-mail já possui um cadastro no sistema. Tente novamente.");
                Log();
            }
    }

    public String TreatAddress(String field)
    {
        while (field.isEmpty() || field.isBlank() || field == null) 
        {

            field = Input.nextLine();
        }
        return field;
    }

    public void Login()
    {
        System.out.println("\n----------------------- LOGIN -----------------------");
        System.out.print("-> NÚMERO DE MATRÍCULA: ");
        int id = Input.nextInt();
        if (CheckKey(id) == false)
        {
            System.out.println("\nMatrícula não identificada. Pressione o que deseja fazer: ");
            System.out.println("\n[1] QUERO ME CADASTRAR");
            System.out.println("[2] QUERO TENTAR O LOGIN NOVAMENTE\n");
            int choice = Input.nextInt();
            switch (choice) 
            {
                case 1: 
                    Cadastro(); 
                    break;

                case 2:
                    Login(); 
                    break;

                default:
                    System.out.print("\nOpção inválida. Tente novamente.");
                    Login();
                    break;
            }
        }
        System.out.print("-> SENHA: ");
        String password = Input.next();
        if (CheckKeyAndValue(id, password) == true)         
            CallBooks();
        else
        {
            System.out.print("Senha incorreta. Tente novamente.");
            Login();
        }
    }
    
    public void CallBooks() 
    {
        Program.Options(People);
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
        if (People != null) 
        {
            for (Map.Entry<Integer, List<String>> people : People.entrySet())
            {
                List<String> list = people.getValue();
                int integer = people.getKey();
                if (integer == id && list.contains(password))
                    return true;
            }
        }
        return false;
    }

    public boolean CheckKey(int object)
    {
        if (People != null)
        {
            for (Map.Entry<Integer, List<String>> people : People.entrySet())
            {
                if (people.getKey() == object)
                return true;
            }
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
