package com.algaworks.banco;

public class ContaInvestimento extends Conta{
    private double valorTotalRendimentos;

    public ContaInvestimento(Titular titular, int agencia, int numero) {
        super(titular, agencia, numero); //chamando o construtor da sua superclasse (Conta)
    }

    public double getValorTotalRendimentos() {
        return valorTotalRendimentos;
    }

    public void creditarRendimentos (double percentualJuros) {
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        this.valorTotalRendimentos += valorRendimentos;
        depositar(valorRendimentos);
    }

    @Override
    public String toString() {
        return "[ ContaInvestimento:\n" +
                "titular = " + getTitular() +
                ", agencia = " + getAgencia() +
                ", numero = " + getNumero() +
                ", valorTotalRendimentos = " + getValorTotalRendimentos() +
                " ]";
    }
}
