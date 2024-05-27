import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Pessoa 
{
    static Map<Integer, Map<String, List<String>>> Agenda;
    
    public static void Inicio()
    {
        Agenda = new HashMap<>();
    }

    public static void InserirPessoa()
    {
    }

    public static List<String> ChecarAgenda(String cnpj)
    {
        for(Map.Entry<Integer, Map<String, List<String>>> pessoa : Agenda.entrySet())
        {
            Map<String, List<String>> contato = pessoa.getValue();
            for(Map.Entry<String, List<String>> agenda : contato.entrySet())
                if (agenda.getKey().equals(cnpj))
                    return agenda.getValue();   
        }
        return null;
    }

    public static void ImprimirAgenda()
    {
        System.out.println("\n~~~~~~~~~~ INFORMAÇÕES DOS CONTATOS ~~~~~~~~~~");
        for(Map.Entry<Integer, Map<String, List<String>>> pessoa : Agenda.entrySet())
        {
            int tipoDePessoa = pessoa.getKey();
            Map<String, List<String>> contato = pessoa.getValue();
            for(Map.Entry<String, List<String>> agenda : contato.entrySet())
                if (tipoDePessoa == 1)
                    PessoaFisica.ImprimirCPF(agenda.getKey(), agenda.getValue());
                
                else
                    PessoaJuridica.ImprimirCNPJ(agenda.getKey(), agenda.getValue());
        }
    }
}

