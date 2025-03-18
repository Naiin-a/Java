public class aluno {
    private String nome;
    private double nota1, nota2;

    // Construtor
    public aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // Método para calcular a média
    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    // Método para obter o nome do aluno
    public String getNome() {
        return nome;
    }

    // Método para imprimir o aluno e sua média
    @Override
    public String toString() {
        return nome + " - Média: " + calcularMedia();
    }
}
