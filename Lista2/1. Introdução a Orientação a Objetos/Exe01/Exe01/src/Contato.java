import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contato
{
    Map<String, List<String>> Contatos;
    Scanner input = new Scanner(System.in);

    public void MapInitializer()
    {
        Contatos = new HashMap<>();
    }

    public void Options()
    {
        Agenda opcoes = new Agenda();
        opcoes.Options();
    }

    public void Inserct()
    {
        System.out.println("\n[1] INSERINDO NOVO CONTATO");

        System.out.print("NOME: ");
        String name = input.nextLine();
        
        if (Contatos.containsKey(name))
        {
            System.out.println("Esse contato já existe. Deseja atualizá-lo? (S/N)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("S"))
                Update();
            else
                Options();
        }

        else
        {
            System.out.print("TELEFONE: ");
            String tel = input.nextLine();

            System.out.print("ENDEREÇO: ");
            String address = input.nextLine();

            ArrayList<String> contato = new ArrayList();
            contato.add(tel); contato.add(address);

            Contatos.put(name, contato);
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
                dados.remove(0);
                dados.add(0, newPhone);
            }

            else if (option.equalsIgnoreCase("C"))
            {
                System.out.print("\nANTIGO ENDEREÇO: " + dados.get(1));
                System.out.print("NOVO ENDEREÇO: ");
                String newAddress = input.nextLine();
                dados.remove(1);
                dados.add(1, newAddress);
            }
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
        
    }
    
    public void Delete()
    {
        
    }

}
