import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Insira um número: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String[] zero_A_89 = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX"};

        if (num > 999 | num < -999) 
            System.out.print("O número deve ter até 3 dígitos. Reinicie o programa e tente novamente.");
        
        else {
            
            if (num > 0 & num < 90)
                System.out.print("O número " + num + " em numerologia romana é: " + zero_A_89[num]);
                        
            else if (num >= 90 & num < 100)
                System.out.print("O número " + num + " em numerologia romana é: XC" + zero_A_89[num-90]  );
            
            else if (num == 100) 
                System.out.print("O número 100 em numerologia romana é: C");

            else if (num > 100 & num <= 189) 
                System.out.print("O número " + num + " em numerologia romana é C" + zero_A_89[num-100] );
            
            else if (num >= 190 & num < 200) 
                System.out.print("O número " + num + " em numerologia romana é XC" + zero_A_89[num-190] );
        }   
        
        input.close();
    }
}
