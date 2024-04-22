import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Informe o tempo (em segundos) transcorrido entre ver o raio e ouvir o trovão: ");
        int seconds = teclado.nextInt();
        int soundSpeed = 340;

        double distance = (soundSpeed * seconds) / 1000; //transformando de metro para quilômetro

        System.out.print("A distância, em quilômetros, é de " + distance + " .");
        teclado.close();
    }
}
