package Pessoa;
import java.util.Scanner;

public class Cliente extends Pessoa {

    // Adicionando a variável 'endereco' como atributo
    private String endereco;

    // Construtor que recebe nome, telefone, cpf e endereco
    public Cliente(String nome, String telefone, String cpf, String endereco) {
        super(nome, telefone, cpf);
        this.endereco = endereco;
    }


    //Socitação do atendimento
    void solicitarAtendimento() {
        System.out.println("Cliente " + getNome() + " solicitou atendimento.");
    }

    //Concluindo atendimento
    void verificaSolicitacao() {
        Scanner sc = new Scanner(System.in);
        System.out.println("O atendimento do cliente " + getNome() + " terminou? (true/false)");
        boolean resposta = sc.nextBoolean();

        //Fazendo a verificação da solicitação
        if (resposta) {
            efetuarPagamento();
        } else {
            System.out.println("Aguardando término do serviço para o cliente " + getNome());
        }
        
        //Fechando o scanner
        sc.close();
    }

    //Efetuando pagamento
    void efetuarPagamento() {
        if (this == null) {
            System.out.println("Cliente nao encontrado. Não é possível efetuar o pagamento.");
            return;
        }
        System.out.println("Efetue o pagamento para o cliente " + getNome());
    }
    

    //Método exivbir informações
    public void exibeInformacoes() {
        System.out.println("O nome do cliente é " + getNome() + ", o endereço é " + endereco +
                ", o CPF é " + getCpf() + " e o telefone é " + getTelefone());
    }
}
