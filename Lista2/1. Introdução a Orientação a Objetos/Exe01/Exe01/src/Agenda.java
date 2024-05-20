import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) 
    {
        Options();
    }

    public static void Options(){
        Scanner input = new Scanner(System.in);
        System.out.println("Selecione uma opção: ");
        System.out.println("[1] INSERIR NOVO CONTATO");
        System.out.println("[2] ATUALIZAR UM CONTATO");
        System.out.println("[3] EXIBIR UM CONTATO");
        System.out.println("[4] APAGAR UM CONTATO");
        System.out.println("[5] ENCERRAR O PROGRAMA");

        int option = input.nextInt();
        Contato contato = new Contato();
        contato.MapInitializer();
        switch (option)
        {
            case 1:
                contato.Inserct();
            case 2:
                contato.Update();
            case 3:
                contato.Show();
            case 4:
                contato.Delete();
        }
        input.close();
    }
}
