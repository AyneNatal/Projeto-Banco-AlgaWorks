package com.algaworks.banco;

public class CaixaEletronico {
    public static final double TARIFA_TRANSFERENCIA = 10;
    public static final double TARIFA_IMPRESSAO_DEMONSTRATIVO = 2;

    public void transferir (Conta contaOrigem, Conta contaDestino, double valorTransferencia) {
        System.out.printf("Transferindo R$%.2f da conta %d/%d para %d/%d%n", valorTransferencia, contaOrigem.getAgencia(), contaOrigem.getNumero(), contaDestino.getAgencia(), contaDestino.getNumero());

        contaOrigem.sacar(valorTransferencia + TARIFA_TRANSFERENCIA);
        contaDestino.depositar(valorTransferencia);
    }

    public void imprimirDemonstrativo (Conta conta) {
        ContaInvestimento contaInvestimento = (ContaInvestimento) conta; //evitar fazer o downcast!

        if (((ContaInvestimento) conta).getValorTotalRendimentos() > 0) {
            System.out.print("\n---------\nSem custo de impressão");
            conta.imprimirDemonstrativo();
            return;
        }

        System.out.printf("%n-----%nCusto da impressão: R$%.2f%n", TARIFA_IMPRESSAO_DEMONSTRATIVO);
        conta.sacar(TARIFA_IMPRESSAO_DEMONSTRATIVO);
        conta.imprimirDemonstrativo();
    }
}
