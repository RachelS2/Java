import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Insira um número: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String[] zero_A_49 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX"};

        if (num > 999 | num < -999) 
            System.out.print("O número deve ter até 3 dígitos. Reinicie o programa e tente novamente.");
        
        else {
            
            if (num > 0 & num < 50)
                System.out.print("O número " + num + " em numerologia romana é: " + zero_A_49[num-1]);
            
            else if (num == 50)
                System.out.print("O número 50 em numerologia romana é: L");
            
            else if (num > 50 & num < 100) 
            {
                System.out.print("O número " + num + " em numerologia romana é: L" + zero_A_49[num-51] );
            }
            
            else if (num >= 100 & num < 500) 
            {
                
            }
        }   
        
        input.close();
    }
}
