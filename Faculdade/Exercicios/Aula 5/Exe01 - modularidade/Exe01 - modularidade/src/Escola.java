import java.util.*;

public class Escola {
    public static void main(String[] args) throws Exception {
        
        Professor profLuiz = new Professor("Luiz", 1);
        Professor profChris = new Professor("Christiano", 2);
        Professor profElaine = new Professor("Elaine", 3);

        List<Disciplina> disciplinas = Arrays.asList
                            (new Disciplina("Programação Orientada a Objetos", profLuiz, 10, 10), 
                            new Disciplina("Ética e Informação", profChris, 9, 8), 
                            new Disciplina("Inteligência de Negócios", profElaine, 8, 7));
        
        List<Aluno> notaAluna = Arrays.asList
                            (new Aluno("Rachel", disciplinas.get(0)), 
                            new Aluno("Rachel", disciplinas.get(1)), 
                            new Aluno("Rachel", disciplinas.get(2)));

        Menu(notaAluna);
    }

    public static void Menu(List<Aluno> notaAluno)
    {
        System.out.println("~~~~~~~~~~~ MENU ~~~~~~~~~~~");
        System.out.println("\nPara exibir histórico do aluno: \n-> Pressione a tecla 1");
        System.out.println("\nPara exibir o CR do aluno: \n-> Pressione a tecla 2");
        System.out.println("\nPara exibir a média do aluno em uma disciplina: \n-> Pressione a tecla 3");
        System.out.println("\nPara exibir a ementa da disciplina:\n-> Pressione a tecla 4");
        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
        switch (opcao) {
            case 1:
                ExibeHistorico(notaAluno);
                break;
            case 2:
                ExibeCR(notaAluno);
                break;
            case 3: 
                ImprimeMedia(notaAluno, input);
                break;
                
        }
    }

    public static void ImprimeMedia(List<Aluno> notaAluno, Scanner input){
        System.out.print("-> Nome da disciplina: ");
        String nomeDisciplina = input.next().toLowerCase().replace('é', 'e').replace('á', 'a').replace('ê', 'e').replace('ó', 'o').replace('ã', 'a').replace('ç', 'c');
        boolean verificacao = false;
        for (Aluno aluno : notaAluno)
        {
            String disciplina = aluno.Disciplina.NomeDisciplina;
            if (disciplina.equalsIgnoreCase(nomeDisciplina))
            {
                System.out.println("-> Média do aluno: " + aluno.Disciplina.RetornaMedia());
                verificacao = true;
            }
        }
        if (verificacao == false)
        {
            System.out.println("-> Disciplina inválida! Tente novamente.");
            ImprimeMedia(notaAluno, input);
        }
        Menu(notaAluno);
    }

    public static void ExibeHistorico(List<Aluno> notaAluno)
    {
        System.out.println("~~~~~~~~~~~ HISTÓRICO ~~~~~~~~~~~");
        System.out.println("Estudante: " + notaAluno.get(0).pegaNome() + "\n");
        for (Aluno aluno : notaAluno)
            aluno.ExibeHistorico(aluno);
        Menu(notaAluno);
    }

    public static void ExibeCR(List<Aluno> notaAluno)
    {
        Aluno aluno = notaAluno.get(0);
        aluno.ExibeCR(notaAluno);
        Menu(notaAluno);
    }
}

class Professor {
    String Nome;
    Integer Id;
    Professor(String nome, int id){
        Nome = nome;
        Id = id;
    }
}

class Disciplina 
{
    String NomeDisciplina; 
    Professor Professor;
    Double Nota1;
    Double Nota2;
    Disciplina(String nomeDisciplina, Professor professor, double nota1, double nota2){
        NomeDisciplina = nomeDisciplina;
        Professor = professor;
        Nota1 = nota1;
        Nota2 = nota2;
    }  
    public double RetornaMedia(){
        return (Nota1 + Nota2) / 2;
    }

}

class Aluno {
    String Nome;
    Disciplina Disciplina;
    Aluno(String nome, Disciplina disciplina){
        Nome = nome;
        Disciplina = disciplina;
    }

    public String pegaNome(){
        return Nome;
    }

    public void ExibeHistorico(Aluno aluno){
        
        System.out.println("Disciplina: " + aluno.Disciplina.NomeDisciplina);
        System.out.println("Média: " + aluno.Disciplina.RetornaMedia());
        System.out.println(" ");
    }

    public void ExibeCR(List<Aluno> notaAluno){
        int soma = 0;
        System.out.println("~~~~~~~~~~~ COEF. DE REND. ~~~~~~~~~~~");
        System.out.println("Estudante: " + notaAluno.get(0).Nome);
        for (int i = 0; i < notaAluno.size(); i++){
            Aluno aluna = notaAluno.get(i);
            Disciplina disciplina = aluna.Disciplina;
            soma += disciplina.RetornaMedia(); 
        }
        System.out.println("Coeficiente de Rendimento: " + soma/3 + "\n");
    }
}
