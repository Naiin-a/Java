public class InimigoForte extends Inimigo {
    public InimigoForte(int x,int y){ super(x,y,150,3);}
    @Override public void atacar(Nave n){ n.receberDano(20);}}