package SolicitacaoServicos;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Pessoa.Atendente;
import Pessoa.Cliente;
import Pessoa.Tecnico;

//Definindo classe
public class SolicitacaoServicos {
    int id;
    Date dataSolicitacao;
    Date dataInicio;
    Date dataTermino;
    Cliente cliente;
    Atendente atendente;
    String materiaisUtilizados;

    //Criando objeto técnico do tipo técnico
    private Tecnico tecnico;  

    //Getter do técnico
    public Tecnico getTecnico() {
        return tecnico;
    }

    //Setter do técnico
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    //Setter do Cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Setter do Atendente
    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    //Instanciando scanner
    private Scanner sc = new Scanner(System.in);

    //Craindo métdo lerData
    private Date lerData(String mensagem) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
        while (true) {
            try {
                System.out.println(mensagem + " (Formato: dd/MM/yyyy): ");
                String dataString = sc.nextLine();
                return dateFormat.parse(dataString);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }
    }
    
    

    //Método despesasAdicionais
    public void despesasAdicionais() {
        System.out.println("Digite o nome do material: ");
        String nomeMaterial = sc.nextLine();
    
        System.out.println("Qual o valor unitário do material " + nomeMaterial + " (em R$): ");
        double valorMaterial = sc.nextDouble();
    
        System.out.println("Quantas unidades foram utilizadas: ");
        int quantidade = sc.nextInt();
    
        //Lendo o restante da linha para evitar problemas com o buffer
        sc.nextLine();
    
        //Resultado da multiplicação de intens de sua quantidade pelo seu valor
        double valorFinal = quantidade * valorMaterial;
    
        //Armazenando os valores na variável
        materiaisUtilizados = "Material: " + nomeMaterial + ", Valor Unitário: R$" + valorMaterial +
                ", Quantidade: " + quantidade + ". Valor Total: R$" + valorFinal + "\n\n";
    }
    

    //Método exibeInformações para mostrar os dados utilizados até o momento
    public void exibeInformacoes() {
        System.out.println("ID: " + id);
        dataSolicitacao = lerData("Digite a data de solicitação");
        dataInicio = lerData("Digite a data de início");
        dataTermino = lerData("Digite a data de término");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Atendente: " + atendente.getNome());
        System.out.println("Materiais Utilizados: " + materiaisUtilizados);
    }
}
