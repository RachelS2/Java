import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception 
    {
  
        Scanner input = new Scanner(System.in);

        System.out.print("Quanto será investido por mês? ");
        float investimento = input.nextFloat();

        System.out.print("Qual será a taxa de juros mensal? ");
        float taxa = input.nextFloat();   

        float montante = 0;
        
        for (int i = 0; i < 12; i ++) 
        {
            montante += investimento;
            montante *= (1 + taxa);
        }
        
        System.out.print("Após um ano, você terá R$ " + montante + " em conta.");
        input.close();
        

    }
}


