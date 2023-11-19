package Servico;
import java.util.InputMismatchException;
import java.util.Scanner;

import Pessoa.Atendente;

public class Servico {
    String descricao;
    double valor;

    //Fazendo quais irão ser as obrigatoriedades passadas como parâmetro
    public Servico (String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //Inserindo descrição pelo atendente
    public void inserirDescricao(Scanner scanner) {
        System.out.print("Digite a descrição do serviço: ");
        this.descricao = scanner.nextLine();
    }

    //Inserindo valor pelo atendente
    public void inserirValor(Scanner scanner) {
    try {
        System.out.print("Digite o valor do serviço: ");
        this.valor = scanner.nextDouble();
    } catch (InputMismatchException e) {
        System.out.println("Valor inválido. Insira um valor numérico.");

        //Scanner para consumir o buffer gerado
        scanner.nextLine();
    }
}

    //Criando método para verificar técnico
    public void verificarTecnico(Atendente atendente) {
        System.out.println("Verificando se há um técnico atribuído ao serviço...");
        atendente.verificandoTecnico();
    }

    //Método para exibir informação
    void exibeInformacoes() {
        System.out.println(descricao + ". E o valor do servico e de: " + valor);
    }
}