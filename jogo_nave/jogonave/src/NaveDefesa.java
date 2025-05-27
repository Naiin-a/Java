public class NaveDefesa extends Nave {
    public NaveDefesa() { super(5,150); }
    @Override
    public Projectile atirar() {
        return new Projectile(x+15,y,10); // dano 10
    }
}