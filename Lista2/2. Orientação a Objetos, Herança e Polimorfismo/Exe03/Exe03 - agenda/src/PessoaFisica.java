import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaFisica extends Pessoa
{

    public void InserirPessoa()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("-> NOME: ");
        String nome = input.nextLine();
        System.out.println("-> ENDEREÇO: ");
        String endereco = input.nextLine();
        System.out.println("-> CPF: ");
        String cpf = input.nextLine();
        List<String> pessoa = new ArrayList<>(List.of(nome, endereco));
        Agenda.put(cpf, pessoa);
        Opcoes(input);
    }

    public void Opcoes(Scanner input)
    {
        System.out.println("\nVocê deseja...");
        System.out.println("\n[1] Inserir mais uma pessoa na agenda");
        System.out.println("\n[2] Voltar ao menu principal");
        System.out.println("\n[3] Encerrar o programa");

        int opcao = input.nextInt();
        if (opcao == 1)
            InserirPessoa();
        else if (opcao == 2)
            Program.MenuPrincipal();
        else if (opcao == 3)
            System.out.println("\nEncerrando o programa...");
        else {
            System.out.println("\nOpção inválida. Tente novamente.");
            Opcoes(input);
        }
        input.close();
    }

    public void ChecarAgenda(String cpf)
    {
        for(Map.Entry<String, List<String>> contato : Agenda.entrySet())
        {
            if (contato.getKey() == cpf)
            {
                List<String> dados = contato.getValue();
                System.out.println("CPF: " + cpf + "\n Nome: " + dados.get(0) + "\n Endereço: " + dados.get(1));
            }
        }
    }
}
