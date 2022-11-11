package com.algaworks.banco;

public class ContaEspecial extends ContaInvestimento {
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

    @Override
    protected void validarSaldoParaSaque (double valorSaque) {
        if (getSaldoDisponivel() < valorSaque) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    @Override
    public void imprimirDemonstrativo () {
        super.imprimirDemonstrativo(); //chamando o met da superclasse
        System.out.printf("Saldo Disponível com Cheque Especial: %.2f%n", getSaldoDisponivel());
    }
}
