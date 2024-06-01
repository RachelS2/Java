import java.util.*;

public class App {

    static List<String> Tabuleiro;
    static List<List<Integer>> PosicoesDesocupadas;
    public static void main(String[] args) throws Exception {
        IniciaTabuleiro();
        PosicoesDesocupadas = new ArrayList<List<Integer>>();
        PosicoesTabuleiro();
        IniciaJogo();
        JogadaUsuario(0, 0);
    }

    public static void IniciaTabuleiro(){
        Tabuleiro = Arrays.asList("__________|__________|__________", 
        "__________|__________|__________", "__________|__________|__________");

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
        System.out.println("\nUsuário: X\nRobô: O\n");
        for (int linha = 0; linha < 3; linha++) {
            System.out.println(Tabuleiro.get(linha).toString());
        }
    }

    public static void JogadaUsuario(int linha, int coluna)
    {
        Scanner input = new Scanner(System.in);
        String velhaColuna = DeuVelhaColuna();
        String velhaLinha = DeuVelhaLinha();

        if (velhaColuna != null && velhaLinha != null)
            MensagemUsuario(velhaColuna, velhaLinha);
            
        else
        {
            if (TabuleiroCheio() == false)
            {
                System.out.print("\n~~~~~~~ JOGADA DO USUÁRIO ~~~~~~~~\n ");
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
                    MudaTabuleiro(line, column, 'X');
                    System.out.print("\n~~~~~~~ JOGADA DO ROBÔ ~~~~~~~~\n ");
                    JogadaRobo();
                }
                else
                {
                    System.out.println("\nEssa posição já está ocupada. Tente novamente.");
                    JogadaUsuario(linha, coluna);
                }
            }
            else if (TabuleiroCheio())
                System.out.println("\nTabuleiro cheio. Jogo encerrado.");
        }

        input.close();
    }

     public static void MudaTabuleiro(int line, int column, char figura){
        System.out.print("\n");
        for (int linha = 1; linha < 4; linha++) {
            String tabuleiro =  Tabuleiro.get(linha-1);
            StringBuilder sb = new StringBuilder(tabuleiro);
            if (linha != line)
                System.out.println(tabuleiro);
            for (int coluna = 1; coluna < 4; coluna++) {
                if (linha == line && coluna == column) 
                {
                    Espacamento(sb, coluna, linha, figura);
                    System.out.println(Tabuleiro.get(linha-1).toString());
                }
            }
        }
    }

    public static void JogadaRobo()
    { 
        String velhaColuna = DeuVelhaColuna();
        String velhaLinha = DeuVelhaLinha();
        if (velhaColuna == null && velhaLinha == null) 
        {
            if (TabuleiroCheio() == false)
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
                    MudaTabuleiro(linha, coluna, 'O');
                    JogadaUsuario(linha, coluna);
                }
            }
            else 
                System.out.println("Tabuleiro cheio. Jogo encerrado.");   
        }
        else
            MensagemUsuario(velhaColuna, velhaLinha);
    }

    public static void MensagemUsuario(String velhaColuna, String velhaLinha)
    {
        if (velhaColuna != null)
        {
            if (velhaColuna.equals("X"))
                System.out.println("\nVOCÊ VENCEU!");

            else if (velhaColuna.equals("O"))
                System.out.println("\nO ROBÔ VENCEU!");
        }
        if (velhaLinha != null)
        {
            if (velhaLinha.equals("X"))
            System.out.println("\nVOCÊ VENCEU!");

            else if (velhaLinha.equals("O"))
            System.out.println("\nO ROBÔ VENCEU!");
        }
    }

    public static boolean PosicaoOcupada(List<Integer> posicoes)
    {
        for (int lista = 0; lista < PosicoesDesocupadas.size(); lista++)
        {
            List<Integer> posicoesDesocupadas = PosicoesDesocupadas.get(lista);
            if (posicoesDesocupadas.equals(posicoes))
            {
                PosicoesDesocupadas.remove(posicoes);
                return false;
            }                
        }
        return true;
    }

    public static boolean TabuleiroCheio()
    {
        if (Tabuleiro.size() == 0)
            return true;
        return false;
    }

    public static void Espacamento(StringBuilder sb, int coluna, int linha, char figura)
    {
        int index = 0;
        if (coluna == 1){
            index = 6;
            sb.setCharAt(index, figura);
        }
            
        else if (coluna == 2){
            index = 16;
            sb.setCharAt(index, figura);
        }
        
        else if (coluna == 3){
            index = 26;
            sb.setCharAt(index, figura);
        }
            
        Tabuleiro.set(linha-1, sb.toString());
    }

    public static String DeuVelhaLinha() //verifica se deu velha na horizontal (em alguma linha)
    {
        List<Character> figuraX = new ArrayList<>();
        List<Character> figuraO = new ArrayList<>();
        for (int linha = 0; linha < Tabuleiro.size(); linha++){
            String linhaTabuleiro = Tabuleiro.get(linha);
            for (int caracter = 6; caracter < 27; caracter += 10)
            {
                char figura = linhaTabuleiro.charAt(caracter);
                if (figura == 'X')
                    figuraX.add(figura);

                else if (figura == 'O')
                    figuraO.add(figura);
                
                if (figuraX.size() == 3)
                    return "X";            
                
                else if (figuraO.size() == 3)
                    return "O";
            }
            figuraO.clear(); figuraX.clear();
        }
        return null;
    }

    public static String DeuVelhaColuna() //verifica se deu velha na vertical (em alguma coluna)
    {
        List<Character> figuraX = new ArrayList<>();
        List<Character> figuraO = new ArrayList<>();
        for (int posicao = 6; posicao < 26; posicao += 10)
        {
            for (int coluna = 0; coluna < 3; coluna++)
            {
                String linhaTabuleiro = Tabuleiro.get(coluna);
                char figura = linhaTabuleiro.charAt(posicao);
                if (figura == 'X')
                    figuraX.add(figura);

                else if (figura == 'O')
                    figuraO.add(figura);
            }
            if (figuraX.size() == 3)
                return "X";            
    
            if (figuraO.size() == 3)
                return "O";

            figuraX.clear(); figuraO.clear();
        }
        return null;
    }
}
