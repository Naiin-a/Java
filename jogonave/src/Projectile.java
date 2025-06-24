public class Projectile {
    private int y,x, dano;

    public Projectile(int x,int y,int dano){
        this.x=x;
        this.y=y;
        this.dano=dano;
    }

    public void mover() { y -= 15; }

    public int getX(){return x;}
    public int getY(){return y;}
    public int getDano()
    {return dano;}
}