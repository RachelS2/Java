import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert a number: ");
        int number = input.nextInt();
        if (number == 0)
            System.out.print("The number zero doesn't have a square root.");
        
        else {
            int retriever = 1;
            while (retriever * retriever < number) {
                retriever = retriever + 1;
                System.out.print("\nRetriever " + retriever);
            }
            System.out.print("\nSquare root: " + retriever);

        }

        input.close();
    }
}
