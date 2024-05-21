import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) 
    {
        Contato contato = new Contato();
        contato.MapInitializer(contato);
        Options(contato);
    }

    public static void Options(Contato contato){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSelecione uma opção: ");
        System.out.println("[1] INSERIR NOVO CONTATO");
        System.out.println("[2] ATUALIZAR UM CONTATO");
        System.out.println("[3] EXIBIR UM CONTATO");
        System.out.println("[4] EXIBIR TODOS OS CONTATOS");
        System.out.println("[5] APAGAR UM CONTATO");
        System.out.println("[6] ENCERRAR O PROGRAMA");

        int option = input.nextInt();

        switch (option)
        {
            case 1:
                contato.Inserct(); 
                break;

            case 2:
                contato.Update(); 
                break;

            case 3:
                contato.Show(); 
                break;

            case 4:
                contato.ShowAll(); 
                break;

            case 5:
                contato.Delete(); 
                break;

            case 6:
                contato.Finish(); break;
            default:
                System.out.print("Opção inválida. Reinicie o programa e tente novamente.");
        }
        input.close();
    }
}
