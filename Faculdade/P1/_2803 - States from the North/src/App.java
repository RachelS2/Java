import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String regiao = input.nextLine().toLowerCase();
       
            if(regiao.equalsIgnoreCase("roraima") | regiao.equalsIgnoreCase("acre") | 
                regiao.equalsIgnoreCase("amapa") | regiao.equalsIgnoreCase("amazonas") |
                regiao.equalsIgnoreCase("para") | regiao.equalsIgnoreCase("rondonia") |
                regiao.equalsIgnoreCase("tocantins"))  
                    
                    System.out.print("Regiao Norte");

            else
                System.out.print("Outra regiao");
            input.close();
    }
}
