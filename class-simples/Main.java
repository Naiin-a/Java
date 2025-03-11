import java.time.LocalDate;

public class Main{
    public static void main(String[] args){
        aluno aluno = new aluno("Rafael", LocalDate.of(2005,11,9));

        System.out.println("nome: " + aluno.getNome());
        System.out.println("idade: " + aluno.calculaIdade() + " anos");
    }
}
