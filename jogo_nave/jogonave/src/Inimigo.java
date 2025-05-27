public abstract class Inimigo {
    protected int x,y,vida,vel;
    public Inimigo(int x,int y,int vida,int vel){this.x=x;this.y=y;this.vida=vida;this.vel=vel;}
    public void moverPara(Nave n){ if(x<n.getX()) x+=vel; else if(x>n.getX()) x-=vel; if(y<n.getY()) y+=vel; else if(y>n.getY()) y-=vel;}public boolean colidiu(Nave n){ return Math.abs(x-n.getX())<15 && Math.abs(y-n.getY())<15; }
    public void receberDano(int d){ vida-=d; }
    public boolean estaVivo(){ return vida>0; }
    public abstract void atacar(Nave n);
    public int getX(){return x;} public int getY(){return y;} public int getVida(){return vida;}
}