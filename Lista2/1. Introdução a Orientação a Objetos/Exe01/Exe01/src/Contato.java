import java.util.*;

public class Contato
{
    Map<String, List<String>> Contatos;
    Scanner input = new Scanner(System.in);
    static Contato Contato;

    public void MapInitializer(Contato contato)
    {
        Contato = contato;
        Contatos = new HashMap<>();
    }

    public static void Options()
    {
        Agenda.Options(Contato);
    }

    public void Inserct()
    {
        System.out.println("\n[1] INSERINDO NOVO CONTATO");

        System.out.print("NOME: ");
        String name = input.nextLine();
        
        if (Contatos.containsKey(name))
        {
            System.out.println("Esse contato já existe. Deseja atualizá-lo? (SIM/NAO)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("SIM"))
            {
                Update();
            }
            else
                Options();
        }

        else
        {
            System.out.print("TELEFONE: ");
            String tel = input.nextLine();

            System.out.print("ENDEREÇO: ");
            String address = input.nextLine();

            List<String> contato = Arrays.asList(tel, address);

            Contatos.put(name, contato);
            Options();
        }
    }

    public void Update()
    {
        System.out.println("\n[2] ATUALIZANDO UM CONTATO");

        System.out.print("NOME: ");
        String name = input.nextLine();
                
        if (!Contatos.containsKey(name))
        {
            System.out.println("Esse contato não existe. Deseja inseri-lo na agenda? (S/N)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("S"))
                Inserct();
            else
                Options();
        }

        else
        {
            List<String> dados = Contatos.get(name);
            System.out.println("\nINSIRA O CAMPO QUE DESEJA ATUALIZAR: ");
            System.out.println("[A] NOME");
            System.out.println("[B] TELEFONE");
            System.out.println("[C] ENDEREÇO");

            String option = input.nextLine();
            if (option.equalsIgnoreCase("A"))
            {
                System.out.print("\nANTIGO NOME: " + name);
                System.out.print("\nNOVO NOME: ");
                String newName = input.nextLine();
                Contatos.remove(name);
                Contatos.put(newName, dados);
            }

            else if (option.equalsIgnoreCase("B"))
            {
                System.out.print("\nANTIGO TELEFONE: " + dados.get(0));
                System.out.print("\nNOVO TELEFONE: ");
                String newPhone = input.nextLine();
                dados.set(0, newPhone);
            }

            else if (option.equalsIgnoreCase("C"))
            {
                System.out.print("\nANTIGO ENDEREÇO: " + dados.get(1));
                System.out.print("\nNOVO ENDEREÇO: ");
                String newAddress = input.nextLine();
                dados.set(1, newAddress);
            }
            Contatos.put(name, dados);
            Options();
        }
    }

    public void Show()
    {
        System.out.println("\n[3] EXIBINDO UM CONTATO");
        System.out.print("NOME: ");
        String name = input.nextLine();
        if (Contatos.containsKey(name))
        {
            List<String> dados = Contatos.get(name);
            System.out.println("TELEFONE: " + dados.get(0));
            System.out.println("ENDEREÇO: " + dados.get(1));
        }
        else System.out.println("\n Esse contato não existe.");
        Options();
    }

    public void ShowAll()
    {
        System.out.println("\n[4] EXIBINDO TODOS OS CONTATOS");
        if (Contatos.size() > 0)
        {
            for (Map.Entry<String, List<String>> entrada : Contatos.entrySet()) 
            {
                List<String> dados = entrada.getValue();
                System.out.println("NOME: " + entrada.getKey());
                System.out.println("TELEFONE: " + dados.get(0));
                System.out.println("ENDEREÇO: " + dados.get(1));
                System.out.print("\n");
            }
        }
        else System.out.println("Agenda vazia.");
        
        Options();
    }
    
    public void Delete()
    {
        System.out.println("\n[5] APAGANDO UM CONTATO");
        System.out.print("NOME: ");
        String name = input.nextLine();
        if (Contatos.containsKey(name))
            Contatos.remove(name);
        
        else 
            System.out.println("\nEsse contato não existe.");
        
        Options();
    }

    public void Finish()
    {
        System.out.println("\n[6] ENCERRANDO O PROGRAMA");
        System.out.print("Fechando a agenda...");
    }
}
