public class InimigoFraco extends Inimigo {

    public InimigoFraco(int posX, int posY) {
        super(posX, posY, 20, 1); // vida 20, velocidade 1 (exemplo)
    }

    @Override
    public void atacar(Nave nave) {
        nave.receberDano(5); // exemplo de dano
    }
}