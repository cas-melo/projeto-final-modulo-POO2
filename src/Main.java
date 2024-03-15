import controller.*;
import models.*;
import util.*;
import view.MenuPrincipal;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();

//        VeiculoController veiculoController = new VeiculoController();
//        AluguelController aluguelController = new AluguelController();
////        ImprimirBuscaController impressora = new ImprimirBuscaController();
//
//                                       //TESTE CADASTRO VEÍCULO //
//        Veiculo fusca = new Veiculo("Volkswagen","Fusca", TipoVeiculo.PEQUENO, null);
//        Veiculo fusca2 = new Veiculo("Volkswagen","Fusca", TipoVeiculo.PEQUENO, null);
//        Veiculo sentra = new Veiculo("Nissan","Sentra", TipoVeiculo.PEQUENO, null);
//        Veiculo ferrari = new Veiculo("Ferrari","LaFerrari", TipoVeiculo.PEQUENO, null);
//
//        veiculoController.adicionarVeiculo(fusca);
//        veiculoController.adicionarVeiculo(fusca2);
//        veiculoController.adicionarVeiculo(sentra);
//        veiculoController.adicionarVeiculo(ferrari);
//
//        List<Veiculo> veiculosCadastrados = veiculoController.listarVeiculos();
//        System.out.println("\nVeículos cadastrados:");
//        for (Veiculo veiculo : veiculosCadastrados) {
//            System.out.println("Placa: " + veiculo.getPlaca() + ", Nome: " + veiculo.getNome() + ", Tipo: " + veiculo.getTipo());
//        }
//
//                                        // TESTE CADASTRO CLIENTE //
//        PessoaFisica pessoaFisica = new PessoaFisica("João Silva",null);
//        System.out.println("\nNome: " + pessoaFisica.getNome());
//        System.out.println("CPF: " + pessoaFisica.getDocumento());
//
//        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa ABC",null);
//        System.out.println("\nNome: " + pessoaJuridica.getNome());
//        System.out.println("CNPJ: " + pessoaJuridica.getDocumento());
//
//                                        // TESTE ALUGUEL //
//        //LocalDateTime dataFim = LocalDateTime.now().plusHours(24);
//        aluguelController.realizarAluguel(fusca, pessoaFisica, "Carapicuíba"); //dataFim, 200.00);
//
//        System.out.println("\nLista de aluguéis:");
//        for (Aluguel aluguel : aluguelController.listarAlugueis()) {
//            System.out.println("Veículo: " + aluguel.getVeiculo().getNome() + ", Cliente: " + aluguel.getCliente().getNome() + ", Cidade: " + aluguel.getCidade());
//            System.out.println("Data de início: " + aluguel.getDataInicio()); //+ ", Data de fim: " + aluguel.getDataFim() + ", Valor total: " + aluguel.getValorTotal());
//        }
//
//
//        /*                             // TESTE BUSCA //
//        // Buscando veículos por nome
//        List<Veiculo> resultadoBusca = veiculoController.buscarVeiculosPorNome("r");
//        impressora.imprimirBusca(resultadoBusca);
//
//        // Paginando os veículos
//        List<Veiculo> veiculosPaginados = Paginacao.paginar(resultadoBusca, 3, 1);
//        impressora.imprimirBusca(veiculosPaginados); */
    }
}

