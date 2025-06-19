import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaInicio extends JFrame {
    private JTextField txtNome;
    public TelaInicio() {
        setTitle("Bem-vindo");
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        txtNome = new JTextField();
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener((ActionEvent e) -> {
            String nome = txtNome.getText().trim();
            if (!nome.isEmpty()) {
                dispose();
                new TelaSelecao(nome);
            }
        });

        add(new JLabel("Digite seu nome:"), BorderLayout.NORTH);
        add(txtNome, BorderLayout.CENTER);
        add(btnOk, BorderLayout.SOUTH);
        setVisible(true);
    }
}
