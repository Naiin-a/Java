import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private Nave nave;
    private List<Inimigo> inimigos;
    private List<Projectile> tiros;
    private int score;

    public GamePanel(Nave nave, List<Inimigo> inimigos, List<Projectile> tiros, int score) {
        this.nave = nave;
        this.inimigos = inimigos;
        this.tiros = tiros;
        this.score = score;
        setBackground(Color.BLACK);
    }

    public void setpontos(int score) {
        this.score = score;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a nave
        if (nave.getImagem() != null) {
            g.drawImage(nave.getImagem(), nave.getX(), nave.getY(), 40, 40, null); // Tamanho fixo para a nave
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(nave.getX(), nave.getY(), 30, 30);
        }

        // Desenha os inimigos
        for (Inimigo inv : inimigos) {
            if (inv.getImagem() != null) {
                g.drawImage(inv.getImagem(), inv.getX(), inv.getY(), 40, 40, null); // Tamanho fixo para os inimigos
            } else {
                if (inv instanceof InimigoForte) {
                    g.setColor(Color.RED);
                } else if (inv instanceof InimigoFraco) {
                    g.setColor(Color.CYAN);
                } else {
                    g.setColor(Color.YELLOW);
                }
                g.fillRect(inv.getX(), inv.getY(), 20, 20);
            }
        }

        g.setColor(Color.YELLOW);
        for (Projectile t : tiros)
            g.fillOval(t.getX(), t.getY(), 10, 10);

        g.setColor(Color.WHITE);
        g.drawString("Vida: " + nave.getVida(), 10, 50);
        g.drawString("Score: " + score, 10, 70);
    }
}

