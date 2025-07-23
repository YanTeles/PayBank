public class Conta {
    private String nome;
    private String tipo;
    private double saldo;

    public Conta(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
