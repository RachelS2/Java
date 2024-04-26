import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        String[][] alunos_medias = new String[15][2];

        int linha = 0;

        for(int turma = 0; turma < 3; turma++) 
        {
            System.out.print("\n INSERINDO DADOS DA TURMA " + (turma+1));
            for (int aluno = 0; aluno < 5; aluno++) 
            {
                System.out.print("\n INSERINDO DADOS DO(A) ALUNO(A) " + (aluno+1) + "\n");
                System.out.print("\n-> Nome do(a) estudante: ");
                String nome = input.next();
                alunos_medias[linha][0] = nome;
                float soma = 0;
                for (int nota = 0; nota < 3; nota++) 
                {
                    System.out.print("-> Insira a " + (nota+1) + "ª nota de " + nome + ": ");
                    float n = input.nextFloat();
                    soma += n;
                }
                Float media = soma/3;
                alunos_medias[linha][1] = String.valueOf(media);
                linha++;
            }
        }

        System.out.print("\n Insira o nome de um(a) aluno(a) para ver sua média: ");
        String nome = input.next();

        for (int line = 0; line < 15; line ++) 
        {
            if (alunos_medias[line][0] != null && alunos_medias[line][0].equals(nome)) 
                System.out.println(alunos_medias[line][1]);
        }

        System.out.print("\n Insira uma nota e veja quais alunos têm a média acima dela: ");
        float media = input.nextFloat();

        for (int line = 0; line < 15; line ++) 
        {
            if (alunos_medias[line][1] != null) 
            {
                Float nota = Float.valueOf(alunos_medias[line][1]);
                if (nota > media)
                    System.out.println("\n" + alunos_medias[line][0]);
            }
        }

        input.close();
    }
}
