import javax.swing.ImageIcon;
public class NaveAtaque extends Nave {

    public NaveAtaque() {
        super(20,80, "/imagens/nave_ataque.png");
        this.danoDoTiro = 50;

    }
    @Override
    public Projectile atirar() {
        return new Projectile(x + 5, y, getDanoDoTiro()); // agora usa o valor correto
    }

}

