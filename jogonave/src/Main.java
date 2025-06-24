
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        BancoDeDados.conectar();
        SwingUtilities.invokeLater(() -> {
            new TelaInicio();
        });
    }
}