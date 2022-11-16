package com.algaworks.banco;

public class Conta {
    private Titular titular;
    private int agencia;
    private int numero;
    private double saldo;

    public Conta(Titular titular, int agencia, int numero) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public Titular getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public final double getSaldo() {
        return saldo;
    }

    protected void validarSaldoParaSaque (double valorSaque) {
        if (getSaldo() < valorSaque) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public void sacar (double valorSaque) {
        if (valorSaque <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser superior a R$ 0,0 (zero reais)");
        }

        validarSaldoParaSaque(valorSaque);

        saldo -= valorSaque;
    }

    public final void depositar (double valorDeposito) { //coloquei final para evitar ser sobreescrito em outras classes
        if (valorDeposito <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser superior a R$ 0,0 (zero reais)");
        }

        saldo += valorDeposito;
    }


    public void imprimirDemonstrativo () {
        System.out.println();
        System.out.printf("Agência: %d%n", getAgencia());
        System.out.printf("Conta: %s%n", getNumero());
        System.out.printf("Titular: %s%n", getTitular().getNome());
        System.out.printf("Saldo: %.2f%n", getSaldo());
    }

    @Override
    public String toString() {
        return "[ Conta:\n" +
                "titular = " + titular +
                ", agencia = " + agencia +
                ", numero = " + numero +
                ", saldo = " + saldo +
                " ]";
    }
}
