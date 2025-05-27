public class NaveAtaque extends Nave {
    public NaveAtaque() { super(10,100); }
    @Override
    public Projectile atirar() {
        return new Projectile(x+15,y,20); // dano 20
    }
}