import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Rectangle;

public abstract class Inimigo {
    protected int tickMovimento = 0;       // Conta os ticks
    protected int intervaloMovimento = 15;
    protected int x,y,vida,vel;
    protected boolean jaAtacou = false;
    protected BufferedImage imagem;

    public Inimigo(int x,int y,int vida,int vel, String imagePath){
        this.x=x;this.y=y;this.vida=vida;this.vel=vel;
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

    public abstract int getPontuacao();

    public void mover() {
        tickMovimento++;
        if (tickMovimento >= intervaloMovimento) {
            y += vel;
            tickMovimento = 0;
        }
    }

    public boolean colidiu(Projectile p) {
        // Usando hitbox de 40x40 para o inimigo
        Rectangle inimigoBounds = new Rectangle(x, y, 40, 40);
        Rectangle projetilBounds = new Rectangle(p.getX(), p.getY(), 10, 10); // Tamanho do projétil é 10x10
        return inimigoBounds.intersects(projetilBounds);
    }

    public boolean colidiu(Nave n) {
        // Usando hitbox de 40x40 para o inimigo
        Rectangle inimigoBounds = new Rectangle(x, y, 40, 40);
        // Usando hitbox de 40x40 para a nave
        Rectangle naveBounds = new Rectangle(n.getX(), n.getY(), 40, 40);
        return inimigoBounds.intersects(naveBounds);
    }

    public boolean podeAtacar(Nave n) {
        if (colidiu(n) && !jaAtacou) {
            jaAtacou = true;
            return true;
        }
        return false;
    }

    public void receberDano(int d){ vida-=d; }

    public boolean estaVivo(){ return vida>0; }

    public abstract void atacar(Nave n);

    public int getX()
    {return x;}

    public int getY()
    {return y;}

    public int getVida()
    {return vida;}

    public BufferedImage getImagem() {
        return imagem;
    }
}

