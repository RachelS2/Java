import java.util.*;

public class App {
    static StringBuilder Tabuleiro ;
    // static List<List<Integer>> PosicoesOcupadas;
    static List<List<Integer>> PosicoesDesocupadas;
    public static void main(String[] args) throws Exception {
        IniciaTabuleiro();
        // PosicoesOcupadas = new ArrayList<List<Integer>>();
        PosicoesDesocupadas = new ArrayList<List<Integer>>();
        PosicoesTabuleiro();
        IniciaJogo();
        JogadaUsuario(0, 0);
    }

    public static void IniciaTabuleiro(){
        String tabuleiro =  "__________|__________|__________\n";
        Tabuleiro = new StringBuilder(tabuleiro);
    }

    public static void PosicoesTabuleiro(){
        
        for (int linha = 1; linha < 4; linha++) {
            for (int coluna = 1; coluna < 4; coluna++) {
                List<Integer> posicoesDesocupadas = Arrays.asList(linha, coluna);
                PosicoesDesocupadas.add(posicoesDesocupadas);
            }
        }
    }

    public static void IniciaJogo(){
        System.out.println("\nUsuário: X\nComputador: O\n");
        for (int linha = 0; linha < 3; linha++) {
            System.out.print(" __________|___________|_________\n");
        }
    }

    public static void JogadaUsuario(int linha, int coluna)
    {
        System.out.print("\n~~~~~~~ JOGADA DO USUÁRIO ~~~~~~~~\n ");
        Scanner input = new Scanner(System.in);
        System.out.print("\nInsira a linha que deseja jogar (1 à 3): ");
        int line = input.nextInt();
        if (line > 3 || line < 1)
        {
            System.out.println("A linha deve ser um valor de 1 à 3.");
            JogadaUsuario(linha, coluna);
        }
        System.out.print("Insira a coluna que deseja jogar (1 à 3): ");
        int column = input.nextInt();
        if (column > 3 || column < 1)
        {
            System.out.println("A coluna deve ser um valor de 1 à 3.");
            JogadaUsuario(linha, coluna);
        }

        List<Integer> posicoes = Arrays.asList(line, column);
        boolean posicaoOcupada = PosicaoOcupada(posicoes);

        if (posicaoOcupada == false){
            System.out.print("Marcando X na posição: (" + line + ", " + column + "):\n" );
            MudaTabuleiro(line, column);
            System.out.print("\n~~~~~~~ JOGADA DO ROBÔ ~~~~~~~~\n ");
            JogadaRobo();
        }
        else
        {
            System.out.println("Essa posição já está ocupada. Tente novamente.");
            JogadaUsuario(linha, coluna);
        }
        input.close();
    }

     public static void MudaTabuleiro(int line, int column){
        StringBuilder sb = new StringBuilder();
        System.out.print("\n");
        for (int linha = 1; linha < 4; linha++) {
            String tabuleiro =  "__________|__________|__________\n";
            sb = new StringBuilder(tabuleiro);
            if (linha != line)
                System.out.print(Tabuleiro);

            if(Tabuleiro.charAt(5) != '-' || Tabuleiro.charAt(16) != '-' || Tabuleiro.charAt(27) != '-')

            for (int coluna = 1; coluna < 4; coluna++) {
                if (linha == line && coluna == column) 
                {
                    sb.setCharAt(Espacamento(sb, coluna), 'X');
                    System.out.print(sb);
                }
            }
        }
        Tabuleiro = sb;
    }

    public static void JogadaRobo()
    { 
        Random random = new Random();
        int linha = random.nextInt(1, 4);
        int coluna = random.nextInt(1, 4);
        List<Integer> jogadas = Arrays.asList(linha, coluna);
        boolean posicaoOcupada = PosicaoOcupada(jogadas);
        if (posicaoOcupada == true)
            JogadaRobo();
        else
        {
            MudaTabuleiro(linha, coluna);
            JogadaUsuario(linha, coluna);
        }
    }

    public static boolean PosicaoOcupada(List<Integer> posicoes)
    {
        if (PosicoesDesocupadas.size() == 9)
            return false;
        
        else{
            for (int lista = 0; lista < PosicoesDesocupadas.size(); lista++)
            {
                List<Integer> posicoesDesocupadas = PosicoesDesocupadas.get(lista);
                if (posicoesDesocupadas == posicoes){
                    PosicoesDesocupadas.remove(posicoes);
                    return false;
                }                
            }
        }
        return true;
    }

    public static int Espacamento(StringBuilder sb, int coluna)
    {
        if (coluna == 1){
            return 5;
        }
        else if (coluna == 2)
            return 16;
        
        else if (coluna == 3)
            return 27;
        return 0;
    }
}
