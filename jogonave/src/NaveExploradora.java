public class NaveExploradora extends Nave {

    public NaveExploradora() {
        super(25, 120, "/imagens/nave_exploradora.png");
        this.danoDoTiro = 35;
    }

    @Override
    public Projectile atirar() {
        return new Projectile(x + 5, y, getDanoDoTiro());
    }
}

