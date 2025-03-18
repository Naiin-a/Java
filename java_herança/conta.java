public class conta {
    private double Saldo = 0;

    public void depositar(double Valor){
        this.Saldo = this.Saldo + Valor + (Valor * 0.10);

    }
    public double getSaldo(){
        return this.Saldo;
    }

}

