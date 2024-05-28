import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Pessoa 
{
    static Map<Integer, List<List<String>>> Agenda;
    
    public static void IniciaAgenda()
    {
        Agenda = new HashMap<>();
    }

    public static List<String> ChecarAgenda(String cnpj)
    {
        if (Agenda.size() > 0) 
        {
            for(Map.Entry<Integer, List<List<String>>> todoMundo : Agenda.entrySet())
            {
                List<List<String>> pessoaFouJ = todoMundo.getValue();
                for(int i = 0; i < pessoaFouJ.size(); i++)
                {
                    List<String> dados = pessoaFouJ.get(i);
                    if (dados.get(0).equals(cnpj))
                        return dados;   
                }
            }
            System.out.println("CNPJ não encontrado. Tente novamente.");
        }
        System.out.println("Agenda não inicializada. Tente novamente.");
        return null;
    }

    public static void ImprimirPessoa(int tipoPessoa)
    {
        List<List<String>> pessoa = Agenda.get(tipoPessoa); 
        
        for(int i = 0; i < pessoa.size(); i++)
        {
            List<String> dados = pessoa.get(i);
            if (tipoPessoa == 1)
                PessoaFisica.ImprimirCPF(dados);
                
            else if (tipoPessoa == 2)
                PessoaJuridica.ImprimirCNPJ(dados);
        }
    }

     public static void ImprimirAgenda()
    {
        if (Agenda.size() > 0)
        {
            System.out.println("\n~~~~~~~~~~ INFORMAÇÕES DOS CONTATOS ~~~~~~~~~~");
            for(int pessoa = 1; pessoa < 3; pessoa++)
            {
                List<List<String>> dados = Agenda.get(pessoa); 
                if (dados != null && dados.size() > 0)
                    ImprimirPessoa(pessoa);
            }
        }
        else 
        {
            System.out.print("\nA agenda ainda não foi inicializada. Tente novamente.\n"); 
            Program.MenuPrincipal();    
        }
    }
}

