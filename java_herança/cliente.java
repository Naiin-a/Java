public class cliente extends conta{
    private String Nome;
    private String CPF;


    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;

    }
    public String getCPF(String CPF){
        return this.CPF;
    }
}
