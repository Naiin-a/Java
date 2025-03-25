import java.util.Date;
public class Pessoa {
    private String nome;
    private String cpf;
    private Date datadenascimento;

    public Pessoa (String nome, String cpf, Date datadenascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.datadenascimento = datadenascimento;

    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;

    }

    public String getCpf(){
        return cpf;

    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDatadenascimento(Date datadenascimento){
        this.datadenascimento = datadenascimento;
    }

}
