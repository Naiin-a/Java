import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<aluno> alunos = new ArrayList<>();

        System.out.print("Quantos alunos você deseja cadastrar? ");
        int numAlunos = scanner.nextInt();
        scanner.nextLine(); // Consumir o "enter" após o número de alunos

        // Coletar dados dos alunos
        for (int i = 0; i < numAlunos; i++) {
            System.out.println("Digite os dados do aluno " + (i + 1));
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Nota 1: ");
            double nota1 = scanner.nextDouble();
            System.out.print("Nota 2: ");
            double nota2 = scanner.nextDouble();
            scanner.nextLine(); // Consumir o "enter" após a nota2

            // Adicionar o aluno à lista
            alunos.add(new aluno(nome, nota1, nota2));
        }

        // Ordenar os alunos pela média
        Collections.sort(alunos, new Comparator<aluno>() {
            @Override
            public int compare(aluno a1, aluno a2) {
                return Double.compare(a2.calcularMedia(), a1.calcularMedia());
            }
        });

        // Imprimir os alunos com as médias ordenadas
        System.out.println("Média dos alunos ordenada:");
        for (aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
