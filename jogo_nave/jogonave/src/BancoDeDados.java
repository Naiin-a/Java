import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BancoDeDados {
    private static final String ARQUIVO = "pontuacoes.txt";

    public static void salvar(String nome, int pontos) {
        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            String dataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            out.println("Nome: " + nome + " | Pontos: " + pontos + " | Data: " + dataHora);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String lerPontuacoesComoTexto() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                sb.append(linha).append("\n");
            }
        } catch (IOException e) {
            sb.append("Nenhuma pontuação encontrada.");
        }
        return sb.toString();
    }

    public static void apagarTudo() {
        try (PrintWriter pw = new PrintWriter(ARQUIVO)) {
            pw.write("");
        } catch (IOException e) {
            System.out.println("Erro ao apagar pontuações.");
        }
    }
}
