public class InimigoMedio extends Inimigo {
    public InimigoMedio(int x,int y){ super(x,y,100,4);}
    @Override public void atacar(Nave n){ n.receberDano(10);}}