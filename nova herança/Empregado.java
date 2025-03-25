import java.util.Date;
class Empregado extends Pessoa {
    private double salario;

    public Empregado(String nome, String cpf, Date datadenascimento, double salario){
        super(nome, cpf, datadenascimento);
        this.salario = salario;

    }
    public double getSalario(){
        return salario;
    }
}
