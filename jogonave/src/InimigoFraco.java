public class InimigoFraco extends Inimigo {
    public InimigoFraco(int posX, int posY) {
        super(posX, posY, 20, 40, "/imagens/inimigo_fraco.png"); // vida 20, velocidade 1 (exemplo)
    }
    @Override
    public void atacar(Nave nave) {
        nave.receberDano(10); // exemplo de dano
    }
    @Override
    public int getPontuacao() {
        return 10;
    }
}

