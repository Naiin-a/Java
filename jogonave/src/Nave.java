import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Rectangle;

public abstract class Nave {
    protected int x, y, velocidade, vida;
    protected int danoDoTiro = 10;
    protected BufferedImage imagem;

    public Nave(int velocidade, int vida, String imagePath) {
        this.velocidade = velocidade;
        this.vida = vida;
        this.x = 100;
        this.y = 100;
        try {
            InputStream is = getClass().getResourceAsStream(imagePath);
            if (is != null) {
                imagem = ImageIO.read(is);
            } else {
                System.err.println("Imagem não encontrada: " + imagePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mover(int dx, int dy) {
        x += dx * velocidade;
        y += dy * velocidade;
    }

    public abstract Projectile atirar();

    public int getX() { return x; }
    public int getY() { return y; }
    public int getVida() { return vida; }

    public void receberDano(int d) {
        vida -= d;
    }

    public boolean estaViva() {
        return vida > 0;
    }
    public int getDanoDoTiro() {

        return danoDoTiro;
    }

    public BufferedImage getImagem() {
        return imagem;
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 40); // Retorna uma hitbox de 40x40
    }
}

