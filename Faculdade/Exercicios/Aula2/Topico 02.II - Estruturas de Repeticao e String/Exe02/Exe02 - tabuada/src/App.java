public class App {
    public static void main(String[] args) throws Exception {
        for (int tabuadaDe = 1; tabuadaDe < 11; tabuadaDe++) {
            System.out.println("\nTabuada de: " + tabuadaDe);

            for (int i = 1; i <11; i++) {
                System.out.println(tabuadaDe + " * " + i + " = " + tabuadaDe * i);
            }
        }
    }
}
