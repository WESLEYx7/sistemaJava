package Pessoa;
import java.util.Scanner;

public class Tecnico extends Pessoa {

    // Verificar disponibilidade
    private boolean servicoConcluido;

    public Tecnico(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
        this.servicoConcluido = false; // Inicializando como não concluído por padrão
    }

    // Métodos da classe Tecnico

    void servicosPendentes() {
        System.out.println("Serviços pendentes para o técnico " + getNome());
    }

    //Método para concluir serviço
    void conclusaoServico() {
        System.out.println("Serviço concluído para o técnico " + getNome());
        this.servicoConcluido = true;
    }

    //Método verificar a conclusão do serviço
    void verificaConclusao() {
        System.out.println("O serviço terminou (true/false): ");
        Scanner sc = new Scanner(System.in);
        boolean resposta = sc.nextBoolean();
        if (resposta) {
            //Passando outro método após verificar a resposta
            conclusaoServico();
        } else {
            servicosPendentes();
        }
        sc.close();
    }

    //Método para exibir as informações
    public void exibeInformacoes() {
        System.out.println("O nome do técnico é " + getNome() + ", seu CPF é " + getCpf() + " e seu telefone é " + getTelefone());
        System.out.println("Status do serviço: " + (servicoConcluido ? "Concluído" : "Pendente"));
    }
}
