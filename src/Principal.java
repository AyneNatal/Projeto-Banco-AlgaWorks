import com.algaworks.banco.Conta;
import com.algaworks.banco.ContaEspecial;
import com.algaworks.banco.ContaInvestimento;
import com.algaworks.banco.Titular;

public class Principal {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.setTitular(new Titular("João da Silva", "12312312300"));
        conta1.setAgencia(1234);
        conta1.setNumero(777888);

        System.out.println("CONTA NORMAL -----------------------");
        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.sacar(27.5);
        conta1.imprimirDemonstrativo();

        System.out.println("\n#######################################");

        //Teste conta Investimento
        ContaInvestimento contaInv1 = new ContaInvestimento();
        contaInv1.setTitular(new Titular("Ana Lima", "32131232112"));
        contaInv1.setAgencia(4321);
        contaInv1.setNumero(987555);

        System.out.println("CONTA INVESTIMENTO -----------------------");
        contaInv1.imprimirDemonstrativo();

        contaInv1.depositar(100);
        contaInv1.imprimirDemonstrativo();

        contaInv1.creditarRendimentos(6);
        contaInv1.imprimirDemonstrativo();

        System.out.println("\n#######################################");

        //Teste conta Especial
        ContaEspecial contaEs1 = new ContaEspecial();
        contaEs1.setTitular(new Titular("Anita Bolada", "087334512390"));
        contaEs1.setAgencia(3421);
        contaEs1.setNumero(234123);
        contaEs1.setLimiteChequeEspecial(1000);
        contaEs1.setTarifaMensal(90);

        System.out.println("CONTA ESPECIAL -----------------------");
        contaEs1.imprimirDemonstrativo();

        contaEs1.depositar(100);
        contaEs1.imprimirDemonstrativo();

        contaEs1.sacar(200);
        contaEs1.imprimirDemonstrativo();

        contaEs1.debitarTarifaMensal();
        contaEs1.imprimirDemonstrativo();

    }
}
