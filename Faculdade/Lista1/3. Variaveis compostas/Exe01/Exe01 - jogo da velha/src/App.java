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
        
        for (int linha = 1; linha < 4; linha++) 
        {
            for (int coluna = 1; coluna < 4; coluna++) 
            {
                List<Integer> posicoesDesocupadas = Arrays.asList(linha, coluna);
                PosicoesDesocupadas.add(posicoesDesocupadas);
            }
        }
    }

    public static void IniciaJogo()
    {
        System.out.println("\nUsuário: X\nRobô: O\n");
        for (int linha = 0; linha < 3; linha++) 
            System.out.println(Tabuleiro.get(linha).toString());
    }

    public static void JogadaUsuario(int linha, int coluna)
    {
        Scanner input = new Scanner(System.in);
        String velhaColuna = DeuVelhaColuna();
        String velhaLinha = DeuVelhaLinha();
        String velhaDiag = DeuVelhaDiagonal();
        String velhaDiag2 = DeuVelhaDiagonal2();

        if (velhaColuna != null | velhaLinha != null | velhaDiag != null | velhaDiag2 != null)
            MensagemUsuario(velhaColuna, velhaLinha, velhaDiag, velhaDiag2);
            
        else
        {
            if (TabuleiroCheio() == false)
            {
                System.out.print("\n~~~~~~~ JOGADA DO USUÁRIO ~~~~~~~~\n");
                System.out.print("\nInsira a linha que deseja jogar (1 à 3): ");
                int line = input.nextInt();
                if (line > 3 || line < 1)
                {
                    System.out.println("A linha deve ser um valor de 1 à 3.");
                    JogadaUsuario(linha, coluna);
                }
                System.out.print("\nInsira a coluna que deseja jogar (1 à 3): ");
                int column = input.nextInt();
                if (column > 3 || column < 1)
                {
                    System.out.println("A coluna deve ser um valor de 1 à 3."); 
                    JogadaUsuario(linha, coluna);
                }
        
                List<Integer> posicoes = Arrays.asList(line, column);
                boolean posicaoOcupada = PosicaoOcupada(posicoes);
        
                if (posicaoOcupada == false){
                    System.out.print("\nMarcando X na posição: (" + line + ", " + column + "):\n" );
                    MudaTabuleiro(line, column, 'X');
                    if ((TabuleiroCheio() == false) & DeuVelhaColuna() == null & DeuVelhaLinha() == null & DeuVelhaDiagonal() == null & DeuVelhaDiagonal2() == null)
                    {
                        System.out.print("\n~~~~~~~ JOGADA DO ROBÔ ~~~~~~~~\n");
                        JogadaRobo();
                    }
                    else 
                        MensagemUsuario(DeuVelhaColuna(), DeuVelhaLinha(), DeuVelhaDiagonal(), DeuVelhaDiagonal2());
                }
                else
                {
                    System.out.println("\nEssa posição já está ocupada. Tente novamente.");
                    JogadaUsuario(linha, coluna);
                }
            }
            else if (TabuleiroCheio())
                System.out.println("\nDEU VELHA!");
        }

        input.close();
    }

     public static void MudaTabuleiro(int line, int column, char figura){
        System.out.print("\n");
        for (int linha = 1; linha < 4; linha++) 
        {
            String tabuleiro =  Tabuleiro.get(linha-1);
            StringBuilder sb = new StringBuilder(tabuleiro);
            if (linha != line)
                System.out.println(tabuleiro);
            for (int coluna = 1; coluna < 4; coluna++) 
            {
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
        if (TabuleiroCheio() == false)
        {
            String velhaColuna = DeuVelhaColuna();
            String velhaLinha = DeuVelhaLinha();
            String velhaDiag = DeuVelhaDiagonal();
            String velhaDiag2 = DeuVelhaDiagonal2();
            if (velhaColuna == null && velhaLinha == null && velhaDiag == null && velhaDiag2 == null) 
            {
                Random random = new Random();
                int linha = random.nextInt(1, 4);
                int coluna = random.nextInt(1, 4);
                List<Integer> jogadas = Arrays.asList(linha, coluna);
                boolean posicaoOcupada = PosicaoOcupada(jogadas);
                if (posicaoOcupada == true)
                    JogadaRobo();
                if (posicaoOcupada == false)
                {
                    MudaTabuleiro(linha, coluna, 'O');
                    if (DeuVelhaColuna() == null & DeuVelhaLinha() == null & DeuVelhaDiagonal() == null &        DeuVelhaDiagonal2() == null)
                        JogadaUsuario(linha, coluna);
                    else 
                        MensagemUsuario(DeuVelhaColuna(), DeuVelhaLinha(), DeuVelhaDiagonal(), DeuVelhaDiagonal2());
                }
            }
            else
                MensagemUsuario(velhaColuna, velhaLinha, velhaDiag, velhaDiag2);
        }
        else 
            System.out.println("\nDEU VELHA!");   
    }

    public static void MensagemUsuario(String velhaColuna, String velhaLinha, String velhaDiagonal, String velhaDiagonal2)
    {
        if (velhaColuna != null)
            PrintMensagem(velhaColuna);
        
        if (velhaLinha != null)
            PrintMensagem(velhaLinha);
        
        if (velhaDiagonal != null)
            PrintMensagem(velhaDiagonal); 
            
        if (velhaDiagonal2 != null)
            PrintMensagem(velhaDiagonal2);  
    }

    public static void PrintMensagem(String resultado)
    {
        if (resultado.equals("X"))
            System.out.println("\nVOCÊ VENCEU!");

        else if (resultado.equals("O"))
            System.out.println("\nO ROBÔ VENCEU!");
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
        if (coluna == 1)
        {
            index = 6;
            sb.setCharAt(index, figura);
        }
            
        else if (coluna == 2)
        {
            index = 16;
            sb.setCharAt(index, figura);
        }
        
        else if (coluna == 3)
        {
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

    public static String DeuVelhaDiagonal()
    {
        List<Character> figuraX = new ArrayList<>();
        List<Character> figuraO = new ArrayList<>();
        int posicao = 6;
        for (int linha = 0; linha < 3; linha++)
        {
            String linhaTabuleiro = Tabuleiro.get(linha);
            char figura = linhaTabuleiro.charAt(posicao);
            if (figura == 'X')
                figuraX.add(figura);

            else if (figura == 'O')
                figuraO.add(figura);

            posicao += 10;
        }
        if (figuraX.size() == 3)
                return "X";            
    
        if (figuraO.size() == 3)
                return "O";
        
        return null;
    }

    public static String DeuVelhaDiagonal2()
    {
        List<Character> figuraX = new ArrayList<>();
        List<Character> figuraO = new ArrayList<>();
        int posicao = 26;
        for (int linha = 0; linha < 3; linha++)
        {
            String linhaTabuleiro = Tabuleiro.get(linha);
            char figura = linhaTabuleiro.charAt(posicao);
            if (figura == 'X')
                figuraX.add(figura);

            else if (figura == 'O')
                figuraO.add(figura);

            posicao -= 10;
        }
        if (figuraX.size() == 3)
                return "X";            
    
        if (figuraO.size() == 3)
                return "O";
        return null;
    }
}
