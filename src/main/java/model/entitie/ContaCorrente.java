package model.entitie;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ContaCorrente extends Conta{
    public ContaCorrente() {
        super();
    }

    public ContaCorrente(Double saldo) {
        super(saldo);
    }

    @Override
    public final void saque(double quantia) {
        if (quantia > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= quantia;
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
