import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa 
{
    Map<String, List<String>> Agenda;
    
    public void Inicio()
    {
        Agenda = new HashMap<>();
    }

    public void InserirPessoa()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("-> NOME: ");
        String nome = input.nextLine();
        System.out.println("-> ENDEREÇO: ");
        String endereco = input.nextLine();
        System.out.println("-> ID: ");
        String id = input.nextLine();
        List<String> pessoa = new ArrayList<>(List.of(nome, endereco));
        Agenda.put(id, pessoa);
        input.close();
    }

    public void ChecarAgenda(String id)
    {
        for(Map.Entry<String, List<String>> contato : Agenda.entrySet())
        {
            if (contato.getKey() == id)
            {
                List<String> dados = contato.getValue();
                System.out.println("ID: " + id + "\n Nome: " + dados.get(0) + "\n Endereço: " + dados.get(1));
            }
        }
    }

}
