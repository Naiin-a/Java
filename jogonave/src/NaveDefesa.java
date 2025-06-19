public class NaveDefesa extends Nave {

    public NaveDefesa() {
        super(10, 200);
        this.danoDoTiro = 5;
    }

    @Override
    public Projectile atirar() {
        return new Projectile(x + 5, y, getDanoDoTiro());
    }
}
