public class NaveExploradora extends Nave {

    public NaveExploradora() {
        super(30, 80);
        this.danoDoTiro = 8;
    }

    @Override
    public Projectile atirar() {
        return new Projectile(x + 5, y, getDanoDoTiro());
    }
}
