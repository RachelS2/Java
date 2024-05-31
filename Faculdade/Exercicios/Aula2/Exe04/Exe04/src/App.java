import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Escreva um número inteiro: ");
        int num = input.nextInt();
        String[] unidades = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez"};
        String[] dezQuinze = {"onze", "doze", "treze", "catorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] dezenas = {"vinte e", "trinta e", "quarenta e", "cinquenta e", "sessenta e", "setenta e", "oitenta e", "noventa e"};

        if (num >= 0 & num < 99) {
            if (num < 11)
                System.out.print(unidades[num]);

            else if (11 <= num & num < 20)
                System.out.print(dezQuinze[num - 11]);

            else {
                for (int cont = 0; cont < 9; cont ++)
                {
                    for (int dezena = 20; dezena != 90; dezena = dezena + 10)
                    {
                        int unid = num - dezena;
                        if (dezena + unid == num)
                        {
                            if (unid < 10)
                                System.out.print(dezenas[cont] + unidades[unid]);
                        }
                    }
                }
                
            }
            }
        
        input.close();
    }
}
