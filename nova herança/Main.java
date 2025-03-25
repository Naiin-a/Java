import java.util.Date;

public class Main{
    public static void main(String[] args){
        Aluno aluno = new Aluno("rafael","200.300.400-03", new Date(),1002);
        aluno.setNome("atagha");
        System.out.println("aluno:\n"+ aluno.getNome() + "\nmatricula\n" + aluno.getMatricula() );
        Empregado empregado = new Empregado("maria","232.232.234-22",new Date(),4000);
        System.out.println("empregado\n" + empregado.getNome() + "\nsalario\n" + empregado.getSalario());

    }



}
