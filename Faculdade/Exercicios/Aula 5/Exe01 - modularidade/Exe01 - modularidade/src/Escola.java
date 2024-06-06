import java.util.*;

public class Escola {
    public static void main(String[] args) throws Exception {
        
        Professor profLuiz = new Professor("Luiz", 1);
        Professor profChris = new Professor("Christiano", 2);
        Professor profElaine = new Professor("Elaine", 3);

        List<Disciplina> disciplinas = Arrays.asList
                                    (new Disciplina("Programação Orientada a Objetos", profLuiz, 10), 
                                    new Disciplina("Ética e Informação", profChris, 9), 
                                    new Disciplina("Inteligência de Negócios", profElaine, 8));
        
        List<Aluno> notaAluna = Arrays.asList
                                (new Aluno("Rachel", disciplinas.get(0)), 
                                new Aluno("Rachel", disciplinas.get(1)), 
                                new Aluno("Rachel", disciplinas.get(2)));

        ExibeHistorico(notaAluna);
        ExibeCR(notaAluna);
    }

    public static void ExibeHistorico(List<Aluno> notaAluno)
    {
        System.out.println("~~~~~~~~~~~ HISTÓRICO ~~~~~~~~~~~");
        System.out.println("Estudante: " + notaAluno.get(0).pegaNome() + "\n");
        for (Aluno aluno : notaAluno)
            aluno.ExibeHistorico(aluno);
    }

    public static void ExibeCR(List<Aluno> notaAluno)
    {
        Aluno aluno = notaAluno.get(0);
        aluno.ExibeCR(notaAluno);
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
    Double Nota;
    Disciplina(String nomeDisciplina, Professor professor, double nota){
        NomeDisciplina = nomeDisciplina;
        Professor = professor;
        Nota = nota;
    }  
    public double pegaNota(){
        return Nota;
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
        System.out.println("Nota: " + aluno.Disciplina.Nota);
        System.out.println(" ");
    }

    public void ExibeCR(List<Aluno> notaAluno){
        int soma = 0;
        System.out.println("~~~~~~~~~~~ COEF. DE REND. ~~~~~~~~~~~");
        System.out.println("Estudante: " + notaAluno.get(0).Nome);
        for (int i = 0; i < notaAluno.size(); i++){
            Aluno aluna = notaAluno.get(i);
            Disciplina disciplina = aluna.Disciplina;
            soma += disciplina.Nota; 
        }
        System.out.println("Coeficiente de Rendimento: " + soma/3 + "\n");
    }
}
