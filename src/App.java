import java.util.Scanner;

import Pessoa.Atendente;
import Pessoa.Cliente;
import Pessoa.Tecnico;
import Servico.Servico;
import SolicitacaoServicos.SolicitacaoServicos;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criando/Instanciando Cliente
        Cliente cliente = new Cliente("CaioGregoratto", "99987654321", "123.456.789-11", "RuaDaCasaDele");

        //Criando/Instanciando Atendente
        Atendente atendente = new Atendente("Jamerson", "9984161516", "123.321.456.654-77");

        //Criando/Instanciando Técnico
        Tecnico tecnico = new Tecnico("SamuelTeste", "998745632215", "111.222.333-01");

        //Adicionando o tecnico na lista de técnico
        atendente.adicionarTecnico(tecnico);

        //Criando/Instanciando Serviço
        Servico servico = new Servico("DescricaoServico", 100.0);

        //Criando/Instanciando uma Solicitação de Serviço
        SolicitacaoServicos solicitacao = new SolicitacaoServicos();
        solicitacao.setCliente(cliente);
        solicitacao.setAtendente(atendente);

        //Exinbo informações da solicitação
        solicitacao.exibeInformacoes();

        //Preenchendo as despesas adicionais da solicitação
        solicitacao.despesasAdicionais();

        //Atualizando e exibindo informações atualizadas da solicitação
        //solicitacao.exibeInformacoes();

        //Verificando técnico pela classe serviço
        servico.verificarTecnico(atendente);

        //Atribuição de técnico pela classe atendente
        atendente.atribuirTecnico(solicitacao);

        //Cobrando serviço pela classe atendente
        atendente.cobrarServico();

        //Exibindo informações finais da solicitação
        solicitacao.exibeInformacoes();

        //Fechando o scanner
        scanner.close();
    }
}