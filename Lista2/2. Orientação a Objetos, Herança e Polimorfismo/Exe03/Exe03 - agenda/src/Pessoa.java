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

    public static void ImprimirPessoa(int tipoPessoa)
    {
        System.out.println("\n~~~~~~~~~~ INFORMAÇÕES DOS CONTATOS ~~~~~~~~~~");
        Map<String, List<String>> pessoa = Agenda.get(tipoPessoa); 
        
        for(Map.Entry<String, List<String>> agenda : pessoa.entrySet())
            if (tipoPessoa == 1)
                PessoaFisica.ImprimirCPF(agenda.getKey(), agenda.getValue());
                
            else if (tipoPessoa == 2)
                PessoaJuridica.ImprimirCNPJ(agenda.getKey(), agenda.getValue());
             
    }

     public static void ImprimirAgenda(int tipoPessoa)
    {
        System.out.println("\n~~~~~~~~~~ INFORMAÇÕES DOS CONTATOS ~~~~~~~~~~");
        Map<String, List<String>> pessoa = Agenda.get(tipoPessoa); 
        
        for(Map.Entry<String, List<String>> agenda : pessoa.entrySet())
            if (tipoPessoa == 1)
                PessoaFisica.ImprimirCPF(agenda.getKey(), agenda.getValue());
                
            else if (tipoPessoa == 2)
                PessoaJuridica.ImprimirCNPJ(agenda.getKey(), agenda.getValue());
            
            else 
    }
}

