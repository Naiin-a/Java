import java.util.Date;
class Aluno extends Pessoa {
    private int matricula;

    public Aluno(String nome, String cpf, Date datadenascimento, int matricula){
        super(nome, cpf, datadenascimento);
        this.matricula = matricula;
    }
    public int getMatricula(){
        return matricula;

    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
}
