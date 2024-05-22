import java.util.Scanner;
public class Pessoa {
    static Scanner Input;
    public static void main(String[] args) throws Exception 
    {
        Input = new Scanner(System.in);
        
    }

    public void DataContainer()
    {
        System.out.println("Nome: ");
        String pai = Input.nextLine();
        System.out.println("Idade: ");
        int idade = Input.nextInt();
    }
}
