import com.algaworks.banco.CaixaEletronico;
import com.algaworks.banco.Conta;
import com.algaworks.banco.ContaEspecial;
import com.algaworks.banco.ContaInvestimento;
import com.algaworks.banco.Titular;

public class Principal {
    public static void main(String[] args) {
        Conta conta1 = new Conta(new Titular("João da Silva", "12312312300"), 1234,777888);
//
//        System.out.println("CONTA NORMAL -----------------------");
//        conta1.imprimirDemonstrativo();
//
//        conta1.depositar(100);
//        conta1.imprimirDemonstrativo();
//
//        conta1.sacar(27.5);
//        conta1.imprimirDemonstrativo();
//
//        System.out.println(conta1);
//
//        System.out.println("\n#######################################");

        //Teste conta Investimento
        ContaInvestimento contaInv1 = new ContaInvestimento(new Titular("Ana Lima", "32131232112"),4321,987555);

        System.out.println("CONTA INVESTIMENTO -----------------------");

        contaInv1.depositar(100);
        contaInv1.creditarRendimentos(6);

        contaInv1.imprimirDemonstrativo();

        System.out.println("\n#######################################");
//
//        //Teste conta Especial
        ContaEspecial contaEs1 = new ContaEspecial(new Titular("Anita Bolada", "087334512390"),3421,234123,90);
        contaEs1.setLimiteChequeEspecial(1000);

        System.out.println("CONTA ESPECIAL -----------------------");

        contaEs1.depositar(300);
        contaEs1.debitarTarifaMensal();

        contaEs1.imprimirDemonstrativo();

        System.out.println("\n#######################################");

        CaixaEletronico caixaeletronico = new CaixaEletronico();
        caixaeletronico.transferir(contaEs1, contaInv1, 100);

        contaEs1.imprimirDemonstrativo();
        contaInv1.imprimirDemonstrativo();

        caixaeletronico.imprimirDemonstrativo(contaEs1);

        caixaeletronico.imprimirDemonstrativo(contaInv1);
    }
}
