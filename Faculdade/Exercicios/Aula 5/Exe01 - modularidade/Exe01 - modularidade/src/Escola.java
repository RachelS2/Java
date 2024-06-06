import java.util.*;

public class Escola {
    public static void main(String[] args) throws Exception {
        
        Professor profLuiz = new Professor("Luiz", 1);
        Professor profChris = new Professor("Christiano", 2);
        Professor profElaine = new Professor("Elaine", 3);

        List<Disciplina> disciplinas = Arrays.asList(new Disciplina("Programação Orientada a Objetos", profLuiz), 
        new Disciplina("Ética e Informação", profChris), new Disciplina("Inteligência de Negócios", profElaine));
        
        List<Aluno> notaAluna = Arrays.asList(new Aluno("Rachel", 10, disciplinas.get(0)), 
        new Aluno("Rachel", 9, disciplinas.get(1)), new Aluno("Rachel", 8, disciplinas.get(2)));

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
    Disciplina(String nomeDisciplina, Professor professor){
        NomeDisciplina = nomeDisciplina;
        Professor = professor;
    }  

}

class Aluno {
    String Nome;
    Double Nota;
    Disciplina Disciplina;
    Aluno(String nome, double nota, Disciplina disciplina){
        Nome = nome;
        Nota = nota;
        Disciplina = disciplina;
    }

    public double pegaNota(){
        return Nota;
    }
}
