import java.util.HashSet;
import java.util.Set;

public class Exemplo2 {
    public static void main(String[] args) 
    {
        Set<String> palavras = new HashSet<>();
        palavras.add("Botafogo");
        palavras.add("Flamengo");
        palavras.add("Fluminense");
        palavras.add("Vasco");
        palavras.add("Flamengo");
        System.out.println(palavras.size()); 
        for (String palavra : palavras)
            System.out.println(palavra);
    }
}