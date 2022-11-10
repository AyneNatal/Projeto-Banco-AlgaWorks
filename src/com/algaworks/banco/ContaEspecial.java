package com.algaworks.banco;

public class ContaEspecial extends ContaInvestimento{
    private double tarifaMensal;
    private double limiteChequeEspecial;


    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void debitarTarifaMensal () {
        sacar(getTarifaMensal());
    }

    public double getSaldoDisponivel () {
        return getSaldo() + getLimiteChequeEspecial();
    }

    protected void validarSaldoParaSaque (double valorSaque) {
        if (getSaldoDisponivel() < valorSaque) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public void imprimirDemonstrativo () {
        System.out.println();
        System.out.printf("Agência: %d%n", getAgencia());
        System.out.printf("Conta: %s%n", getNumero());
        System.out.printf("Titular: %s%n", getTitular().getNome());
        System.out.printf("Saldo: %.2f%n", getSaldo());
        System.out.printf("Saldo Disponível com Cheque Especial: %.2f%n", getSaldoDisponivel());
    }
}
