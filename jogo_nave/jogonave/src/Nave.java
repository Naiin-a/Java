public abstract class Nave {
    protected int x, y, velocidade, vida;

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

    // ✅ Este é o método que corrige seu erro:
    public boolean estaViva() {
        return vida > 0;
    }
}
