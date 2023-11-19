package Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SolicitacaoServicos.SolicitacaoServicos;

public class Atendente extends Pessoa {

    private List<Tecnico> tecnicos;
    private Cliente clienteAtual;


    public Atendente(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
        this.tecnicos = new ArrayList<>();
    }

    //Criando método para registrar cliente
    public void registrarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();

        System.out.print("Digite o endereco do cliente: ");
        String endereco = sc.nextLine();

        //Objeto para reecber os dados
        Cliente novoCliente = new Cliente(nome, telefone, cpf, endereco);

        //Exibindo informações do cliente cadastrado
        System.out.println("\nCliente registrado:");
        novoCliente.exibeInformacoes();

        clienteAtual = novoCliente;

        sc.close();
    }

    void efetuarPagamento() {
        if (clienteAtual == null) {
            System.out.println("Cliente nulo. Não é possível efetuar o pagamento.");
            return;
        }
        System.out.println("Efetue o pagamento para o cliente " + clienteAtual.getNome());
    }

    //Método para atribuir o técnico
    public void atribuirTecnico(SolicitacaoServicos solicitacao) {
        Scanner sc = new Scanner(System.in);
        //Verificação se caso não tiver técnico
        if (tecnicos.isEmpty()) {
            System.out.println("Não há técnicos disponíveis no momento.");
        }

        verificandoTecnico();

        //Escolhendo técnico
        System.out.print("Escolha o número do técnico: ");
        int escolhaTecnico = sc.nextInt();

        //Validando escolha
        if (escolhaTecnico < 1 || escolhaTecnico > tecnicos.size()) {
            System.out.println("Escolha inválida.");    
        }

        //Selecionando o técnico escolhido
        Tecnico tecnicoEscolhido = tecnicos.get(escolhaTecnico - 1);
        System.out.println("O técnico " + tecnicoEscolhido.getNome() + " foi escolhido");

        solicitacao.setAtendente(this);
        solicitacao.setTecnico(tecnicoEscolhido);

    }


    //Método para adicionar técnico
    public void adicionarTecnico(Tecnico tecnico) {
        tecnicos.add(tecnico);
        System.out.println("Técnico adicionado com sucesso.");
    }

    //Verificando disponibilidade do técnico
    public void verificandoTecnico() {
        if (tecnicos.isEmpty()) {
            System.out.println("Nenhum técnico disponível.");
        } else {
            System.out.println("Técnicos disponíveis:");
            for (int i = 0; i < tecnicos.size(); i++) {
                System.out.println((i + 1) + ". " + tecnicos.get(i).getNome());
            }
        }
    }
    

    //Método para cobrar o serviço
    public void cobrarServico() {
        //Validando se há cliente
        if (clienteAtual == null) {
            System.out.println("Nenhum cliente para receber o pagamento.");
            return;
        }

        //Cobrando o serviço do cliente
        System.out.println("Cobrando serviço do cliente:");
        clienteAtual.efetuarPagamento();
    }

    //Método para exibir as informações
    public void exibeInformacoes() {
        System.out.println("O nome do atendente é " + getNome() + ", o CPF é " + getCpf() + " e o telefone é " + getTelefone());
    }

}