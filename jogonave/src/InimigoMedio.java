public class InimigoMedio extends Inimigo {
    public InimigoMedio(int x,int y){
        super(x,y,100,50, "/imagens/inimigo_medio.png");
    }

    @Override
    public void atacar(Nave n){
        n.receberDano(20);}

    @Override
    public int getPontuacao() {
        return 25;
    }
}

