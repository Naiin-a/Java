import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class main2 {
public static void main(String[] args) {
// Criando a janela principal
JFrame frame = new JFrame("Entrada e Ação com Swing");
frame.setSize(400, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(null);
// Variável de controle (poderia estar encapsulada em uma
classe)
final String[] nomeUsuario = {""};
// Campo de entrada de texto
JTextField campoTexto = new JTextField();
campoTexto.setBounds(50, 30, 200, 30);
frame.add(campoTexto);
// Label que será atualizado
JLabel labelResultado = new JLabel("Digite seu nome acima");
labelResultado.setBounds(50, 70, 300, 30);
frame.add(labelResultado);
// Botão que executa a ação
JButton botao = new JButton("Enviar");
botao.setBounds(260, 30, 80, 30);
frame.add(botao);
// Ação do botão
botao.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
nomeUsuario[0] = campoTexto.getText(); // Atualiza
variável
labelResultado.setText("Olá, " + nomeUsuario[0] +
"!"); // Atualiza o JLabel
}
});
// Tornando a janela visível
frame.setVisible(true);
}
}
