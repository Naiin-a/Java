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

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(nave.getX(), nave.getY(), 30, 30);

        for (Inimigo inv : inimigos) {
            if (inv instanceof InimigoForte) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.YELLOW);
            }
            g.fillRect(inv.getX(), inv.getY(), 30, 30);
        }

        g.setColor(Color.YELLOW);
        for (Projectile t : tiros)
            g.fillOval(t.getX(), t.getY(), 10, 10);

        g.setColor(Color.WHITE);
        g.drawString("Vida: " + nave.getVida(), 10, 50);
        g.drawString("Score: " + score, 10, 70);
    }
}
