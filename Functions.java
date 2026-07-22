import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Functions{
    private double saldo;
    private String cpf;
    private Map<String, Double> ClientesCadastrados= new HashMap<>();
    private Scanner scanner;
    public Functions(Scanner scanner){
        this.scanner = scanner;
    }
    public  void IniciarConta(double saldo, String cpf)
    {
        this.saldo = saldo;
        this.cpf = cpf;
        this.ClientesCadastrados.put(cpf, saldo);
    }
    public void CriarConta(String cpf, double saldo){
        String linha = "=".repeat(60);
        System.out.println("Informe seu cpf");
        cpf = scanner.nextLine();
        
        
        System.out.println("Insira a quantiar inicial:");
        saldo = scanner.nextDouble();
        if(VerificarSaldoInicial(saldo)==0){
            saldo = 0.0;
            double SaldoInicial=0.0; 
            System.out.println(linha);
            System.out.println("Insira um valor valido!");
            SaldoInicial = scanner.nextDouble();
            saldo += SaldoInicial;
        }
        ClientesCadastrados.put(cpf, saldo);       
    }
    public int VerificarSaldoInicial(double saldo){
        if(saldo <0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public void ConsultarSaldo(String cpf)
    {
       
        if(VerificarCpf( cpf)== 1)
        {
           double saldoVisualizando = ClientesCadastrados.get(cpf);
           System.out.println("Saldo atual:"+saldoVisualizando);
        }
        else 
        {
            System.out.println("CPF NÃO ENCONTRADO!!!!!");
        }
    }
    public void Depositar(String cpf){
        
        double MaisSaldo=0.0;
        double SaldoAtual=0.0;
        String linha = "=".repeat(60);
        if(VerificarCpf(cpf)== 1){
            System.out.println("Encotrado");
            System.out.println(linha);
            System.out.println("Informe a quantia");
            MaisSaldo = scanner.nextDouble();
            SaldoAtual = ClientesCadastrados.get(cpf);
            if(VerificarDeposito(cpf,MaisSaldo )==1){
                SaldoAtual+= MaisSaldo;
                ClientesCadastrados.put(cpf, SaldoAtual);
                System.out.println("saldo atualizado");
            }
            else{
                System.out.println("Esse deposito não é valido!");
                MaisSaldo = 0.0;
                System.out.println(linha);
                System.out.println("Informe a quantia Novamente(com um valor maior!)");
                MaisSaldo = scanner.nextDouble();
                SaldoAtual = ClientesCadastrados.get(cpf);
                SaldoAtual+= MaisSaldo;
                ClientesCadastrados.put(cpf, SaldoAtual);
                System.out.println("saldo atualizado");

                
            }
        }
        else {
            System.out.println("CPF NÃO ENCONTRADO!");
        }
        
    }
    public void Sacar(String cpf){
        double saque=0.0;
        double SaldoAtual=0.0;
        String linha = "=".repeat(60);
        if(VerificarCpf(cpf)==1){
            System.out.println(linha);
            System.out.println("Informe o valor");
            saque = scanner.nextDouble();
            if(VerificarSacagem(cpf, saque)==1){
                SaldoAtual = ClientesCadastrados.get(cpf);
                SaldoAtual -= saque;
                ClientesCadastrados.put(cpf, SaldoAtual);
                System.out.println("Saldo realizado com sucesso");
            }
            else {
                System.out.println("saldo insuficiente!");
            }
        }
        else{
            System.out.println("CPF não cadastrado!");
        }
    }
    public int VerificarDeposito(String cpf, double deposito){
        
        double saldoAtual = ClientesCadastrados.get(cpf);
        if(deposito <= 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public int VerificarSacagem(String cpf, double saque){
        double saldoCliente = ClientesCadastrados.get(cpf);
        if(saldoCliente > saque){
            return 1;
        }
        else {
            return 0;
        }
    }
    public int VerificarCpf(String cpf)
    {
       if(ClientesCadastrados.containsKey(cpf)){
            return 1;
       }
       else {
        return 0;
       }
    }
}

