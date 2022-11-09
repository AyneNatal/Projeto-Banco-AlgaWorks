package com.algaworks.banco;

public class Conta {
    private Titular titular;
    private int agencia;
    private int numero;
    private double saldo;

    public void sacar (double valorSaque) {
        if (valorSaque <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser superior a R$ 0,0 (zero reais)");
        }
        if (saldo < valorSaque) {
            throw new RuntimeException("Saldo insuficiente");
        }

        saldo -= valorSaque;
    }

    public void depositar (double valorDeposito) {
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


    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

}
