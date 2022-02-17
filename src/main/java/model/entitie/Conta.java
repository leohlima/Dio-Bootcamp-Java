package model.entitie;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
public abstract class Conta {
    @Getter
    private Integer agencia = 64;

    @Getter
    private Integer numero = 0;

    @Getter
    protected Double saldo;

    public Conta(double saldo){
        this.saldo = saldo;
        numero++;
    }

    public abstract void saque(double quantia);

    public abstract void deposito(double quantia);

    public abstract void transferenciaParte1(double quantia, Cliente name);


}
