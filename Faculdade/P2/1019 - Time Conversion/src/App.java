import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int seconds = scanner.nextInt();
        
        scanner.close();
        
        Hora hora = new Hora(seconds);
        int hours = hora.getHoras();

        int remainingSeconds = hora.getResto();

        int minutes = remainingSeconds / 60;
        int secondsOutput = remainingSeconds % 60;
        
        System.out.println(hours + ":" + minutes+ ":" + secondsOutput);    }
}

 
class Hora
{
    Integer Horas;
    Integer SegundosRestantes;
    Hora(int segundos)
    {
        Horas = segundos / 3600;
        SegundosRestantes = segundos % 3600;
    }
     
    int getHoras()
    {
        return Horas;
    }

    int getResto()
    {
        return SegundosRestantes;
    }
}