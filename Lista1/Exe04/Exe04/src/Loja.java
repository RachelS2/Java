import java.util.Scanner;
public class Loja {
    public static void main(String[] args) throws Exception {
        boolean cond = true;
        Scanner input = new Scanner(System.in);
        while (cond == true) 
        {

            System.out.print("Produto: ");
            String prod = input.nextLine();

            System.out.print("Preço: ");
            double preco = input.nextDouble();

            System.out.print("Quantidade (em unidades): ");
            int unid = input.nextInt();

            double total = unid * preco;

            if (unid >= 11 & unid <= 20)
                total *= 0.9;
            
            else if (unid >= 21 & unid <= 50)
                total *= 0.8;
            
            else if (unid > 50)
                total *= 0.25;
            
            System.out.println("Produto: " + prod + " Quantidade: " + unid + " Preco: R$ " + preco + " Preco total: R$ " + total);
            System.out.print("Deseja continuar (S/N)? ");
            String r = input.next();
            if (r.toUpperCase().equals("N")) 
                cond = false;
        }
        input.close();
    }
}
