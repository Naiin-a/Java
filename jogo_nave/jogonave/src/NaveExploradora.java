public class NaveExploradora extends Nave {
    public NaveExploradora() { super(7,120); }
    @Override
    public Projectile atirar() {
        return new Projectile(x+15,y,15); // dano 15
    }
}