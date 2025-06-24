public class NaveDefesa extends Nave {

    public NaveDefesa() {
        super(10, 200, "/imagens/nave_defesa.png");
        this.danoDoTiro = 20;
    }

    @Override
    public Projectile atirar() {
        return new Projectile(x + 5, y, getDanoDoTiro());
    }
}

