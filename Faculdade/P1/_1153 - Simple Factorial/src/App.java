import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int num1 = input.nextInt();
        if (num1 < 13 & num1 > 0) 
        {
            int fat = 1;
            while (num1 > 0) 
            {
                fat  = fat * num1;
                num1 = num1 - 1;
            }
            System.out.println(fat);
            input.close();
        }
    }
}
