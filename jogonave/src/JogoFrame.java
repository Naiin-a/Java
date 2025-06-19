import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class JogoFrame extends JFrame implements KeyListener, ActionListener {
    private long ultimoTiro = 1;
    private final long DELAY_TIRO = 200;
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
        nave.x = 320; // Começa no meio da tela (5 faixas: 0, 160, 320, 480, 640)
        nave.y = 500; // Posição mais baixa da tela
        score = 0;
        inimigos.clear();
        tiros.clear();

        int[] pistas = {100, 220, 340, 460, 580};

        Random rand = new Random();
        inimigos.add(new InimigoFraco(pistas[rand.nextInt(pistas.length)], -50));
        inimigos.add(new InimigoMedio(pistas[rand.nextInt(pistas.length)], -50));
        inimigos.add(new InimigoForte(pistas[rand.nextInt(pistas.length)], -50));

        timer = new javax.swing.Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Inimigo inv : new ArrayList<>(inimigos)) {
            inv.moverPara(nave);
            if (inv.podeAtacar(nave)) {
                inv.atacar(nave);
                inimigos.remove(inv); // inimigo desaparece após causar dano
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
        if (new Random().nextInt(100) < 3 && inimigos.size() < 10) { // máx. 10 inimigos
            int x = 100 + new Random().nextInt(600); // posição X entre 100 e 700 (área centralizada)
            int y = -50; // spawn acima da tela

            double tipo = Math.random();

            if (tipo < 0.33) {
                inimigos.add(new InimigoFraco(x, y));
            } else if (tipo < 0.66) {
                inimigos.add(new InimigoMedio(x, y));
            } else {
                inimigos.add(new InimigoForte(x, y));
            }
        }


        gamePanel.setpontos(score);
        gamePanel.repaint();
    }

    private void gameOver() {
        timer.stop();
        BancoDeDados.salvar(nomeJogador, score);

        List<String> historico = BancoDeDados.lerTop5Pontuacoes();
        int escolha = JOptionPane.showOptionDialog(this, "Top 5 Pontuações:\n" + String.join("\n", historico) + "\n\nDeseja apagar os dados?",
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
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_LEFT) {
            nave.x -= nave.velocidade;
            if (nave.x < 0) nave.x = 0;
        }

        if (tecla == KeyEvent.VK_RIGHT) {
            nave.x += nave.velocidade;
            if (nave.x > 800 - 40) nave.x = 800 - 40; // 40 é largura estimada da nave
        }

        if (tecla == KeyEvent.VK_SPACE) {
            long agora = System.currentTimeMillis();
            if (agora - ultimoTiro >= DELAY_TIRO) {
                tiros.add(nave.atirar()); //
                ultimoTiro = agora;
            }
        }

    }



    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

}


