package Program;

import model.entitie.*;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);

        System.out.print("Em qual Banco você deseja abrir uma Conta (Nome): ");
        String nomeBanco = sc.nextLine();
        Banco banco = new Banco();
        banco.setName(nomeBanco);

        System.out.print("Quantas contas deseja abrir? ");
        int numeroDeContas = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= numeroDeContas; i++){
            System.out.println("Conta #" + i + " dados: ");
            System.out.print("Digite o seu nome: ");
            String nomeCliente = sc.nextLine();
            System.out.print("Digite o tipo de conta que deseja abrir (Conta Corrente/Conta Poupança): ");
            String tipoConta = sc.nextLine();
            System.out.print("Digite o valor inicial de seu saldo: ");
            double saldo = sc.nextDouble();
            sc.nextLine();
            if (Objects.equals(tipoConta, "Conta Corrente")){
                Conta cc = new ContaCorrente(saldo);
                Cliente cliente = new Cliente(nomeCliente, cc);
                banco.setCliente(cliente);
                banco.AddCliente(new Cliente(nomeCliente,cliente.getTipoConta()));

            } else {
                Conta cp = new ContaPoupanca(saldo);
                Cliente cliente = new Cliente(nomeCliente, cp);
                banco.setCliente(cliente);
                banco.AddCliente(new Cliente(nomeCliente,cliente.getTipoConta()));
            }
        }

        System.out.print("Deseja fazer um Saque (Sim/Não): ");
        String saqueResposta = sc.nextLine();
        if (Objects.equals(saqueResposta, "Sim")){
            System.out.print("Em qual conta (Nome da Conta)?: ");
            String nomeClienteSaque = sc.nextLine();
            System.out.print("Qual o valor do saque: ");
            double saque = sc.nextDouble();
            if (Objects.equals(nomeClienteSaque, banco.getCliente().getName())){
                banco.getCliente().getTipoConta().saque(saque);
                System.out.println("Saldo Atualizado: " + banco.getCliente().getTipoConta().getSaldo());
            }
        }
        sc.nextLine();

        System.out.print("Deseja fazer um depósito (Sim/Não)? ");
        String depositoResposta = sc.nextLine();
        if (Objects.equals(depositoResposta, "Sim")){
            System.out.print("Em qual conta (Nome da Conta)?: ");
            String nomeClienteDeposito = sc.nextLine();
            System.out.print("Qual o valor do deposito?: ");
            double deposito = sc.nextDouble();
            sc.nextLine();
            if (Objects.equals(nomeClienteDeposito, banco.getCliente().getName())) {
                banco.getCliente().getTipoConta().deposito(deposito);
                System.out.println("Saldo atualizado: " + banco.getCliente().getTipoConta().getSaldo());
            }
        }


        System.out.print("Deseja obter uma lista de clientes do banco (Sim/Não): ");
        String resposta = sc.nextLine();
        if (Objects.equals(resposta, "Sim")){
            for (Cliente cliente : banco.clienteList) {
                System.out.println(cliente.getName());
            }
        }

        System.out.println("Fim do programa!");



        sc.close();

    }
}
