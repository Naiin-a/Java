public abstract class Inimigo {
    protected int x,y,vida,vel;
    protected boolean jaAtacou = false;
    public Inimigo(int x,int y,int vida,int vel){this.x=x;this.y=y;this.vida=vida;this.vel=vel;}

    public void moverPara(Nave n) {
        y += vel; // Move para baixo

        // Faz o inimigo reaparecer no topo se sair da tela
        if (y > 600) {
            y = -30;
            x = new java.util.Random().nextInt(800);
        }
    }


    public boolean colidiu(Nave n) {
        return Math.abs(x - n.getX()) < 15 && Math.abs(y - n.getY()) < 15;
    }
    public boolean podeAtacar(Nave n) {
        if (colidiu(n) && !jaAtacou) {
            jaAtacou = true;
            return true;
        }
        return false;
    }

    public void receberDano(int d){ vida-=d; }

    public boolean estaVivo(){ return vida>0; }

    public abstract void atacar(Nave n);

    public int getX()
    {return x;}

    public int getY()
    {return y;}

    public int getVida()
    {return vida;}

}