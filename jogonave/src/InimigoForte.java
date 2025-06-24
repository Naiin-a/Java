public class InimigoForte extends Inimigo {
    public InimigoForte(int x,int y){
        super(x,y,170,60, "/imagens/inimigo_forte.png");
    }

    @Override
    public void atacar(Nave n){
        n.receberDano(40);}

    @Override
    public int getPontuacao() {
        return 50;
    }

}

