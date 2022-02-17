package model.entitie;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Double saldo) {
        super(saldo);
    }

    @Override
    public void saque(double quantia) {
        if (quantia > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= quantia * 1.10;
        }
    }

    @Override
    public void deposito(double quantia) {
        this.saldo += quantia;
    }

    @Override
    public final void transferenciaParte1(double quantia, Cliente name) {
        saldo -= quantia;
        name.getTipoConta().deposito(quantia);
    }
}
