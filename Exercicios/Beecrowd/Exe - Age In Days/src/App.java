import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira a idade em dias: ");
        int dias = input.nextInt();
        int restoDosDias;

        if (dias % 365 == 0)
            System.out.println("Você tem " + dias/365 + " anos!");
        else 
        {
            int ano = dias/365;
            restoDosDias = dias % 365;
            if (restoDosDias >= 30) {
                int meses = restoDosDias/30;
                restoDosDias = restoDosDias - (meses * 30);
                System.out.print("Você tem " + ano + " anos, " + meses + " meses e " + restoDosDias + " dias.");
            }

        }
        input.close();
        
    }
}
