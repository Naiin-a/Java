public class Main {
    public static void main(String[] args){
        cliente c1 = new cliente();
        cliente c2 = new cliente();

        c1.setNome("rafael");
        c2.setNome("paulo");

        c1.setCPF("23123123");
        c2.setCPF("1q231231");

        c1.depositar(1500);
        c2.depositar(1600);

        System.out.println("nome " + c1.getNome());


    }
}
