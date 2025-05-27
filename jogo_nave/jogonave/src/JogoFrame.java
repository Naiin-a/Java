import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class JogoFrame extends JFrame implements KeyListener, ActionListener {
    private Nave nave;
    private String nomeJogador;
    private List<Inimigo> inimigos = new ArrayList<>();
    private List<Projectile> tiros = new ArrayList<>();
    private javax.swing.Timer timer;
    private int score;

    private GamePanel gamePanel;

    public JogoFrame(String nome, Nave nave) {
        this.nomeJogador = nome;
        this.nave = nave;

        setTitle("Jogo Nave");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);

        init();

        gamePanel = new GamePanel(nave, inimigos, tiros, score);
        setContentPane(gamePanel);
        setVisible(true);
    }

    private void init() {
        nave.x = 100;
        nave.y = 250;
        score = 0;
        inimigos.clear();
        tiros.clear();
        inimigos.add(new InimigoMedio(700, 100));
        inimigos.add(new InimigoForte(700, 400));
        timer = new javax.swing.Timer(50, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Inimigo inv : new ArrayList<>(inimigos)) {
            inv.moverPara(nave);
            if (inv.colidiu(nave)) {
                inv.atacar(nave);
                if (!nave.estaViva()) {
                    gameOver();
                    return;
                }
            }
        }

        for (Iterator<Projectile> it = tiros.iterator(); it.hasNext(); ) {
            Projectile t = it.next();
            t.mover();
            for (Iterator<Inimigo> it2 = inimigos.iterator(); it2.hasNext(); ) {
                Inimigo inv = it2.next();
                if (Math.abs(t.getX() - inv.getX()) < 15 && Math.abs(t.getY() - inv.getY()) < 15) {
                    inv.receberDano(t.getDano());
                    it.remove();
                    if (!inv.estaVivo()) {
                        it2.remove();
                        score += 10;
                    }
                    break;
                }
            }
        }
        // Geração dinâmica de inimigos
        if (new Random().nextInt(100) < 3) { // ~3% de chance por ciclo
            int x = 800;
            int y = new Random().nextInt(550);
            if (new Random().nextBoolean()) {
                inimigos.add(new InimigoMedio(x, y));
            } else {
                inimigos.add(new InimigoForte(x, y));
            }
        }

        gamePanel.setScore(score);
        gamePanel.repaint();
    }

    private void gameOver() {
        timer.stop();
        BancoDeDados.salvar(nomeJogador, score);

        String historico = BancoDeDados.lerPontuacoesComoTexto();
        int escolha = JOptionPane.showOptionDialog(this, historico + "\n\nDeseja apagar os dados?",
                "Histórico de Pontuações",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Apagar Tudo", "OK", "Cancelar"},
                "OK");

        if (escolha == 0) {
            BancoDeDados.apagarTudo();
            JOptionPane.showMessageDialog(this, "Pontuações apagadas.");
        }

        int op = JOptionPane.showConfirmDialog(this,
                "Game Over!\nScore: " + score + "\nTentar novamente?",
                "Fim de Jogo",
                JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            dispose();
            new TelaInicio();
        } else {
            System.exit(0);
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> nave.mover(0, -1);
            case KeyEvent.VK_S -> nave.mover(0, 1);
            case KeyEvent.VK_A -> nave.mover(-1, 0);
            case KeyEvent.VK_D -> nave.mover(1, 0);
            case KeyEvent.VK_SPACE -> tiros.add(nave.atirar());
        }
        gamePanel.repaint();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

}


