
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaSelecao extends JFrame {
    public TelaSelecao(String nomeJogador) {
        setTitle("Seleção de Nave");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1));
        JLabel lbl = new JLabel("Olá, " + nomeJogador + "! Escolha sua nave:", SwingConstants.CENTER);
        add(lbl);

        JButton b1 = new JButton("Nave Ataque");
        JButton b2 = new JButton("Nave Defesa");
        JButton b3 = new JButton("Nave Exploração");
        b1.addActionListener((ActionEvent e)-> iniciar(nomeJogador, new NaveAtaque()));
        b2.addActionListener((ActionEvent e)-> iniciar(nomeJogador, new NaveDefesa()));
        b3.addActionListener((ActionEvent e)-> iniciar(nomeJogador, new NaveExploradora()));

        add(b1); add(b2); add(b3);
        setVisible(true);
    }

    private void iniciar(String nome, Nave nave) {
        dispose();
        new JogoFrame(nome, nave).setVisible(true);

    }
}