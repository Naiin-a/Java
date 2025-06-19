public abstract class Nave {
    protected int x, y, velocidade, vida;
    protected int danoDoTiro = 10;

    public Nave(int velocidade, int vida) {
        this.velocidade = velocidade;
        this.vida = vida;
        this.x = 100;
        this.y = 100;
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
}
